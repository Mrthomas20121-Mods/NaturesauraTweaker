package mrthomas20121.naturesaura_tweaker.recipe;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import de.ellpeck.naturesaura.recipes.AltarRecipe;
import de.ellpeck.naturesaura.recipes.ModRecipes;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.natures_aura.Altar")
@ZenRegister
public class CTAltarRecipe implements IRecipeManager<AltarRecipe> {

    /**
     * @param registryName Recipe name
     * @param input Recipe input
     * @param output Recipe output
     * @param auraType type of aura : "overworld", "nether", "end", "other"
     * @param aura amount of aura used
     * @param time time(in ticks) it take to do the recipe
     */
    @ZenCodeType.Method
    public void addRecipe(String registryName, IIngredient input, IItemStack output, String auraType, int aura, int time) {
        AltarRecipe recipe = new AltarRecipe(new ResourceLocation("crafttweaker", registryName), input.asVanillaIngredient(), output.getInternal(), getAuraType(auraType), Ingredient.EMPTY, aura, time);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }

    /**
     * @param registryName Recipe name
     * @param input Recipe input
     * @param output Recipe output
     * @param auraType type of aura : "overworld", "nether", "end", "other"
     * @param catalyst Recipe Catalyst
     * @param aura amount of aura used
     * @param time time(in ticks) it take to do the recipe
     */
    @ZenCodeType.Method
    public void addRecipe(String registryName, IIngredient input, IItemStack output, String auraType, IIngredient catalyst, int aura, int time) {
        AltarRecipe recipe = new AltarRecipe(new ResourceLocation("crafttweaker", registryName), input.asVanillaIngredient(), output.getInternal(), getAuraType(auraType), catalyst.asVanillaIngredient(), aura, time);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }

    private static IAuraType getAuraType(String auraType) {
        return NaturesAuraAPI.AURA_TYPES.get(new ResourceLocation(auraType));
    }

    @Override
    public RecipeType<AltarRecipe> getRecipeType() {
        return ModRecipes.ALTAR_TYPE;
    }
}
