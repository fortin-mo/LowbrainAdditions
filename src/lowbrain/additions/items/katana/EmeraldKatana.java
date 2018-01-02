package lowbrain.additions.items.katana;

import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldKatana extends Katana {
    public EmeraldKatana () {
        super(DamageableItem.DIAMOND_SWORD,"modified_additions:emerald_katana", "emerald_katana", "Emerald Katana",3123);

        this.addAttackDamage(8.5);
        this.addAttackSpeed(2);

        loadRecipe(Material.EMERALD);
    }
}
