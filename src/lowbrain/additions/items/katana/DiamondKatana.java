package lowbrain.additions.items.katana;


import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class DiamondKatana extends Katana {
    public DiamondKatana() {
        super(DamageableItem.DIAMOND_SWORD,"modified_additions:diamond_katana", "diamond_katana", "Diamond Katana",Material.DIAMOND_SWORD.getMaxDurability());

        this.addAttackDamage(MaterialUtils.getBaseDamage(Material.DIAMOND_SWORD) + 0.35);
        this.addAttackSpeed(MaterialUtils.getBaseSpeed(Material.DIAMOND_SWORD) - 0.15);

        loadRecipe(Material.DIAMOND);
    }
}
