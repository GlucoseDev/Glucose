# Glucose
Implementation of [GlucoseLib](https://github.com/GlucoseDev/GlucoseLib) on Vanilla Minecraft

## Prerequisites
* [Java](http://java.oracle.com/) 8 (1.16.5 and below)
* [Java](http://java.oracle.com/) 16 (1.17+)
## How to for server admins
No jars are currently available.

To compile:
* Run `./glucose d`
* Copy everything in `.cache/<version>/decompile/net` into `src/main/java/net`
* Run `mvn clean package`

Make sure you have [Maven](https://maven.apache.org/) installed.
## How to for plugin developers
**DISCLAIMER: THE API HAS NOT BEEN CREATED YET, THE FOLLOWING CODE IS A DRAFT**
### Basic command
#### MyCommand Class
```java
public class MyCommand {
    @Command(
            aliases = { "hello" },
            description = "My Command",
            permissions = { "my.permission.node" },
    )
    public void helloCommand(CommandSender sender, String[] args){
        sender.send("Hello!");
  }
}
```
#### In your main class serverStartEvent
```java
public void serverStartEvent() {
  Glucose.commands().registerCommand(new MyCommand());
}
```
## Contributing
Glucose uses patches on a decompiled version of the vanilla Minecraft jar. Why? Minecraft code is [closed source](https://en.wikipedia.org/wiki/Proprietary_software), therefore we cannot distribute it.

### Modifying Glucose code
If you are modifying code by glucose (in the `src/glucose` package) then you will not need to use patches. It is recommended that you fork this repository, make your changes, and then create a pull request.
### Modifying Minecraft code
As stated above, Minecraft is closed-source, so we cannot put source code in this repository. To contribute, you will need to use patches
#### Working with patches
What you will need to do is clone this repository, and run `./glucose d`, then copy everything in `.cache/<version>/decompiled/net` into `src/main/java/net`. Then run `./glucose p`

* Modify the code how you desire
##### Creating your first patch
Creating patches are easy. Here's an example:

`diff -u .cache/1.16.5/decompiled/net/minecraft/server/dedicated/DedicatedServer.java src/main/java/net/minecraft/server/dedicated/DedicatedServer.java > patches/server/dedicated/DedicatedServer.patch`

As you can see, the patches directory is structured from `src/main/net/minecraft`, so if your file was in `src/main/net/minecraft/server`, you would put it in `patches/server`

`diff -u .cache/<version>/decompiled/net/minecraft/File.java /path/to/modified/File.java > patches/directory/File.patch`

Recommended tutorial: https://linuxhint.com/run-patch-command-in-linux/
## Thanks to
- [Loom](https://github.com/LoomDev/Loom) - Providing scripts
