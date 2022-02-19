package mrthomas20121.naturesaura_tweaker.recipe;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import de.ellpeck.naturesaura.recipes.ModRecipes;
import de.ellpeck.naturesaura.recipes.TreeRitualRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.stream.Collectors;

@ZenCodeType.Name("mods.natures_aura.TreeRitual")
@ZenRegister
public class CTTreeRitualRecipe implements IRecipeManager<TreeRitualRecipe> {

    @Override
    public RecipeType<TreeRitualRecipe> getRecipeType() {
        return ModRecipes.TREE_RITUAL_TYPE;
    }

    @ZenCodeType.Method
    public void addRecipe(String registryName, IIngredient saplingType, IItemStack result, int time, IIngredient... ingredients) {
        Ingredient[] array = Arrays.stream(ingredients).map(IIngredient::asVanillaIngredient).toList().toArray(new Ingredient[]{});
        TreeRitualRecipe recipe = new TreeRitualRecipe(new ResourceLocation("crafttweaker", registryName), saplingType.asVanillaIngredient(), result.getInternal(), time, array);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }
}
