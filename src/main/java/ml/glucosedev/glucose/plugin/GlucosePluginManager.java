package ml.glucosedev.glucose.plugin;

import java.util.ArrayList;

public class GlucosePluginManager {
    public static ArrayList<String> pluginNames = new ArrayList<>();
//    private ArrayList<Plugin> plugins = new ArrayList<>(); // (api doesn't have Plugin class yet for some reason??)

    public static String getPluginNames() {
        return pluginNames.toString().replace("[", "").replace("]", "");
    }
}
