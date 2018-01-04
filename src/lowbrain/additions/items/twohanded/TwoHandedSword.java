package lowbrain.additions.items.twohanded;

import com.chrismin13.additionsapi.items.textured.CustomTexturedTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class TwoHandedSword extends CustomTexturedTool {

    public TwoHandedSword(DamageableItem item, String idName, String defaultTexture, String displayName, int durability) {
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

    public TwoHandedSword(DamageableItem item, String idName, String defaultTexture, String displayName) {
        this(item, idName, defaultTexture, displayName, (int)(item.getMaxDurability() * 1.25));

        this.addAttackDamage(item.getAttackDamage() * 1.5);
        this.addAttackSpeed(item.getAttackSpeed() * 0.45);
    }

    public void loadRecipe(Material mat) {
        CustomShapedRecipe itemRecipe = new CustomShapedRecipe();
        CustomShapedRecipe itemRecipe2 = new CustomShapedRecipe();

        itemRecipe.setIngredient('1', new RecipeIngredient(Material.STICK));
        itemRecipe.setIngredient('2', new RecipeIngredient(mat));

        itemRecipe2.setIngredient('1', new RecipeIngredient(Material.STICK));
        itemRecipe2.setIngredient('2', new RecipeIngredient(mat));


        itemRecipe.setShape("022", "022", "011");
        itemRecipe2.setShape("220", "220", "110");

        this.addCustomRecipe(itemRecipe);
        this.addCustomRecipe(itemRecipe2);
    }

}
