package com.benmiller.bentech;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

import cpw.mods.fml.common.registry.GameRegistry;

public class MetaBlock extends Block {

    private String name = "meta_block";
    private IIcon[] icons = new IIcon[6];

    protected MetaBlock(CreativeTabs tab) {
        super(Material.wood);
        setBlockName(BenTech.MODID + "_" + name);
        setCreativeTab(tab);
        setHardness(10.0F);
        setHarvestLevel("meta", 0);
        GameRegistry.registerBlock(this, name);
        setBlockTextureName(BenTech.MODID + ":" + name);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(BenTech.MODID + ":" + name + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return icons[side];
    }
}
