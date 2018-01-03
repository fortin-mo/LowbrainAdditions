package lowbrain.additions.items.twohanded;

import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class DiamondTwoHandedSword extends TwoHandedSword {
    public DiamondTwoHandedSword() {
        super(DamageableItem.DIAMOND_SWORD,"lowbrain_additions:diamond_two_handed_sword", "diamond_two_handed_sword", "Diamond Two Handed Sword");
        loadRecipe(Material.DIAMOND);
    }
}
