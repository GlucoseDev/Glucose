# Glucose
Glucose is a Minecraft server software and API which provides plugins.
Thank you to [Loom](https://github.com/LoomDev/Loom) for providing some scripts.
## Prerequisites
* [Java](http://java.oracle.com/) 8
## How to for server admins
Currently, no builds are available, so you will have to compile from source.
Once you have compiled, run it like you would any other jar.
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
