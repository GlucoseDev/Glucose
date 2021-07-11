![logo](https://glucosedev.ml/resources/glucose-banner-fixed_morecenter-removebg-preview.png)
--
[![CI Status](https://github.com/GlucoseDev/Glucose/workflows/Java%20CI%20With%20Gradle/badge.svg)](https://github.com/GlucoseDev/Glucose/actions)
[![GitHub contributors](https://img.shields.io/github/contributors/GlucoseDev/Glucose.svg)](https://GitHub.com/GlucoseDev/Glucose/graphs/contributors/)
[![Discord](https://img.shields.io/discord/850534433274462220.svg?label=&logo=discord&logoColor=ffffff&color=7389D8&labelColor=6A7EC2)](https://discord.gg/nMGg42rnt3)
[![GitHub license](https://img.shields.io/github/license/GlucoseDev/Glucose.svg)](https://github.com/GlucoseDev/Glucose/blob/1.16.5-Sticky/LICENSE)

Implementation of [GlucoseLib](https://github.com/GlucoseDev/GlucoseLib) on Vanilla Minecraft and a bunch more.

**Currently under heavy development, if you wish to use this mod for production then it is recommended you do not!**

## Prerequisites
* [Java](http://java.oracle.com/) 11 (1.16.5 and below)
* [Java](http://java.oracle.com/) 16 (1.17+)
## How to for server admins
- Download from [releases](https://glucosedev.ml/releases/)
- Run it like any other jar file
## Contributing
Contributing is always open! :D

Glucose uses patches on a decompiled version of the vanilla Minecraft jar. Why? Minecraft code is [proprietary](https://en.wikipedia.org/wiki/Proprietary_software), therefore we cannot distribute it.

### Modifying Glucose code
If you are modifying code by glucose (in the `src/glucose` package) then you will not need to use patches. It is recommended that you fork this repository, make your changes, and then create a pull request.
### Modifying Minecraft code
As stated above, Minecraft is closed-source, so we cannot put source code in this repository. To contribute, you will need to use patches
#### Working with patches
What you will need to do is clone this repository, and run `./glucose d`, then copy everything in `.cache/<version>/decompiled/net` into `src/main/java/net`. Then run `./glucose p`

* Modify the code how you desire
##### Creating your first patch
You can just run `./glucose rbp` to make patches.
## Building
```bash
git clone git@github.com:GlucoseDev/Glucose.git
cd Glucose
./glucose decompile
./glucose patch
gradle build
```
Make sure you have [Gradle](https://gradle.org/) installed.

You might need to do some tinkering to get it to work sometimes.
## Thanks to
- [Loom](https://github.com/LoomDev/Loom) - Providing scripts and a bunch of base code
- [CanaryMod](https://github.com/CanaryModTeam/CanaryMod) - A bunch of base code for Lib
