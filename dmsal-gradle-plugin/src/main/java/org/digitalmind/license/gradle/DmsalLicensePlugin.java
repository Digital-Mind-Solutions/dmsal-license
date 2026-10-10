package org.digitalmind.license.gradle;

import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.DuplicatesStrategy;
import org.gradle.api.file.RegularFile;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.jvm.tasks.Jar;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Registers {@code fetchDmsalLicense} (reads the single DMSAL text embedded in this plugin jar)
 * and optionally packs {@code META-INF/LICENSE.md} into the consumer project jar.
 * <p>
 * Use plugin version to select the licence line, e.g. {@code id 'org.digitalmind.dmsal-license' version '1.0'}.
 */
public class DmsalLicensePlugin implements Plugin<Project> {

    public static final String EXTENSION_NAME = "dmsalLicense";
    public static final String FETCH_TASK_NAME = "fetchDmsalLicense";

    /** Single embedded text per plugin jar (one plugin version ↔ one DMSAL folder). */
    public static final String EMBEDDED_RESOURCE = "/META-INF/dmsal/LICENSE.md";

    @Override
    public void apply(Project project) {
        DmsalLicenseExtension extension = project.getExtensions().create(EXTENSION_NAME, DmsalLicenseExtension.class);
        project.afterEvaluate(p -> configure(p, extension));
    }

    private void configure(Project project, DmsalLicenseExtension extension) {
        Provider<RegularFile> staged = project.getLayout().getBuildDirectory().file("dmsal/LICENSE.md");

        TaskProvider<?> fetch = project.getTasks().register(FETCH_TASK_NAME, task -> {
            task.setGroup("build");
            task.setDescription(
                    "Stage embedded META-INF/dmsal/LICENSE.md from this plugin jar into build/dmsal/"
            );
            task.getInputs().property("dmsalLicense.resource", EMBEDDED_RESOURCE);
            task.getOutputs().file(staged);
            task.doLast(t -> stageLicenseFromPluginClasspath(project, staged.get().getAsFile()));
        });

        if (!extension.isPackageIntoJar()) {
            return;
        }

        // java-library applies java — register once only (avoids duplicate META-INF/LICENSE.md).
        project.getPlugins().withId("java", plugin -> wireJar(project, fetch, staged));
    }

    private void wireJar(Project project, TaskProvider<?> fetch, Provider<RegularFile> staged) {
        project.getTasks().named("jar", Jar.class, jar -> {
            jar.dependsOn(fetch);
            jar.setDuplicatesStrategy(DuplicatesStrategy.EXCLUDE);
            jar.metaInf(metaInf -> {
                metaInf.from(staged);
                metaInf.rename(name -> "LICENSE.md");
            });
        });
    }

    private static void stageLicenseFromPluginClasspath(Project project, File dest) {
        try (InputStream in = DmsalLicensePlugin.class.getResourceAsStream(EMBEDDED_RESOURCE)) {
            if (in == null) {
                throw new GradleException(
                        "Embedded DMSAL text not found in plugin jar: " + EMBEDDED_RESOURCE
                                + ". Rebuild the matching org.digitalmind.dmsal-license plugin version."
                );
            }
            Files.createDirectories(dest.toPath().getParent());
            Files.copy(in, dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new GradleException("Failed to stage DMSAL licence to " + dest.getAbsolutePath(), e);
        }

        if (dest.length() == 0L) {
            throw new GradleException("Staged DMSAL LICENSE.md is empty (resource " + EMBEDDED_RESOURCE + ")");
        }

        project.getLogger().lifecycle(
                "Staged DMSAL licence from plugin classpath {} -> {}",
                EMBEDDED_RESOURCE,
                dest.getAbsolutePath()
        );
    }
}
