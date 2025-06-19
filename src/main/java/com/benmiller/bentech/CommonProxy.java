package com.benmiller.bentech;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CommonProxy {

    public static MetaItem[] Items;

    public static CreativeTabs tab = new CreativeTabs("BenTech") {
        @Override
        public Item getTabIconItem() {
            return Items[0];
        }
    };

    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        BenTech.LOG.info(Config.greeting);
        BenTech.LOG.info("I am BenTech at version " + Tags.VERSION);

        Items = new MetaItem[Material.values().length * Shape.values().length];
        int i = 0;
        for (Material material : Material.values()) {
            for (Shape shape : Shape.values()) {
                Items[i++] = new MetaItem(tab, material, shape);
            }
        }
    }

    // load "Do your mod setup. Build whatever data structures you care about.
    // Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
    }

    // postInit "Handle interaction with other mods, complete your setup based on
    // this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {

    }

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
