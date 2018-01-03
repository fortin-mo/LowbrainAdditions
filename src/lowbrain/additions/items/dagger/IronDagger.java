package lowbrain.additions.items.dagger;

import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class IronDagger extends Dagger {
    public IronDagger() {
        super(DamageableItem.IRON_SWORD,"lowbrain_additions:iron_dagger", "iron_dagger", "Iron Dagger");
        loadRecipe(Material.IRON_INGOT);
    }
}
