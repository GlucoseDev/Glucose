#!/bin/bash

# Credit to LoomDev for providing most of this script

mcVersion="1.16.5"

if [ $mcVersion == "1.16.5" ]; then
	mkdir .cache
	mkdir .cache/1.16.5
	curl -L https://launcher.mojang.com/v1/objects/41285beda6d251d190f2bf33beadd4fee187df7a/server.txt > .cache/$mcVersion/server.txt 
	curl -L https://launcher.mojang.com/v1/objects/1b557e7b033b583cd9f66746b7a9ab1ec1673ced/server.jar > .cache/$mcVersion/server.jar
fi

printf "Converting $mcVersion Minecraft mappings..."
#echo "tools/jars/enigma/*" "cuchaz.enigma.command.Main" convert-mappings proguard ".cache/$mcVersion/server.txt" tinyv2:obf:deobf ".cache/$mcVersion/server.tiny"
java -cp "tools/jars/enigma/*" "cuchaz.enigma.command.Main" convert-mappings proguard ".cache/$mcVersion/server.txt" tinyv2:obf:deobf ".cache/$mcVersion/server.tiny" || exit 1
printf " Done!\n"
 
printf "Mapping $mcVersion Minecraft server jar...\n"
java -jar "tools/jars/tiny-remapper-0.3.1.72-fat.jar" ".cache/$mcVersion/server.jar" ".cache/$mcVersion/server-deobf.jar" ".cache/$mcVersion/server.tiny" obf deobf --renameInvalidLocals || exit 1

printf "Installing $mcVersion mapped Minecraft server jar in your local maven repo..."
mvn install:install-file -Dfile=".cache/$mcVersion/server-deobf.jar" -DgroupId="glucose" -DartifactId="minecraft-server" -Dversion="$mcVersion-SNAPSHOT" -Dpackaging="jar" > /dev/null
printf " Done!\n"

printf "Extracting $mcVersion mapped Minecraft server jar..."
unzip -o ".cache/$mcVersion/server-deobf.jar" "net/**/*" -d ".cache/$mcVersion/extracted/" > /dev/null
printf " Done!\n"

printf "Decompiling $mcVersion mapped Minecraft source...\n"
mkdir -p ".cache/$mcVersion/decompiled/"
java -jar "tools/jars/fernflower.jar" -dgs=1 -hdc=0 -rbr=0 -asc=1 -udv=0 ".cache/$mcVersion/extracted/" ".cache/$mcVersion/decompiled/"
printf "Done!\n"
