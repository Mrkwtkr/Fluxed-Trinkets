package com.jared.electrifiedtrinkets.api.recipes;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class SolderingRegistry {

	private static ArrayList<Object[]> recipe = new ArrayList<Object[]>();
	
	private static ItemStack[] stack = new ItemStack[1000];

	public static void addRecipe(ItemStack circuit, ItemStack output, ItemStack addon1, ItemStack addon2, ItemStack addon3, ItemStack addon4) {
		recipe.add(new Object[] { circuit, addon1, addon2, addon3, addon4 });
		stack[recipe.indexOf(new Object[] { circuit, addon1, addon2, addon3, addon4 }) + 1] = output;
	}

	public static boolean hasRecipe(ItemStack circuit, ItemStack output, ItemStack addon1, ItemStack addon2, ItemStack addon3, ItemStack addon4) {
		if (recipe.contains(new Object[] { circuit, addon1, addon2, addon3, addon4 })) {
			if (stack[recipe.indexOf(new Object[] { circuit, addon1, addon2, addon3, addon4 })] == output) {
				return true;
			}
		}
		return false;
	}

	public static boolean removeRecipe(ItemStack circuit, ItemStack output, ItemStack addon1, ItemStack addon2, ItemStack addon3, ItemStack addon4) {

		if (recipe.contains(new Object[] { circuit, addon1, addon2, addon3, addon4 })) {
			recipe.remove(new Object[] { circuit, addon1, addon2, addon3, addon4 });
			stack[recipe.indexOf(new Object[] { circuit, addon1, addon2, addon3, addon4 })] = null;
			return true;
		}
		return false;
	}

	public static ItemStack getResult(ItemStack circuit, ItemStack addon1, ItemStack addon2, ItemStack addon3, ItemStack addon4) {

		return stack[recipe.indexOf(new Object[] { circuit, addon1, addon2, addon3, addon4 })+1];
	}
	
	public static void flush(){
		recipe.clear();
		
	}

}