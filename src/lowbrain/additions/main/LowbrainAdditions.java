package lowbrain.additions.main;

import lowbrain.additions.listeners.InitialListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LowbrainAdditions extends JavaPlugin {
    private static JavaPlugin instance;

    public void onEnable() {
        LowbrainAdditions.instance = this;
        PluginManager pluginManager = this.getServer().getPluginManager();

        pluginManager.registerEvents(new InitialListener(), this);

    }

    public static JavaPlugin getInstance() {
        return LowbrainAdditions.instance;
    }
}
