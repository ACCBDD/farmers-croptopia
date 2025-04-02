package com.accbdd.farmers_croptopia.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {

    public ItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, "farmers_croptopia", existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
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
    }
}
