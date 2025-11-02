package com.accbdd.farmers_croptopia.datagen;

import com.epherical.croptopia.register.Content;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
        tag(CommonTags.BERRIES).add(Content.BLACKBERRY.asItem(),
                Content.BLUEBERRY.asItem(),
                Content.CRANBERRY.asItem(),
                Content.CURRANT.asItem(),
                Content.ELDERBERRY.asItem(),
                Content.GRAPE.asItem(),
                Content.RASPBERRY.asItem(),
                Content.STRAWBERRY.asItem(),
                Content.RASPBERRY.asItem());
        tag(CommonTags.CHEESES).addTag(CommonTags.CHEESE);
        tag(CommonTags.COOKED_EGGS).add(Content.SUNNY_SIDE_EGGS, Content.SCRAMBLED_EGGS);
        tag(CommonTags.COOKED_FISHES).addTags(CommonTags.COOKED_FISHES$COD, CommonTags.COOKED_FISHES$SALMON);
        tag(CommonTags.COOKED_FISHES).add(Content.COOKED_CALAMARI.asItem(), Content.COOKED_ANCHOVY.asItem(), Content.COOKED_SHRIMP.asItem(), Content.COOKED_TUNA.asItem());
        tag(CommonTags.COOKED_FISHES$COD).add(Items.COOKED_COD);
        tag(CommonTags.COOKED_FISHES$SALMON).add(Items.COOKED_SALMON);
        tag(CommonTags.COOKED_SEAFOOD).addOptional(loc("croptopia:cooked_shrimp"));
        tag(CommonTags.COOKED_SEAFOOD).addOptional(loc("croptopia:steamed_crab"));
        tag(CommonTags.COOKED_SEAFOOD).addOptional(loc("croptopia:grilled_oysters"));
        tag(CommonTags.COOKED_SEAFOOD).addOptional(loc("croptopia:steamed_clams"));
        tag(CommonTags.DOUGH).add(ModItems.WHEAT_DOUGH.get(), Content.DOUGH);
        tag(CommonTags.DOUGHS).addTag(CommonTags.DOUGH);
        tag(ItemTags.FISHES).addOptionalTag(CommonTags.RAW_SEAFOOD);
        tag(CommonTags.MILK).add(Items.MILK_BUCKET, Content.SOY_MILK, Content.MILK_BOTTLE, ModItems.MILK_BOTTLE.get());
        tag(CommonTags.MILKS).addTag(CommonTags.MILK);
        tag(CommonTags.PASTA).addTag(CommonTags.PASTA$RAW_PASTA);
        tag(CommonTags.PASTA$RAW_PASTA).addOptional(loc("croptopia:noodle"));
        tag(CommonTags.PUMPKIN_SOUPS).add(ModItems.PUMPKIN_SOUP.get());
        tag(CommonTags.RATATOUILLE).add(Content.RATATOUILLE.asItem(), ModItems.RATATOUILLE.get());
        tag(CommonTags.RAW_BACON).add(Content.RAW_BACON, ModItems.BACON.get());
        tag(CommonTags.RAW_FISHES).addTags(CommonTags.RAW_FISHES$COD, CommonTags.RAW_FISHES$SALMON, CommonTags.RAW_FISHES$TROPICAL_FISH, CroptopiaTags.FISHES);
        tag(CommonTags.RAW_FISHES).add(Content.ANCHOVY.asItem(),
                Content.CALAMARI.asItem(),
                Content.GLOWING_CALAMARI.asItem(),
                Content.CLAM.asItem(),
                Content.CRAB.asItem(),
                Content.OYSTER.asItem(),
                Content.SHRIMP.asItem(),
                Content.TUNA.asItem());
        tag(CommonTags.RAW_FISHES$COD).add(Items.COD);
        tag(CommonTags.RAW_FISHES$SALMON).add(Items.SALMON);
        tag(CommonTags.RAW_FISHES$TROPICAL_FISH).add(Items.TROPICAL_FISH);
        tag(CommonTags.RAW_MUTTON).add(Items.MUTTON, ModItems.MUTTON_CHOPS.get());
        tag(CommonTags.RAW_PORK).add(Items.PORKCHOP, ModItems.BACON.get());
        tag(CommonTags.RAW_SEAFOOD).addOptional(loc("croptopia:clam"));
        tag(CommonTags.RAW_SEAFOOD).addOptional(loc("croptopia:crab"));
        tag(CommonTags.RAW_SEAFOOD).addOptional(loc("croptopia:oyster"));
        tag(CommonTags.RAW_SEAFOOD).addOptional(loc("croptopia:shrimp"));
        tag(CommonTags.SALAD_INGREDIENTS$CABBAGE).addOptionalTag(CommonTags.CABBAGE);
        tag(CommonTags.SALAD_INGREDIENTS$LETTUCE).addOptionalTag(CommonTags.LETTUCE);
        tag(CommonTags.SALAD_INGREDIENTS).addOptionalTags(CommonTags.SALAD_INGREDIENTS$CABBAGE, CommonTags.SALAD_INGREDIENTS$LETTUCE);
        tag(CommonTags.SHEPHERDS_PIE).add(ModItems.SHEPHERDS_PIE.get());

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
        tag(CommonTags.BELLPEPPERS).addOptionalTag(CommonTags.VEGETABLES$BELLPEPPER);
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
        tag(CommonTags.NUTS$ACORN).addOptional(loc("seeddelight:acorn"));
        tag(CommonTags.NUTS$PINE).addOptional(loc("seeddelight:pinecone"));
        tag(CommonTags.JAMS).addOptionalTag(CommonTags.ROSEHIP_JAMS);
        tag(CommonTags.FRUITS$CHERRY).addOptional(loc("seeddelight:cherry"));
        tag(CommonTags.PASTA).addOptional(loc("seeddelight:raw_acorn_noodle"));
        tag(CommonTags.CHERRY_JAMS).addOptional(loc("seeddelight:cherry_jam_jar"));
        tag(CommonTags.ROSEHIP_JAMS).addOptional(loc("seeddelight:rosehip_jam_jar"));
        tag(CommonTags.TOASTS).addOptional(loc("seeddelight:sunflower_seed_toast"));
        tag(CommonTags.TOFU).addOptional(loc("seeddelight:acorn_tofu"));

        //ocean delight
        tag(CommonTags.TENTACLES).addOptional(loc("oceansdelight:tentacles"));
        tag(CommonTags.CALAMARI).addOptional(loc("oceansdelight:tentacles"));
        tag(CommonTags.TENTACLES).addOptional(loc("oceansdelight:cut_tentacles"));
        tag(CommonTags.CALAMARI).addOptional(loc("oceansdelight:cut_tentacles"));
        tag(CommonTags.RAW_FISHES$ELDER_GUARDIAN).addOptional(loc("oceansdelight:elder_guardian_slice"));
        tag(CommonTags.RAW_FISHES$FUGU).addOptional(loc("oceansdelight:fugu_slice"));
        tag(CommonTags.RAW_FISHES).addOptionalTags(CommonTags.RAW_FISHES$ELDER_GUARDIAN, CommonTags.RAW_FISHES$FUGU);
        tag(CommonTags.COOKED_FISHES$CALAMARI).addOptional(loc("rusticdelight:cooked_calamari"));
        tag(CommonTags.COOKED_CALAMARI).addOptional(loc("rusticdelight:cooked_calamari"));
        tag(CommonTags.COOKED_FISHES).addOptionalTag(CommonTags.COOKED_FISHES$CALAMARI);

        //delightful handles compat mostly internally

        //crabber's delight
        tag(CommonTags.CLAM_MEAT).addOptional(loc("crabbersdelight:cooked_clam_meat"));
        tag(CommonTags.CLAMS).addOptional(loc("crabbersdelight:clam"));
        tag(CommonTags.COOKED_CALAMARI).addOptional(loc("crabbersdelight:cooked_squid_tentacles"));
        tag(CommonTags.COOKED_CALAMARI).addOptional(loc("crabbersdelight:cooked_glow_squid_tentacles"));
        tag(CommonTags.COOKED_FISHES$FUGU).addOptional(loc("crabbersdelight:cooked_pufferfish_slice"));
        tag(CommonTags.COOKED_FROG_LEGS).addOptional(loc("crabbersdelight:cooked_frog_leg"));
        tag(CommonTags.COOKED_LOBSTERS).addOptional(loc("crabbersdelight:cooked_clawster"));
        tag(CommonTags.COOKED_SEAFOOD).addOptionalTag(loc("crabbersdelight:cooked_seafood"));
        tag(CommonTags.COOKED_SHRIMP).addOptional(loc("crabbersdelight:cooked_shrimp"));
        tag(CommonTags.COOKED_TENTACLES).addOptional(loc("crabbersdelight:cooked_squid_tentacles"));
        tag(CommonTags.COOKED_TENTACLES).addOptional(loc("crabbersdelight:cooked_glow_squid_tentacles"));
        tag(CommonTags.CRABS).addOptional(loc("crabbersdelight:crab"));
        tag(CommonTags.GLOWING_CALAMARI).addOptional(loc("crabbersdelight:raw_glow_squid_tentacles"));
        tag(CommonTags.RAW_FISHES$FUGU).addOptional(loc("crabbersdelight:pufferfish_slice"));
        tag(CommonTags.RAW_FROG_LEGS).addOptional(loc("crabbersdelight:raw_frog_leg"));
        tag(CommonTags.RAW_LOBSTERS).addOptional(loc("crabbersdelight:raw_clawster"));
        tag(CommonTags.RAW_SEAFOOD).addOptionalTag(loc("crabbersdelight:raw_seafood"));
        tag(CommonTags.STEAMED_CRABS).addOptional(loc("crabbersdelight:cooked_crab"));
        tag(CommonTags.SHRIMP).addOptional(loc("crabbersdelight:shrimp"));
        tag(CommonTags.TENTACLES).addOptional(loc("crabbersdelight:raw_squid_tentacles"));
        tag(CommonTags.TENTACLES).addOptional(loc("crabbersdelight:raw_glow_squid_tentacles"));

        //vintage delight
        tag(CommonTags.GRAIN$OATS).addOptional(loc("vintagedelight:oat"));
        tag(CroptopiaTags.FLOURABLE).addOptional(loc("vintagedelight:oat"));
        tag(CommonTags.OATS).addOptional(loc("vintagedelight:oat"));
        tag(CommonTags.PEANUTS).addOptional(loc("vintagedelight:peanut"));
        tag(CommonTags.CHILE_PEPPERS).addOptional(loc("vintagedelight:ghost_pepper"));
        tag(CommonTags.CHEESE_PIZZAS).addOptional(loc("vintagedelight:cheese_pizza"));
        tag(CommonTags.CUCUMBER_SALADS).addOptional(loc("vintagedelight:cucumber_salad"));
        tag(CommonTags.PEANUT_BUTTER_AND_JAM).addOptional(loc("vintagedelight:pb_j"));
        tag(CommonTags.CHEESEBURGERS).addOptional(loc("vintagedelight:cheese_burger"));
        tag(CommonTags.PEANUT).addOptionalTag(CommonTags.PEANUTS);
        tag(CommonTags.CHILIPEPPER).addOptionalTag(CommonTags.CHILE_PEPPERS);
        tag(CommonTags.PICKLES).addOptional(loc("vintagedelight:pickle"));

        //casualness delight
        tag(CommonTags.FISH_AND_CHIPS).addOptional(loc("casualness_delight:fish_and_chips"));
        tag(CommonTags.POTATO_CHIPS).addOptional(loc("casualness_delight:potato_chip"));

        //more delight
        tag(CommonTags.SLICED_POTATO).addOptional(loc("rusticdelight:potato_slices")); //???
        tag(CommonTags.TOASTS).addOptional(loc("moredelight:toast"));
        tag(CommonTags.CHEESEBURGERS).addOptional(loc("moredelight:hamburger_with_cheese"));

        //oceanic delight
        tag(CommonTags.SHRIMP).addOptionalTag(CommonTags.SHRIMPS); //really...
        tag(CommonTags.DEEP_FRIED_SHRIMP).addOptional(loc("oceanic_delight:fried_shrimp"));
        tag(CommonTags.COOKED_TENTACLES).addOptional(loc("oceanic_delight:grilled_squid_tentacles"));
        tag(CommonTags.GLOWING_CALAMARI).addOptional(loc("oceanic_delight:glow_squid_tentacles"));

        //brewin and chewin
        tag(CommonTags.CHEESE).addOptionalTag(loc("brewinandchewin:cheese_wedges"));
        tag(ItemTags.create(ResourceLocation.parse("brewinandchewin:pizza_toppings"))).addOptionalTag(loc("forge:cabbage")).addOptionalTag(loc("forge:onions"));

        //cultural delights
        tag(CommonTags.TORTILLAS).addOptional(loc("culturaldelights:tortilla"));
        tag(CommonTags.AVOCADOS).addOptional(loc("culturaldelights:avocado"));
        tag(CommonTags.CALAMARI).addOptional(loc("culturaldelights:raw_calamari"));
        tag(CommonTags.COOKED_CALAMARI).addOptional(loc("culturaldelights:cooked_calamari"));
        tag(CommonTags.EGGPLANTS).addOptional(loc("culturaldelights:eggplant"));
        tag(CommonTags.EGGPLANTS).addOptional(loc("culturaldelights:white_eggplant"));
        tag(CommonTags.SMOKED_EGGPLANTS).addOptional(loc("culturaldelights:smoked_eggplant"));
        tag(CommonTags.SMOKED_EGGPLANTS).addOptional(loc("culturaldelights:smoked_white_eggplant"));
        tag(CommonTags.PICKLES).addOptional(loc("culturaldelights:pickle"));

        //veggie delight
        tag(CommonTags.SWEETPOTATOS).addOptional(loc("veggiesdelight:sweet_potato"));
        tag(CommonTags.BAKED_SWEET_POTATOS).addOptional(loc("veggiesdelight:baked_sweet_potato"));

        //farmer respite
        tag(CommonTags.COFFEE_BEANS).addOptional(loc("farmersrespite:coffee_beans"));
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
