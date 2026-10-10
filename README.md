# DMSAL — Digital Mind Source-Available License

Canonical DMSAL texts. **No product version line** on this repo: each `vX.Y/LICENSE.md` is discovered dynamically and published as its **own** Gradle plugin artefact.

| | |
|--|--|
| Instrument | Digital Mind Source-Available License (**DMSAL**) |
| Texts | [`v1.0/LICENSE.md`](v1.0/LICENSE.md), … |
| NOTICE | [`NOTICE.template`](NOTICE.template) |
| Plugin id | **`org.digitalmind.dmsal-license`** |

Public Source Code: **inspection only**. **Use**: Articles **5**, **6**, or **9**.

## Layout

```text
dmsal-license/
  v1.0/LICENSE.md              # → plugin Maven version 1.0
  v1.1/LICENSE.md              # → plugin Maven version 1.1 (when you add the folder)
  dmsal-gradle-plugin/         # builds/publishes one jar per folder
```

## Model (dynamic)

| What you add | What you get |
|--------------|--------------|
| `vX.Y/LICENSE.md` | `dmsal-gradle-plugin-X.Y.jar` with that text as `META-INF/dmsal/LICENSE.md` |
| `./gradlew publishToMavenLocal` | All discovered `X.Y` published to `~/.m2` (plugin + marker) |

Consumers pick the licence by **plugin version**, not by a “current” flag in this repo:

```gradle
plugins {
    id 'org.digitalmind.dmsal-license' version '1.0'   // or '1.1', …
}
```

## Consumer (recommended)

1. In this repo: `./gradlew publishToMavenLocal`
2. In the product repo:

```gradle
pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        // … GitHub Packages if you publish remotely later
    }
}
```

```gradle
plugins {
    id 'org.digitalmind.dmsal-license' version '1.0'
}
dmsalLicense {
    packageIntoJar = true
}
```

Optional while hacking the plugin code: `includeBuild('../dmsal-license')` — Gradle still needs some `project.version`; prefer **mavenLocal** for normal use.

## Build / publish

```bash
./gradlew build                # clean + one jar per v*/
./gradlew publishToMavenLocal  # all licence-line plugins → ~/.m2
```

IDEA → **publishing**: only root `publishToMavenLocal`.

## Owners

**DIGITAL SOLUTIONS EXPERT S.R.L.** and **MIND STUDIO S.R.L.** — “Digital Mind” branding only.

## Rezumat (RO) — informativ

Fără efect juridic. Textul operativ e EN din `vX.Y/LICENSE.md`.
