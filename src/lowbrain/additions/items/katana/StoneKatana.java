package lowbrain.additions.items.katana;


import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class StoneKatana extends Katana {
    public StoneKatana() {
        super(DamageableItem.STONE_SWORD,"modified_additions:stone_katana", "stone_katana", "Stone Katana",Material.STONE_SWORD.getMaxDurability());

        this.addAttackDamage(MaterialUtils.getBaseDamage(Material.STONE_SWORD) + 0.35);
        this.addAttackSpeed(MaterialUtils.getBaseSpeed(Material.STONE_SWORD) - 0.15);

        loadRecipe(Material.COBBLESTONE);
    }
}
