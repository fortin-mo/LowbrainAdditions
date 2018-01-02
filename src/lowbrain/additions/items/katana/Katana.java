package lowbrain.additions.items.katana;

import com.chrismin13.additionsapi.items.textured.CustomTexturedTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class Katana extends CustomTexturedTool {

    public Katana(DamageableItem item, String idName, String defaultTexture, String displayName, int durability) {
        super(item, idName, defaultTexture);

        this.setDisplayName(displayName);

        this.setUnbreakable(true);
        this.setFakeDurability(3123);
        this.setEnchantable(true);
        this.setToolLikeAttributes(true);
        this.setUnbreakableVisibility(false);
        this.setAttributeVisibility(false);
        this.setCombinedInCrafting(true);
    }

    public void loadRecipe(Material mat) {
        CustomShapedRecipe itemRecipe = new CustomShapedRecipe();
        CustomShapedRecipe itemRecipe2 = new CustomShapedRecipe();

        itemRecipe.setIngredient('1', new RecipeIngredient(Material.STICK));
        itemRecipe.setIngredient('2', new RecipeIngredient(mat));

        itemRecipe2.setIngredient('1', new RecipeIngredient(Material.STICK));
        itemRecipe2.setIngredient('2', new RecipeIngredient(mat));


        itemRecipe.setShape("022", "020", "010");
        itemRecipe.setShape("220", "200", "100");

        this.addCustomRecipe(itemRecipe);
        this.addCustomRecipe(itemRecipe2);
    }
}
