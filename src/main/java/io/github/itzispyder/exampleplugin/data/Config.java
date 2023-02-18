/**
 * This file is for tutorial purposes made by ImproperIssues. Distribute if you want :)
 */

package io.github.itzispyder.exampleplugin.data;

import io.github.itzispyder.exampleplugin.ExamplePlugin;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Config loader
 */
public abstract class Config {

    public static final FileConfiguration config = ExamplePlugin.getInstance().getConfig();
    public static int choice(int min, int max) {
        return min + (int) Math.floor(Math.random() * (max - min));
    }

    /**
     * Config plugin section
     */
    public class Plugin {
        public static String getPrefix() {
            return config.getString("config.plugin.prefix");
        }
        public static final Integer delay = config.getInt("config.plugin.delay");
        public static final Set<String> options = config.getConfigurationSection("config.plugin.messages").getKeys(false);
    }
}
