package lowbrain.additions.items.katana;

import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldKatana extends Katana {
    public EmeraldKatana () {
        super(DamageableItem.DIAMOND_SWORD,"lowbrain_additions:emerald_katana", "emerald_katana", "Emerald Katana",3123);

        this.addAttackDamage(DamageableItem.DIAMOND_SWORD.getAttackDamage() * 1.25);
        this.addAttackSpeed(DamageableItem.DIAMOND_SWORD.getAttackSpeed() * 1.125);

        loadRecipe(Material.EMERALD);
    }
}
