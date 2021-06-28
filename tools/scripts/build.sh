mcVersion=$(cat .version) || exit 1
implVersion="489"
fileName="glucose-server-$mcVersion-$implVersion-jar-with-dependencies.jar"
finalName="Glucose-$mcVersion-$implVersion.jar"
echo "Building Glucose jar for Minecraft version $mcVersion"
echo "File name should be: glucose-$mcVersion.jar"
rootPath=$(pwd)
mvn clean install
git clone https://github.com/PaperMC/Paperclip/ tools/Paperclip
cd tools/Paperclip || exit 1
 mvn clean package "-Dmcver=$mcVersion" "-Dpaperjar=$rootPath/target/$fileName" "-Dvanillajar=$rootPath/.cache/$mcVersion/server.jar" || exit 1
 cp "assembly/target/paperclip-$mcVersion.jar" "$rootPath/$finalName"
 cd ../..
echo "Done"
