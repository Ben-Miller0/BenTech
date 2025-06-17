package com.benmiller.bentech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemTool;

import java.util.HashSet;

public class MetaTool extends ItemTool {

    public static final String name = "meta_tool";

    protected MetaTool(CreativeTabs tab, HashSet<Block> Blocks, ToolMaterial material) {
        super(0, material, Blocks);
        setUnlocalizedName(BenTech.MODID + "_" + name);
        setCreativeTab(tab);
        setTextureName(BenTech.MODID + ":" + name);
        GameRegistry.registerItem(this, getUnlocalizedName());
    }
}
