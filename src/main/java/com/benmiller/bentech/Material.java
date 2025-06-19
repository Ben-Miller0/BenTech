package com.benmiller.bentech;

import net.minecraft.item.Item.ToolMaterial;
import org.lwjgl.util.Color;

public enum Material {
    NULL("Null", 0, 0.0F, 0, new Color[]{new Color(0, 0, 0), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)}),
    IRON("Iron", ToolMaterial.IRON.getHarvestLevel(), ToolMaterial.IRON.getEfficiencyOnProperMaterial(), ToolMaterial.IRON.getMaxUses(), new Color[]{new Color(68, 68, 68), new Color(132, 132, 132), new Color(168, 168, 168), new Color(216, 216, 216), new Color(255, 255, 255)});
    public final String name;
    public final int level;
    public final float speed;
    public final int durability;
    public final Color[] colors;

    Material(String name, int level, float speed, int durability, Color[] colors) {
        this.name = name;
        this.level = level;
        this.speed = speed;
        this.durability = durability;
        this.colors = colors;
    }
}
