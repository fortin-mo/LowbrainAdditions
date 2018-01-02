package lowbrain.additions.items.katana;


import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class IronKatana extends Katana {
    public IronKatana() {
        super(DamageableItem.IRON_SWORD,"modified_additions:iron_katana", "iron_katana", "Iron Katana",Material.IRON_SWORD.getMaxDurability());

        this.addAttackDamage(MaterialUtils.getBaseDamage(Material.IRON_SWORD) + 0.35);
        this.addAttackSpeed(MaterialUtils.getBaseSpeed(Material.IRON_SWORD) - 0.15);

        loadRecipe(Material.EMERALD);
    }
}
