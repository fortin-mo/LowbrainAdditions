package lowbrain.additions.listeners;

import com.chrismin13.additionsapi.events.AdditionsAPIInitializationEvent;
import lowbrain.additions.items.katana.*;
import lowbrain.additions.main.LowbrainAdditions;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InitialListener implements Listener {
    @EventHandler
    public void onInitialization(AdditionsAPIInitializationEvent api) {
        api.addResourcePackFromPlugin(LowbrainAdditions.getInstance(), "LowbrainAdditions-0.0.1.zip");

        // load items

        api.addCustomItem(new EmeraldKatana());
        api.addCustomItem(new StoneKatana());
        api.addCustomItem(new IronKatana());
        api.addCustomItem(new DiamondKatana());
    }
}
