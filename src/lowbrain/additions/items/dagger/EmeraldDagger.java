package lowbrain.additions.items.dagger;

import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldDagger extends Dagger {
    public EmeraldDagger() {
        super(DamageableItem.DIAMOND_SWORD,"lowbrain_additions:emerald_dagger", "emerald_dagger", "Emerald Dagger",3123);

        this.addAttackDamage(DamageableItem.DIAMOND_SWORD.getAttackDamage() * 0.75);
        this.addAttackSpeed(DamageableItem.DIAMOND_SWORD.getAttackSpeed() * 2);

        loadRecipe(Material.EMERALD);
    }
}
