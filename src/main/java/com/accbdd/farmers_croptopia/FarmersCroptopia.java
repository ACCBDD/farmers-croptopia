package com.accbdd.farmers_croptopia;

import com.accbdd.farmers_croptopia.datagen.DataGenerators;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(FarmersCroptopia.MODID)
public class FarmersCroptopia
{
    public static final String MODID = "farmers_croptopia";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FarmersCroptopia(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(DataGenerators::generate);
    }
}
