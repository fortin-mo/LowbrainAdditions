package lowbrain.additions.items.dagger;

import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class StoneDagger extends Dagger {
    public StoneDagger() {
        super(DamageableItem.STONE_SWORD,"lowbrain_additions:stone_dagger", "stone_dagger", "Stone Dagger");
        loadRecipe(Material.COBBLESTONE);
    }
}
