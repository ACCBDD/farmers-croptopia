package com.accbdd.farmers_croptopia.datagen;

import com.accbdd.farmers_croptopia.FarmersCroptopia;
import com.epherical.croptopia.register.Content;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    private final CompletableFuture<HolderLookup.Provider> lookupProvider;
    private final ExistingFileHelper existingFileHelper;

    public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output);
        this.lookupProvider = lookupProvider;
        this.existingFileHelper = existingFileHelper;
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> output) {
        modifyRecipes(output);
        //FarmersCroptopia.LOGGER.debug(existingFileHelper.exists());
    }

    private void modifyRecipes(Consumer<FinishedRecipe> output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.THE_BIG_BREAKFAST)
                .pattern("123")
                .pattern("736")
                .pattern(" 45")
                .define('1', Items.EGG)
                .define('2', CommonTags.RAW_BACON)
                .define('3', CommonTags.HASHED_BROWN)
                .define('4', CommonTags.BAKED_BEANS)
                .define('5', CommonTags.SAUSAGES)
                .define('6', CommonTags.TOASTS)
                .define('7', Content.FRYING_PAN)
                .unlockedBy("has_frying_pan", has(Content.FRYING_PAN))
                .save(output, new ResourceLocation("croptopia:the_big_breakfast"));
    }
}
