mcVersion=$(cat .version) || exit 1
  echo "Applying patches to $mcVersion decompiled source..."

    if [ ! -d ".cache/$mcVersion/decompiled/" ]
    then
        echo ""
        echo "No decompiled directory found for $mcVersion"
        echo "Make sure that you have ran './glucose decompile'"
        exit 1
    fi

    #rm -rf "./server/src/main/java/net/minecraft/"
    for patchFile in $(find "./patches/" -name "*.patch")
    do
        patchFileClean=${patchFile#"./patches/"}
        javaFile1="$(echo $patchFileClean | cut -d. -f1)"
	echo $javaFile1
	javaFile="$javaFile1.java"
	#javaFile=$(sed -e "s/patch/java/" "echo $patchFileClean")
	echo "Java file: $javaFile | patch file: $patchFile"
	echo "pfc: $patchFileClean"

        if [ -f ".cache/$mcVersion/decompiled/net/minecraft/$javaFile" ]
        then
            strip_cr ".cache/$mcVersion/decompiled/net/minecraft/$javaFile"
            mkdir -p "$(dirname "./src/main/java/net/minecraft/$javaFile")"
            cp ".cache/$mcVersion/decompiled/net/minecraft/$javaFile" "src/main/java/net/minecraft/$javaFile"
            patch -d "src/main/java/" "net/minecraft/$javaFile" < "$patchFile"
        fi
    done

    echo "Done!"
