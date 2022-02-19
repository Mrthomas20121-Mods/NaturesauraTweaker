package mrthomas20121.naturesaura_tweaker.recipe;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import de.ellpeck.naturesaura.recipes.AnimalSpawnerRecipe;
import de.ellpeck.naturesaura.recipes.ModRecipes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.stream.Collectors;

@ZenCodeType.Name("mods.natures_aura.AnimalSpawner")
@ZenRegister
public class CTAnimalSpawnerRecipe implements IRecipeManager<AnimalSpawnerRecipe> {

    @Override
    public RecipeType<AnimalSpawnerRecipe> getRecipeType() {
        return ModRecipes.ANIMAL_SPAWNER_TYPE;
    }

    /**
     * @param registryName Recipe Name
     * @param entityType entity type. see Crafttweaker docs
     * @param aura amount of aura used.
     * @param time time it take to complete the recipe.
     * @param ingredients ingredients required to summon this entity.
     */
    @ZenCodeType.Method
    public void addRecipe(String registryName, EntityType<?> entityType, int aura, int time, IIngredient... ingredients) {
        Ingredient[] array = Arrays.stream(ingredients).map(IIngredient::asVanillaIngredient).toList().toArray(new Ingredient[]{});
        AnimalSpawnerRecipe recipe = new AnimalSpawnerRecipe(new ResourceLocation("crafttweaker", registryName), entityType, aura, time, array);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }
}
