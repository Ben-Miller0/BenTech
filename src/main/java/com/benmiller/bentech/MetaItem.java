package com.benmiller.bentech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import org.lwjgl.util.Color;

public class MetaItem extends Item {

    private final Material material;
    private final Shape shape;
    private final IIcon[] icons;

    public MetaItem(CreativeTabs tab, Material material, Shape shape) {
        super();
        String name = material.name + "_" + shape.name();
        this.material = material;
        this.shape = shape;
        icons = new IIcon[5];
        setCreativeTab(tab);
        setUnlocalizedName(BenTech.MODID + "_" + name);
        GameRegistry.registerItem(this, name, BenTech.MODID);
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int pass) {
        MetaItem item = (MetaItem) stack.getItem();
        assert item != null;
        Color color = item.material.colors[pass];
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return r << 16 | g << 8 | b;
    }

    @Override
    public int getRenderPasses(int metadata) {
        return 5;
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        return icons[pass];
    }

    @Override
    public void registerIcons(IIconRegister register) {
        for (int i = 0; i < 5; i++) {
            icons[i] = register.registerIcon(BenTech.MODID + ":" + shape.name() + i);
        }
    }
}
