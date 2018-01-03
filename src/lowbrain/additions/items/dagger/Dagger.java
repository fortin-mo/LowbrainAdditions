package lowbrain.additions.items.dagger;

import com.chrismin13.additionsapi.items.textured.CustomTexturedTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class Dagger extends CustomTexturedTool {

    public Dagger(DamageableItem item, String idName, String defaultTexture, String displayName, int durability) {
        super(item, idName, defaultTexture);

        this.setDisplayName(displayName);
        this.setUnbreakable(true);
        this.setFakeDurability(durability);
        this.setEnchantable(true);
        this.setToolLikeAttributes(true);
        this.setUnbreakableVisibility(false);
        this.setAttributeVisibility(false);
        this.setCombinedInCrafting(true);
    }

    public Dagger(DamageableItem item, String idName, String defaultTexture, String displayName) {
        this(item, idName, defaultTexture, displayName, item.getMaxDurability());

        this.addAttackDamage(item.getAttackDamage() * 0.666);
        this.addAttackSpeed(item.getAttackSpeed() * 1.75);
    }

    public void loadRecipe(Material mat) {
        CustomShapedRecipe itemRecipe = new CustomShapedRecipe();
        CustomShapedRecipe itemRecipe2 = new CustomShapedRecipe();
        CustomShapedRecipe itemRecipe3 = new CustomShapedRecipe();

        itemRecipe.setIngredient('1', new RecipeIngredient(Material.STICK));
        itemRecipe.setIngredient('2', new RecipeIngredient(Material.LEATHER));
        itemRecipe.setIngredient('3', new RecipeIngredient(mat));

        itemRecipe2.setIngredient('1', new RecipeIngredient(Material.STICK));
        itemRecipe2.setIngredient('2', new RecipeIngredient(Material.LEATHER));
        itemRecipe2.setIngredient('3', new RecipeIngredient(mat));

        itemRecipe3.setIngredient('1', new RecipeIngredient(Material.STICK));
        itemRecipe3.setIngredient('2', new RecipeIngredient(Material.LEATHER));
        itemRecipe3.setIngredient('3', new RecipeIngredient(mat));

        itemRecipe.setShape("300", "200", "100");
        itemRecipe2.setShape("030", "020", "010");
        itemRecipe3.setShape("003", "002", "001");

        this.addCustomRecipe(itemRecipe);
        this.addCustomRecipe(itemRecipe2);
        this.addCustomRecipe(itemRecipe3);
    }
}
