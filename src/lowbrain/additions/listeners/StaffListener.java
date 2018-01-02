package lowbrain.additions.listeners;

import com.chrismin13.additionsapi.events.item.CustomItemPlayerInteractEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import lowbrain.additions.items.staff.Fire;
import lowbrain.additions.items.staff.FirePlus;
import lowbrain.additions.items.staff.Fireball;
import lowbrain.additions.items.staff.Teleportation;
import org.bukkit.Effect;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StaffListener implements Listener {

    public final static SimpleDateFormat COOLDOWN_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @EventHandler
    public void onUse(CustomItemPlayerInteractEvent event) {
        if (event.isCancelled())
            return;

        if(!event.getPlayerInteractEvent().getAction().equals(Action.RIGHT_CLICK_AIR))
            return;

        CustomItemStack istack = event.getCustomItemStack();

        ItemMeta meta = istack.getItemStack().getItemMeta();

        List<String> lore = meta.getLore();

        Date lastUsed = null;
        Calendar canUse = Calendar.getInstance();
        canUse.add(Calendar.SECOND, -20);

        if (lore == null || lore.isEmpty())
            lore = new ArrayList<>();

        for (String l : lore) {
            if (l.startsWith("cooldown:")) {
                try {
                    lastUsed = COOLDOWN_DATE_FORMAT.parse(l.replace("cooldown: ", ""));
                } catch (Exception e){
                    lastUsed = null;
                }

                lore.remove(l);
                break;
            }
        }

        if (lastUsed != null || lastUsed.before(canUse.getTime())) {
            event.setCancelled(true);
            return;
        }

        lore.add(lore.size(), COOLDOWN_DATE_FORMAT.format(new Date()));

        CustomItem customItem = event.getCustomItem();

        /*
        if (customItem instanceof Fire || customItem instanceof FirePlus)
            onFire(event);
        if (customItem instanceof Teleportation || customItem instanceof TeleportationPlus)
            onTeleport(event);
        if (customItem instanceof Fireball || customItem instanceof FireballPlus)
            onFireball(event);
         */

        event.getCustomItemStack().reduceDurability(event.getPlayerInteractEvent().getPlayer(), 1);
    }

    private void onFire(CustomItemPlayerInteractEvent event) {
        Player player = event.getPlayerInteractEvent().getPlayer();

        Snowball fireTick = event.getPlayerInteractEvent().getPlayer().launchProjectile(Snowball.class, player.getLocation().getDirection().clone().multiply(2.5));
        fireTick.setGravity(true);
        fireTick.setCustomName("staff_fire_tick");
        fireTick.setShooter(player);
        fireTick.setFireTicks(3 * 20);
        player.getWorld().playEffect(player.getLocation(), Effect.BOW_FIRE,1,0);
    }

    private void onTeleport(CustomItemPlayerInteractEvent event) {
        Player player = event.getPlayerInteractEvent().getPlayer();

        EnderPearl enderPearl = player.launchProjectile(EnderPearl.class, player.getLocation().getDirection().clone().multiply(2));
        enderPearl.setGravity(true);
        enderPearl.setCustomName("staff_teleportation");
        enderPearl.setShooter(player);
        player.getWorld().playEffect(player.getLocation(),Effect.BOW_FIRE,1,0);
    }

    private void onFireball(CustomItemPlayerInteractEvent event) {
        Player player = event.getPlayerInteractEvent().getPlayer();

        org.bukkit.entity.Fireball fireBall = player.launchProjectile(org.bukkit.entity.Fireball.class, player.getLocation().getDirection().clone().multiply(1));
        fireBall.setCustomName("staff_fire_ball");
        fireBall.setGravity(true);
        fireBall.setShooter(player);
        player.getWorld().playEffect(player.getLocation(),Effect.BOW_FIRE,1,0);
    }

}
