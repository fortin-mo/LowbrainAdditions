package lowbrain.additions.items.katana;


import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class IronKatana extends Katana {
    public IronKatana() {
        super(DamageableItem.IRON_SWORD,"lowbrain_additions:iron_katana", "iron_katana", "Iron Katana");
        loadRecipe(Material.IRON_INGOT);
    }
}
