package mrthomas20121.naturesaura_tweaker.recipe;

import com.blamejared.crafttweaker.CraftTweaker;
import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.api.recipes.IRecipeHandler;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import de.ellpeck.naturesaura.NaturesAura;
import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.aura.type.IAuraType;
import de.ellpeck.naturesaura.recipes.AltarRecipe;
import de.ellpeck.naturesaura.recipes.ModRecipe;
import de.ellpeck.naturesaura.recipes.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("mods.natures_aura.Altar")
@ZenRegister
public class CTAltarRecipe implements IRecipeManager {

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
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe, ""));
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
        AltarRecipe recipe = new AltarRecipe(new ResourceLocation(CraftTweaker.MODID, registryName), input.asVanillaIngredient(), output.getInternal(), getAuraType(auraType), catalyst.asVanillaIngredient(), aura, time);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe, ""));
    }

    private static IAuraType getAuraType(String auraType) {
        return NaturesAuraAPI.AURA_TYPES.get(new ResourceLocation(auraType));
    }

    @Override
    public IRecipeType<AltarRecipe> getRecipeType() {
        return ModRecipes.ALTAR_TYPE;
    }
}
