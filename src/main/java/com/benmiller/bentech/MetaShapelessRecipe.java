package com.benmiller.bentech;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.util.List;

public class MetaShapelessRecipe extends ShapelessRecipes {
    public MetaShapelessRecipe(ItemStack output, List<ItemStack> input) {
        super(output, input);
    }
}
