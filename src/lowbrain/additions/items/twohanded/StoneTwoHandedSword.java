package lowbrain.additions.items.twohanded;

import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class StoneTwoHandedSword extends TwoHandedSword {
    public StoneTwoHandedSword() {
        super(DamageableItem.STONE_SWORD,"lowbrain_additions:stone_two_handed_sword", "stone_two_handed_sword", "Stone Two Handed Sword");
        loadRecipe(Material.COBBLESTONE);
    }
}
