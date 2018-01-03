package lowbrain.additions.items.twohanded;

import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class IronTwoHandedSword extends TwoHandedSword {
    public IronTwoHandedSword() {
        super(DamageableItem.IRON_SWORD,"lowbrain_additions:iron_two_handed_sword", "iron_two_handed_sword", "Iron Two Handed Sword");
        loadRecipe(Material.IRON_INGOT);
    }
}
