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
  README.md           # this index
  NOTICE.template     # Schedule B — fill Artifact: <name> per product
  v1.0/
    LICENSE.md        # DMSAL v1.0 (immutable after release)
  v1.1/               # add only when a new DMSAL version is published
    LICENSE.md
```

- **One folder per DMSAL version** on `main` (not version branches).
- After a version is published, **do not edit** that folder; publish the next version as a new folder.
- Prefer Git **tags** (`v1.0`, `v1.1`, …) on the commit that freezes that text, so consumers can pin a URL.

## How other repositories should cite this

1. **Copy** `v1.0/LICENSE.md` into the product repo as `LICENSE.md` (recommended for clones, JARs, Qualifying Delivery).
2. In the product README, link the canonical text, e.g.  
   `https://github.com/Digital-Mind-Solutions/dmsal-license/blob/v1.0/v1.0/LICENSE.md`  
   (tag preferred over `main`).
3. Optional product `NOTICE`: copy [`NOTICE.template`](NOTICE.template) and set `Artifact:` to the module name (e.g. `templating-core`).
4. Schedule C copyright header in source: end with `See LICENSE` (file on disk remains `LICENSE.md`).

Art. 14.3 allows a clear pointer instead of a full local copy; a local `LICENSE.md` is still preferred for offline and delivery packages.

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
