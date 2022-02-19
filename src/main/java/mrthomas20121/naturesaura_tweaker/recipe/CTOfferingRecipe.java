package mrthomas20121.naturesaura_tweaker.recipe;

import com.blamejared.crafttweaker.CraftTweaker;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import de.ellpeck.naturesaura.recipes.ModRecipes;
import de.ellpeck.naturesaura.recipes.OfferingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.natures_aura.Offering")
@ZenRegister
public class CTOfferingRecipe implements IRecipeManager {

    @Override
    public RecipeType<OfferingRecipe> getRecipeType() {
        return ModRecipes.OFFERING_TYPE;
    }

    @ZenCodeType.Method
    public void addRecipe(String registryName, IIngredient input, IIngredient startItem, IItemStack output) {
        OfferingRecipe recipe = new OfferingRecipe(new ResourceLocation(CraftTweaker.MODID, registryName), input.asVanillaIngredient(), startItem.asVanillaIngredient(), output.getInternal());
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe, ""));
    }
}
