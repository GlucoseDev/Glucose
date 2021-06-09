# Glucose
Implementation of [GlucoseLib](https://github.com/GlucoseDev/GlucoseLib) on Vanilla Minecraft

Thank you to [Loom](https://github.com/LoomDev/Loom) for providing some scripts.
## Prerequisites
* [Java](http://java.oracle.com/) 8
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
public class MyCommand extends GlucoseCommand {
 public void onServerCommand(CommandSender sender, String[] args, Command command) {
   sender.sendMessage(ChatColors.GREEN, "Hello!");
 }
}
```
#### In your main class serverStartEvent
```java
public void serverStartEvent(){
  glucose.registerCommand("hello").executor(new myCommand());
}
```
## Contributing
Glucose uses patches on a decompiled version of the vanilla Minecraft jar. Why? Minecraft code is [closed source](https://en.wikipedia.org/wiki/Proprietary_software), therefore we cannot distribute it.

### Modifying Glucose code
If you are modifying code by glucose (in the `src/glucose` package) then you will not need to ue patched. It is recommended that you fork this repository, make your changes, and then create a pull request.
### Modifying Minecraft code
As stated above, Minecraft is closed-source, so we cannot put source code in this repository. To contribute, you will need to use patches
#### Working with patches
What you will need to do is clone this repository, and run `./glucose d`, then copy everything in `.cache/<version>/decompiled/net` into `src/main/java/net`. Then run `./glucose p`

* Go to `src/main/java/net/minecraft` etc etc and then **make a copy** of the file you want to modify. For example, `MinecraftServerPatch.java`
* Modify the code how you desire
##### Creating your first patch
Creating patches are easy. Here's an example:

`diff -u src/main/java/net/minecraft/server/MinecraftServer.java src/main/java/net/minecraft/server/MinecraftServerPatch.java > patches/server/MinecraftServer.patch`

`diff -u /path/to/original/file.java /path/to/modified/file.java > patches/directory/FileName.java`

Recommended tutorial: https://linuxhint.com/run-patch-command-in-linux/
