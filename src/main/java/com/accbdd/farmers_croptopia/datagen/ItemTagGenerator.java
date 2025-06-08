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
        //fd base to croptopia tags
        tag(CroptopiaTags.BEEF_MUTTON).addOptionalTag(CommonTags.RAW_BEEF);
        tag(CroptopiaTags.BEEF_REPLACEMENTS).addOptionalTag(CommonTags.RAW_BEEF);
        tag(CroptopiaTags.CHICKEN_REPLACEMENTS).addOptionalTag(CommonTags.RAW_CHICKEN);
        //don't add bacon bc bacon is not a pork replacement...
        tag(CroptopiaTags.FISHES).addOptionalTag(CommonTags.RAW_FISHES);
        tag(CroptopiaTags.MEAT_REPLACEMENTS).addOptionalTags(
                CommonTags.RAW_BEEF,
                CommonTags.RAW_CHICKEN,
                CommonTags.RAW_MUTTON);

        //rustic delight
        tag(CommonTags.VEGETABLES).addOptionalTag(CommonTags.VEGETABLES$BELLPEPPER);
        tag(CommonTags.COFFEE_BEANS).addOptional(loc("rusticdelight:roasted_coffee_beans")); //roasted, not raw
        tag(CommonTags.CALAMARI).addOptional(loc("rusticdelight:calamari"));
        tag(CommonTags.COFFEES).addOptional(loc("rusticdelight:coffee"));
        tag(CommonTags.RAW_FISHES$CALAMARI).addOptional(loc("rusticdelight:calamari"));
        tag(CommonTags.RAW_FISHES$CALAMARI).addOptional(loc("rusticdelight:calamari_slice"));
        tag(CommonTags.RAW_FISHES).addOptionalTag(CommonTags.RAW_FISHES$CALAMARI);
        tag(CommonTags.COOKED_FISHES$CALAMARI).addOptional(loc("rusticdelight:cooked_calamari"));
        tag(CommonTags.COOKED_FISHES$CALAMARI).addOptional(loc("rusticdelight:cooked_calamari_slice"));
        tag(CommonTags.COOKED_FISHES).addOptionalTag(CommonTags.COOKED_FISHES$CALAMARI);


        //nethers delight needs no tags
        //same with enders

        //seed delight
        tag(CommonTags.NUTS).addOptionalTags(
                CommonTags.NUTS$ACORN,
                CommonTags.NUTS$PINE);
        tag(CommonTags.JAMS).addOptionalTag(CommonTags.ROSEHIP_JAMS);
        tag(CommonTags.FRUITS$CHERRY).addOptional(loc("seeddelight:cherry"));
        tag(CommonTags.PASTA).addOptional(loc("seeddelight:raw_acorn_noodle"));
        tag(CommonTags.CHERRY_JAMS).addOptional(loc("seeddelight:cherry_jam_jar"));
        tag(CommonTags.ROSEHIP_JAMS).addOptional(loc("seeddelight:rosehip_jam_jar"));

        //ocean delight
        tag(CommonTags.TENTACLES).addOptional(loc("oceansdelight:tentacles"));
        tag(CommonTags.CALAMARI).addOptional(loc("oceansdelight:tentacles"));
        tag(CommonTags.TENTACLES).addOptional(loc("oceansdelight:cut_tentacles"));
        tag(CommonTags.CALAMARI).addOptional(loc("oceansdelight:cut_tentacles"));
        tag(CommonTags.RAW_FISHES$ELDER_GUARDIAN).addOptional(loc("oceansdelight:elder_guardian_slice"));
        tag(CommonTags.RAW_FISHES$FUGU).addOptional(loc("oceansdelight:fugu_slice"));
        tag(CommonTags.RAW_FISHES).addOptionalTags(CommonTags.RAW_FISHES$ELDER_GUARDIAN, CommonTags.RAW_FISHES$FUGU);
        tag(CommonTags.COOKED_FISHES$CALAMARI).addOptional(loc("rusticdelight:cooked_calamari"));
        tag(CommonTags.COOKED_FISHES).addOptionalTag(CommonTags.COOKED_FISHES$CALAMARI);
    }

    private static ResourceLocation loc(String str) {
        return ResourceLocation.parse(str);
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
