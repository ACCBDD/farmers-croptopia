package com.accbdd.farmers_croptopia;

import com.accbdd.farmers_croptopia.datagen.DataGenerators;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;

@Mod(FarmersCroptopia.MODID)
public class FarmersCroptopia
{
    public static final String MODID = "zfarmers_croptopia";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FarmersCroptopia()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(DataGenerators::generate);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
}
