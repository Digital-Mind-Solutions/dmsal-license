# DMSAL — Digital Mind Source-Available License

Canonical public texts of the **Digital Mind Source-Available License (DMSAL)**.

| | |
|--|--|
| Instrument | Digital Mind Source-Available License (**DMSAL**) |
| Current version | **1.0** |
| Effective (v1.0) | 1 January 2020 |
| Full text (v1.0) | [`v1.0/LICENSE.md`](v1.0/LICENSE.md) |
| NOTICE template | [`NOTICE.template`](NOTICE.template) (Schedule B) |

Public Source Code under DMSAL is for **inspection only**. **Use** requires Articles **5**, **6**, or **9** of the licence text that accompanies the distribution.

## Layout

```text
dmsal-license/
  settings.gradle / build.gradle   # Gradle library org.digitalmind.license:dmsal-license:1.0
  README.md
  NOTICE.template
  v1.0/LICENSE.md                  # DMSAL v1.0 (immutable after release)
```

- **One folder per DMSAL version** on `main` (not version branches).
- After a version is published, **do not edit** that folder; publish the next version as a new folder.
- Prefer Git **tags** (`v1.0`, `v1.1`, …) on the commit that freezes that text, so consumers can pin a URL.

## How other repositories should consume this

### Gradle composite (recommended for Digital Mind building blocks)

1. Clone this repo as a **sibling** of the product repo (e.g. `…/JAVA/dmsal-license` next to `…/JAVA/buildingblocks-i18n`).
2. In the product `settings.gradle`:
   ```gradle
   includeBuild('../dmsal-license')
   ```
3. Depend on `org.digitalmind.license:dmsal-license:1.0` (custom configuration), stage `META-INF/LICENSE.md` from that jar into the product jar.  
   Without the sibling clone, Gradle **fails at configuration** — that is intentional.

Coordinates: **`org.digitalmind.license:dmsal-license:1.0`** — JAR contains only `META-INF/LICENSE.md` (from `v1.0/LICENSE.md`).

### Build all licence jars

```bash
./gradlew build         # clean, then all licence jars
./gradlew licenseJars   # jars only (no clean)
```

Discovers every `vX.Y/LICENSE.md` and writes `build/libs/dmsal-license-X.Y.jar`.  
`project.version` in `build.gradle` (currently **1.0**) is the default artefact for `includeBuild` consumers; bump it when the “current” DMSAL line changes (and add `v1.1/` etc. as new folders).

### Docs / pointer

- Product README: link  
  `https://github.com/Digital-Mind-Solutions/dmsal-license/blob/v1.0/v1.0/LICENSE.md`
- Optional `NOTICE`: copy [`NOTICE.template`](NOTICE.template), set `Artifact:`.
- Schedule C header: `See LICENSE`.

Art. 14.3 allows a clear pointer; composite build packs the text into published JARs without copying LICENSE into each product git tree.

## Versioning policy

| Rule | Detail |
|------|--------|
| Folder name | `v<major>.<minor>` matching the **Version** line inside `LICENSE.md` |
| Immutability | Published folders are frozen (Art. 15.5 — a distribution stays on the text that accompanied it) |
| Patches | Rare; use `v1.0.1` only for critical errata of the same line, or document errata in this README |
| Next line | Add `v1.1/` when DMSAL 1.1 is issued; update “Current version” above |

## Owners

Full Owners under DMSAL: **DIGITAL SOLUTIONS EXPERT S.R.L.** and **MIND STUDIO S.R.L.**  
“Digital Mind” is branding only.

## Rezumat (RO) — informativ

Acest rezumat este doar un ajutor de citire: **nu** face parte din licență. Nu creează, nu modifică și nu înlocuiește drepturi. Dacă rezumatul și [`v1.0/LICENSE.md`](v1.0/LICENSE.md) diferă, **contează doar textul englez** din `LICENSE.md` (Art. 15.4).

- **Digital Mind** = branding comun (nu persoană juridică).
- **Copyright:** fiecare Full Owner pe contribuțiile sale; oricare poate comercializa singur (**Independent Commercialization Authority**).
- **Repo public:** inspection only; **Use** doar prin Art. 5–6 (Qualifying Delivery) sau Art. 9.
- **Qualifying Delivery:** Contributor + Delivery Record (versiuni listate + SBOM minim + DMSAL/NOTICE) + nu Software-Primary → sublicență de Use **doar** pe versiunile livrate, **în** Client Software-ul livrat (fără extragere / refolosire în alte produse).
- **Art. 9** pentru OEM, Software-Primary, redistribuire standalone / predare codebase către alt vendor.
- **Indemnity IP / răspundere:** default pe fees (IP = 2× fees pe 12 luni); orice floor sau alt plafon doar în SCL sau engagement/master semnat.
- Prevalează engleza (Art. 15.4).
