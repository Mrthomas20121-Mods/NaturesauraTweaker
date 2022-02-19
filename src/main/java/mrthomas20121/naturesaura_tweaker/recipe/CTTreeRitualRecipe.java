package mrthomas20121.naturesaura_tweaker.recipe;

import com.blamejared.crafttweaker.CraftTweaker;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
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
public class CTTreeRitualRecipe implements IRecipeManager {

    @Override
    public RecipeType<TreeRitualRecipe> getRecipeType() {
        return ModRecipes.TREE_RITUAL_TYPE;
    }

    @ZenCodeType.Method
    public void addRecipe(String registryName, IIngredient saplingType, IItemStack result, int time, IIngredient... ingredients) {
        Ingredient[] array = Arrays.stream(ingredients).map(IIngredient::asVanillaIngredient).collect(Collectors.toList()).toArray(new Ingredient[]{});
        TreeRitualRecipe recipe = new TreeRitualRecipe(new ResourceLocation(CraftTweaker.MODID, registryName), saplingType.asVanillaIngredient(), result.getInternal(), time, array);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe, ""));
    }
}
