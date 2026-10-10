# Quack

A small Minecraft mod for **Minecraft 1.21.1** using **NeoForge 21.1.235**.

## Features

- Adds a rubber duck that plays a quack sound when used.
- Plays a short squash animation while the duck is used.
- Lets server owners enable or disable the chat message with the `show_quack_message` server configuration option.
- Adds the duck to the **Tools & Utilities** creative tab.
- Includes a crafting recipe using dried kelp and yellow dye.
- Includes English and Russian translations.

## Building from source

Install JDK 21, open a terminal in the project directory, and run:

- Windows: `.\gradlew.bat build`
- Linux/macOS: `./gradlew build`

The built mod JAR will be in `build/libs/`.

## License

Quack's original source code and assets authored for this project are licensed under the MIT License; see [LICENSE](LICENSE). Files inherited from the NeoForge MDK template retain the license terms in [TEMPLATE_LICENSE.txt](TEMPLATE_LICENSE.txt). Minecraft and any other third-party assets are not relicensed by this project.

## Development

This project uses NeoForge/NeoGradle. See the [NeoForge documentation](https://docs.neoforged.net/) for development details.
