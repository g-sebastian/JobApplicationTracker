# Job Application Tracker

A small Java console application to track job applications locally. The program lets you add, view, edit, update status, delete applications, and saves everything to a CSV file (`applications.csv`) in the project directory.

## Why this project is useful

- Simple personal tracker for managing job applications without external services.
- Lightweight CSV persistence for portability and easy inspection.
- Good starter project to learn basic Java I/O, collections and console interaction.

## Features

- Add a job application with company, position, location, link, date, status and notes
- View all stored applications (detailed or reduced view)
- Edit any field of an existing application
- Update application status (Saved, Applied, Interview, Rejected, Offer)
- Delete applications
- View basic statistics
- Persist applications in `applications.csv`

## Requirements

- Java 8 or newer (JDK)

## Quick start

From the project root run:

```bash
javac -d out src/*.java
java -cp out Main
```

Notes:
- The `javac` command compiles source files into the `out` directory.
- Running the program will create or update `applications.csv` in the current working directory.

## Usage

When you run the application you'll see a numbered menu. Example options:

- [1] Add new application
- [2] View all applications
- [3] Update application status
- [4] Edit application
- [5] Delete application
- [6] View statistics
- [7] Save and exit

Follow the interactive prompts to manage entries. IDs shown in lists are zero-based and are used for edit/delete operations.

## Data format

Applications are stored in `applications.csv` using a semicolon-separated format with header:

```
id;company;position;location;jobLink;applicationDate;status;notes
```

## Where to get help

- Open an issue in the repository's Issues tab for bugs or feature requests.
- Submit a pull request with improvements or fixes.

## Contributing

Contributions are welcome. A simple workflow:

1. Fork the repository
2. Create a feature branch
3. Make changes and add tests (if applicable)
4. Open a pull request describing your changes

If you want a `CONTRIBUTING.md` or CI setup added, open an issue or request it via PR.

## Maintainers

Maintained by the repository owner. Contributions and issues are welcome.

## License

No license file found in this repository. If you want to add a license, create a `LICENSE` file in the project root.

## Known limitations & next steps

- Data is stored as a plain CSV; consider migrating to a small embedded DB for robustness.
- IDs are list-index based and will shift when items are deleted — consider a stable unique id.
- No import/export beyond CSV; no concurrency handling.

If you'd like, I can add a `CONTRIBUTING.md`, a `LICENSE`, or a simple GitHub Actions workflow to run basic checks.
