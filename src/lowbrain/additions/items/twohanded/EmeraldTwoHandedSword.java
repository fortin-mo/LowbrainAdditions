package lowbrain.additions.items.twohanded;

import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldTwoHandedSword extends TwoHandedSword {
    public EmeraldTwoHandedSword() {
        super(DamageableItem.DIAMOND_SWORD,"lowbrain_additions:emerald_two_handed_sword", "emerald_two_handed_sword", "Emerald Two Handed Sword",4125);

        this.addAttackDamage(DamageableItem.DIAMOND_SWORD.getAttackDamage() * 1.65);
        this.addAttackSpeed(DamageableItem.DIAMOND_SWORD.getAttackSpeed() * 0.50);

        loadRecipe(Material.EMERALD);
    }
}
