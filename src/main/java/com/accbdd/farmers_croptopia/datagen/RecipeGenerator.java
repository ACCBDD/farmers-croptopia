package com.accbdd.farmers_croptopia.datagen;

import com.epherical.croptopia.register.Content;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends RecipeProvider {
    private final CompletableFuture<HolderLookup.Provider> lookupProvider;
    private final ExistingFileHelper existingFileHelper;

    public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider);
        this.lookupProvider = lookupProvider;
        this.existingFileHelper = existingFileHelper;
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        //croptopia
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
                .save(output, ResourceLocation.parse("croptopia:the_big_breakfast"));
    }
}
