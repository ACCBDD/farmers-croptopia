package com.accbdd.farmers_croptopia.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {

    public ItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, "farmers_croptopia", existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //croptopia
        tag(CroptopiaTags.BEEF_MUTTON).add(
                ModItems.MINCED_BEEF.get(),
                ModItems.MUTTON_CHOPS.get()
        );
        tag(CroptopiaTags.BEEF_REPLACEMENTS).add(
                ModItems.MINCED_BEEF.get()
        );
        tag(CroptopiaTags.CHICKEN_REPLACEMENTS).add(
                ModItems.CHICKEN_CUTS.get()
        );
        tag(CroptopiaTags.FISHES).add(
                ModItems.COD_SLICE.get(),
                ModItems.SALMON_SLICE.get());
        tag(CroptopiaTags.MEAT_REPLACEMENTS).add(
                ModItems.MINCED_BEEF.get(),
                ModItems.MUTTON_CHOPS.get(),
                ModItems.CHICKEN_CUTS.get()
        );

        //farmers delight
        tag(FarmersDelightTags.CABBAGE_ROLL_INGREDIENTS).addOptionalTag(
                CommonTags.TURNIPS
        );

        //rustic delight
        addToTags(com.phantomwing.rusticdelight.item.ModItems.COTTON_BOLL.get(), tag(CommonTags.CROPS$COTTON));
        tag(CommonTags.BELLPEPPERS).addOptionalTag(CommonTags.CROPS$BELL_PEPPER);
        tag(CroptopiaTags.PEPPERS).addOptionalTag(CommonTags.CROPS$BELL_PEPPER);
        addToTags(com.phantomwing.rusticdelight.item.ModItems.ROASTED_COFFEE_BEANS.get(), tag(CommonTags.COFFEE_BEANS));



    }

    private static ResourceLocation loc(String str) {
        return new ResourceLocation(str);
    }

    private static void addToTags(Item item, IntrinsicTagAppender<?>... tags) {
        for (IntrinsicTagAppender<?> tag : tags) {
            tag.addOptional(BuiltInRegistries.ITEM.getKey(item));
        }
    }

    private static void addToTags(TagKey<?> tagToAdd, IntrinsicTagAppender<?>... tags) {
        for (IntrinsicTagAppender<?> tag : tags) {
            tag.addOptionalTag(tagToAdd.location());
        }
    }
}
