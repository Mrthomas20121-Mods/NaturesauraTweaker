package mrthomas20121.naturesaura_tweaker.recipe;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import de.ellpeck.naturesaura.recipes.ModRecipes;
import de.ellpeck.naturesaura.recipes.OfferingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.natures_aura.Offering")
@ZenRegister
public class CTOfferingRecipe implements IRecipeManager<OfferingRecipe> {

    @Override
    public RecipeType<OfferingRecipe> getRecipeType() {
        return ModRecipes.OFFERING_TYPE;
    }

    @ZenCodeType.Method
    public void addRecipe(String registryName, IIngredient input, IIngredient startItem, IItemStack output) {
        OfferingRecipe recipe = new OfferingRecipe(new ResourceLocation("crafttweaker", registryName), input.asVanillaIngredient(), startItem.asVanillaIngredient(), output.getInternal());
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }
}
