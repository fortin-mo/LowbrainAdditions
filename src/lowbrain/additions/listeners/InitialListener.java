package lowbrain.additions.listeners;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.events.AdditionsAPIInitializationEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import lowbrain.additions.items.dagger.*;
import lowbrain.additions.items.katana.*;
import lowbrain.additions.items.twohanded.*;
import lowbrain.additions.main.LowbrainAdditions;
import lowbrain.armorequip.ArmorEquipEvent;
import lowbrain.armorequip.ArmorType;
import lowbrain.armorequip.MainHandEvent;
import lowbrain.armorequip.MainHandListener;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onArmorEquip(ArmorEquipEvent event) {
        if (event.isCancelled()
                || event.getNewArmorPiece() == null
                || !(event.getType().equals(ArmorType.OFF_HAND) || event.getType().equals(ArmorType.SHIELD)))
            return;

        Player player = event.getPlayer();
        ItemStack inHand = player.getInventory().getItemInMainHand();
        ItemStack offHand = event.getNewArmorPiece();

        CustomItem customItem = getCustomItem(offHand);

        if (customItem != null && customItem instanceof TwoHandedSword) {
            // cannot wear two handed sword in off hand, cancel event
            event.setCancelled(true);
            return;
        }

        if (inHand == null || inHand.getType().equals(Material.AIR))
            return;

        customItem = getCustomItem(inHand);

        if (customItem != null && customItem instanceof TwoHandedSword) {
            // cannot wear off hand item while holding a two handed sword
            event.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public final void onHeldItemChanged(final MainHandEvent e) {
        if (e.isCancelled())
            return;

        Player player = e.getPlayer();

        ItemStack newItem = e.getNewItem();

        if (newItem == null)
            return;

        CustomItem cItem = getCustomItem(newItem);

        ItemStack offHand = player.getInventory().getItemInOffHand();

        if (cItem != null && cItem instanceof TwoHandedSword) {
            // remove item from off hand and move it to inventory
            player.getInventory().setItemInOffHand(null);
            player.getInventory().addItem(offHand);
        }
    }

    private CustomItem getCustomItem(ItemStack i) {
        CustomItem c = null;

        if (AdditionsAPI.isCustomItem(i)) {
            CustomItemStack cStack = new CustomItemStack(i);
            CustomItem cItem = cStack.getCustomItem();

            c = cItem;
        }

        return c;
    }

}
