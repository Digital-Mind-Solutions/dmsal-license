package org.digitalmind.license.gradle;

/**
 * Configuration for {@code org.digitalmind.dmsal-license}.
 * <p>
 * The plugin <em>version</em> (e.g. {@code id '... ' version '1.0'}) selects which DMSAL text was
 * embedded at build time. There is no separate licence-version property.
 */
public class DmsalLicenseExtension {

    /**
     * When true and the Java plugin is applied, wire {@code fetchDmsalLicense} into the {@code jar} task
     * so {@code META-INF/LICENSE.md} is packaged automatically.
     */
    private boolean packageIntoJar = true;

    public boolean isPackageIntoJar() {
        return packageIntoJar;
    }

    public void setPackageIntoJar(boolean packageIntoJar) {
        this.packageIntoJar = packageIntoJar;
    }
}
