# findpkg

**findpkg** is a lightweight, cross-platform command-line tool written in Java that detects installed programs and displays their versions.

Designed for developers who want a simple way to check whether a programming language, runtime, or development tool is available on their system.

## Features

- Detect installed programs using the system PATH.
- Display installed program versions.
- Simple and lightweight CLI interface.
- Built with Java 21 and Gradle.
- No external Java dependencies.
- Designed for Linux and Windows.
- Supports common developer tools such as Node.js, Python, Git, Java, Rust, and more.

## Requirements

- Java 21 or newer
- Linux or Windows
- Gradle Wrapper included for building from source

## Installation

### Build from source

Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/findpkg.git
cd findpkg
```

Build the project:

**Linux:**

```bash
./gradlew clean build
./gradlew installDist
```

**Windows:**

```powershell
.\gradlew.bat clean build
.\gradlew.bat installDist
```

## Usage

### Search for an installed program

```bash
findpkg search node
```

Example output:

```text
Package: node
Status: Installed
Version: v26.13.0
```

If a program is not found or its version cannot be determined:

```text
Package: example
Status: Not installed or unavailable
```

### Run without global installation

**Linux:**

```bash
./build/install/findpkg/bin/findpkg search node
```

**Windows:**

```powershell
.\build\install\findpkg\bin\findpkg.bat search node
```

### More examples

```bash
findpkg search python
findpkg search java
findpkg search git
findpkg search rust
findpkg search npm
```

## Supported tools

The current version includes predefined version commands for:

| Tool | Command |
|---|---|
| Node.js | `node --version` |
| Python | `python3 --version` |
| Java | `java -version` |
| Git | `git --version` |
| Rust | `rustc --version` |
| Cargo | `cargo --version` |
| npm | `npm --version` |

Unknown tools are checked using the `--version` argument.

## How it works

findpkg uses Java's `ProcessBuilder` to execute version-check commands.

1. The user enters a program name.
2. findpkg looks up the appropriate version command.
3. The command is executed on the local system.
4. The program displays its installation status and version information.

**Note:** findpkg is not a package manager. It does not install, update, or remove software. It checks executable programs accessible through the system PATH. Some installed programs may not be detected if they use unsupported version commands.

## Roadmap

- [x] Basic CLI interface
- [x] Program version detection
- [x] Gradle build system
- [x] Linux testing
- [ ] Windows testing and compatibility improvements
- [ ] Improved automatic program detection
- [ ] JSON output support
- [ ] Additional version command definitions
- [ ] Global installation scripts

## Contributing

Contributions, bug reports, and feature suggestions are welcome.

Feel free to open an issue or submit a pull request.

## License
[MIT](https://github.com/Bloby22/findpkg/blob/main/LICENSE)
