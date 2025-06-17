package com.benmiller.bentech;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;

public class MetaItem extends Item {

    public static final String name = "meta_item";

    public MetaItem(CreativeTabs tab) {
        super();
        setUnlocalizedName(BenTech.MODID + "_" + name);
        setCreativeTab(tab);
        setTextureName(BenTech.MODID + ":" + name);
        GameRegistry.registerItem(this, getUnlocalizedName());

    }
}
