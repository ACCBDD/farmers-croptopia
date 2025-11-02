name: Bug Report
description: File a bug report.
labels: ["bug"]
body:
- type: checkboxes
  id: unique-issue
  attributes:
  label: Please confirm the following
  options:
  - label: This bug is not in another [current issue](https://github.com/ACCBDD/farmers-croptopia/issues)
  required: true
  - label: This report is not a general support request. If it is, join the [Discord](https://discord.com/invite/kVj8w5ne46)
  required: true
- type: dropdown
  id: mc-version
  attributes:
  label: Minecraft Version
  description: What version of minecraft are you using?
  options:
  - 1.20.1
  - 1.21.1
    default: 0
    validations:
    required: true
- type: input
  id: mod-version
  attributes:
  label: Mod version
  description: Which version of the mod did the bug occur on?
  placeholder: (e.g. 1.0.9)
  validations:
  required: true
- type: textarea
  id: bug-description
  attributes:
  label: Describe the bug
  description: What happened? How? Give as much detail as you can about the bug, including screenshots if possible.
  validations:
  required: true
- type: input
  id: log
  attributes:
  label: Game Log
  description: If applicable, provide a link to your log on a paste site such as [Gist](https://gist.github.com/) or [mclo.gs](https://mclo.gs/).
  validations:
  required: false
