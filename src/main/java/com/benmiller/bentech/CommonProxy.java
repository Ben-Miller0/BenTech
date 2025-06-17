package com.benmiller.bentech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.HashSet;

public class CommonProxy {

    private static MetaItem ITEM;
    private static MetaBlock BLOCK;
    private static MetaTool TOOL;
    private static Item.ToolMaterial MATERIAL;
    private static CreativeTabs TAB;
    private static MetaShapelessRecipe[] SHAPELESS_RECIPES;

    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        BenTech.LOG.info(Config.greeting);
        BenTech.LOG.info("I am BenTech at version " + Tags.VERSION);

        TAB = new CreativeTabs("tabBenTech") {

            @Override
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return CommonProxy.TOOL;
            }
        };

        ITEM = new MetaItem(TAB);
        BenTech.LOG.info( ITEM.toString());
        BLOCK = new MetaBlock(TAB);
        BenTech.LOG.info( BLOCK.toString());
        HashSet<Block> set = new HashSet<>();
        set.add(BLOCK);
        MATERIAL = EnumHelper.addToolMaterial("Meta", 0, 0, 200.0F, 0.0F, 0);
        TOOL = new MetaTool(TAB, set, MATERIAL);
        BenTech.LOG.info( TOOL.toString());
    }

    // load "Do your mod setup. Build whatever data structures you care about.
    // Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        SHAPELESS_RECIPES = new MetaShapelessRecipe[2];
        ArrayList<ItemStack> ilist = new ArrayList<>();
        ilist.add(new ItemStack(ITEM));
        SHAPELESS_RECIPES[0] = new MetaShapelessRecipe(new ItemStack(BLOCK, 1), ilist);
        GameRegistry.addRecipe(SHAPELESS_RECIPES[0]);
        ArrayList<ItemStack> blist = new ArrayList<>();
        blist.add(new ItemStack(BLOCK));
        SHAPELESS_RECIPES[1] = new MetaShapelessRecipe(new ItemStack(ITEM, 1), blist);
        GameRegistry.addRecipe(SHAPELESS_RECIPES[1]);
        ItemStack item = new ItemStack(ITEM);
        GameRegistry.addShapedRecipe(new ItemStack(TOOL), new String[]{"X X","XXX"," X "}, 'X', item);
    }

    // postInit "Handle interaction with other mods, complete your setup based on
    // this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {

    }

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
