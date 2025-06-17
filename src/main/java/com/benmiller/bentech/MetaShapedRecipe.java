package com.benmiller.bentech;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

import java.util.Arrays;

public class MetaShapedRecipe extends ShapedRecipes {
    public MetaShapedRecipe(int width, int height, ItemStack[] input, ItemStack output) {
        super(1, 1, input, output);
        for (ItemStack item : input) {
            assert item.stackSize == 1;
        }
    }
}
