# Contributing to teaql-agent-kit

First off, thank you for considering contributing to `teaql-agent-kit`!

This repository contains TeaQL Skills and documentation, a Python workspace tool, and the independently publishable context runtime under `packages/agent-context-kit/`. Keep workflow guidance and generic runtime responsibilities separate.

## Where do I go from here?

If you've noticed a typo, an outdated prompt, or have an idea for a new agent playbook, make sure to check our [Issues](https://github.com/teaql/teaql-agent-kit/issues) to see if someone else has already reported or proposed it. If not, go ahead and create one!

## Submitting a Pull Request

If you want to contribute updates to the documentation or prompts:

1. Fork the project.
2. Create your feature branch (`git checkout -b feature/new-playbook`).
3. Make your changes. Please ensure that markdown files are properly formatted.
4. Commit your changes (`git commit -am 'Add a new playbook for entity creation'`).
5. Push to the branch (`git push origin feature/new-playbook`).
6. Create a new Pull Request against our `main` branch.

## Documentation Guidelines

- Use clear and concise English.
- Use standard Markdown formatting.
- If you are adding a new playbook, please follow the structure of existing playbooks in the `playbooks/` directory.

## Runtime and workspace changes

Use Node.js 22.19+ and Python 3 for the full local check:

```sh
npm ci
npm run check
```

The root check runs the package TypeScript/Node tests, the TeaQL Skill grammar
contract, the existing Python workspace tests and the Hermes adapter tests.
Use the root lockfile for workspace development; there is no second child
lockfile. Package publishing remains explicit and independent. See
[the runtime guide](docs/context-runtime.md) for packaging and installation.

Ordinary Skill documentation users do not need the Node workspace. Do not
invoke TeaQL services or install language toolchains for parser-only changes.
