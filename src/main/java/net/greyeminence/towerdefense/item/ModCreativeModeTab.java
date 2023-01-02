package net.greyeminence.towerdefense.item;

import net.greyeminence.towerdefense.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TOWERDEFENSE_TAB = new CreativeModeTab("towerdefensetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.START_BLOCK.get());
        }
    };
}
