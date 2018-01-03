package lowbrain.additions.listeners;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.events.AdditionsAPIInitializationEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.listeners.custom.ArmorEquip;
import lowbrain.additions.items.dagger.*;
import lowbrain.additions.items.katana.*;
import lowbrain.additions.items.twohanded.*;
import lowbrain.additions.main.LowbrainAdditions;
import lowbrain.armorequip.ArmorEquipEvent;
import lowbrain.armorequip.ArmorType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class InitialListener implements Listener {
    @EventHandler
    public void onInitialization(AdditionsAPIInitializationEvent api) {
        api.addResourcePackFromPlugin(LowbrainAdditions.getInstance(), "LowbrainAdditions-0.0.1.zip");

        // load items

        api.addCustomItem(new EmeraldKatana());
        api.addCustomItem(new StoneKatana());
        api.addCustomItem(new IronKatana());
        api.addCustomItem(new DiamondKatana());

        api.addCustomItem(new EmeraldDagger());
        api.addCustomItem(new StoneDagger());
        api.addCustomItem(new IronDagger());
        api.addCustomItem(new DiamondDagger());

        api.addCustomItem(new EmeraldTwoHandedSword());
        api.addCustomItem(new StoneTwoHandedSword());
        api.addCustomItem(new IronTwoHandedSword());
        api.addCustomItem(new DiamondTwoHandedSword());
    }

    @EventHandler
    public void onArmorEquip(ArmorEquipEvent event) {
        if (event.isCancelled() || event.getNewArmorPiece() == null || !event.getType().equals(ArmorType.OFF_HAND))
            return;

        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (itemInHand == null || itemInHand.getType().equals(Material.AIR))
            return;

        if (AdditionsAPI.isCustomItem(itemInHand)) {
            CustomItemStack cStack = new CustomItemStack(itemInHand);
            CustomItem cItem = cStack.getCustomItem();

            if (cItem instanceof TwoHandedSword) {
                event.setCancelled(true);
                return;
            }
        }
    }

    public void onItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();

        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        ItemStack itemOffHand = player.getInventory().getItemInOffHand();

        if (itemInHand == null
                || itemInHand.getType().equals(Material.AIR)
                || itemOffHand == null
                || itemOffHand.getType().equals(Material.AIR))
            return;

        if (AdditionsAPI.isCustomItem(itemInHand)) {
            CustomItemStack cStack = new CustomItemStack(itemInHand);
            CustomItem cItem = cStack.getCustomItem();

            if (cItem instanceof TwoHandedSword) {
                // remove item from off hand and move it to inventory
                player.getInventory().setItemInOffHand(null);
                player.getInventory().addItem(itemInHand);
            }
        }
    }
}
