package com.accbdd.farmers_croptopia.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DataGenerators {
    public static void generate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        BlockTagsProvider blockTagsProvider = new BlockTagsProvider(output, lookupProvider, "farmers_croptopia", existingFileHelper) {
            @Override
            protected void addTags(HolderLookup.@NotNull Provider provider) {

            }
        };
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new RecipeGenerator(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ItemTagGenerator(output, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
    }
}
