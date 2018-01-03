package lowbrain.additions.items.katana;


import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class DiamondKatana extends Katana {
    public DiamondKatana() {
        super(DamageableItem.DIAMOND_SWORD,"lowbrain_additions:diamond_katana", "diamond_katana", "Diamond Katana");
        loadRecipe(Material.DIAMOND);
    }
}
