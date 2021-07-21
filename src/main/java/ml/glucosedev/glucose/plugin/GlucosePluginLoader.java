package ml.glucosedev.glucose.plugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class GlucosePluginLoader {
    static Logger j = LogManager.getLogger();
    public GlucosePluginLoader() throws IOException {
        j.info("Loading plugins...");
        File pluginDir = new File("./plugins/");
        if (!pluginDir.exists()) {
            j.info("Plugins directory does not exist, creating...");
            pluginDir.mkdirs();
            j.info("Created plugins directory");
        }
        File[] plugins = pluginDir.listFiles();

        assert plugins != null;
        for (File file : plugins) {
            j.info("Loading plugin: " + file.getName());
            if (!file.getName().endsWith(".jar")) {
                j.info("Ignoring file " + file.getName() + ", not jar file");
                continue;
            } else {
                ZipFile zip = new ZipFile(file);
                if (zip.getEntry("glucose.inf") == null) {
                    if (zip.getEntry("Canary.inf") != null) {
                        j.warn("CanaryMod plugins are not supported on Glucose, ignoring jar file " + file.getName());
                        continue;
                    } else if (zip.getEntry("plugin.yml") != null) {
                        j.warn("Bukkit/Spigot plugins are not supported on Glucose, ignoring jar file " + file.getName());
                        continue;
                    } else if (zip.getEntry("bungee.yml") != null) {
                        j.warn("BungeeCord plugins are not supported on Glucose, ignoring jar file {}", file.getName());
                        continue;
                    } else {
                        j.warn("Could not find glucose.inf in jar file " + file.getName() + ", ignoring");
                        continue;
                    }
                } else {
                    try {
                        ZipEntry inf = zip.getEntry("glucose.inf");
                        // inf returns "glucose.inf"
                        InputStream infInputStream = zip.getInputStream(inf);
                        InputStreamReader infInputData = new InputStreamReader(infInputStream);
                        BufferedReader br = new BufferedReader(infInputData);
                        StringBuilder infDataSb = new StringBuilder();
                        String read;
                        while ((read=br.readLine()) != null) {
                            infDataSb.append(read).append("\n");
                        }
                        String infData = infDataSb.toString();
                        // should work but like it's bad but who cares :P
                        Properties infProp = new Properties();
                        infProp.load(new StringReader(infData));
                        //j.info("Debug: {}", infData);
                        j.info("Main class: {}", infProp.getProperty("main-class"));
                        j.info("Plugin name: {}", infProp.getProperty("name"));
                        j.info("Plugin ID: {}", infProp.getProperty("id"));
                    } catch(NumberFormatException e) {
                        j.error(e);
                        j.error("Could not load plugin {}", file.getName());
                        String[] spl = file.getName().split(".jar");
                        File stackLog = new File("./glucose-plugin-crashreports/"+spl[0]+"/error.txt");
                        j.info("Saving stack trace to: {}", stackLog.getPath());
                        File stackLogDir = new File("./glucose-plugin-crashreports/"+spl[0]);
                        stackLogDir.mkdirs();
                        try {
                            FileWriter fw = new FileWriter(stackLog);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(Arrays.toString(e.getStackTrace()));
                            bw.close();
                        } catch(IOException ex) {
                            j.fatal("Could not write to file {} !!!", stackLog.getPath());
                            j.fatal(ex);
                        }
                    }
                    /*
                    Path infPath = Paths.get(String.valueOf(new File(inf.getName())));
                    //j.info(infPath);
                    Path out = Paths.get("./glucose_plugins/tmp/currentPlugin/glucose.inf");
                    //j.info(out);
                    File outDir = new File("./glucose_plugins/tmp/currentPlugin/");
                    outDir.mkdirs();
                    try (FileSystem fileSystem = FileSystems.newFileSystem(zip, null)) {
                        Files.copy(infPath, out);
                    }gl
                    */
                }
            }
        }
    }
}
