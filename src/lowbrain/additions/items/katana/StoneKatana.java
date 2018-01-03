package lowbrain.additions.items.katana;


import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class StoneKatana extends Katana {
    public StoneKatana() {
        super(DamageableItem.STONE_SWORD,"lowbrain_additions:stone_katana", "stone_katana", "Stone Katana");
        loadRecipe(Material.COBBLESTONE);
    }
}
