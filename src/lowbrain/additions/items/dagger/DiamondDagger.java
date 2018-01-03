package lowbrain.additions.items.dagger;

import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class DiamondDagger extends Dagger {
    public DiamondDagger() {
        super(DamageableItem.DIAMOND_SWORD,"lowbrain_additions:diamond_dagger", "diamond_dagger", "Diamond Dagger");
        loadRecipe(Material.DIAMOND);
    }
}
