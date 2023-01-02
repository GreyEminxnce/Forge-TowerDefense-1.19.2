package net.greyeminence.towerdefense.block.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DeathBlock extends MagmaBlock {

    public DeathBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level p_153777_, BlockPos p_153778_, BlockState p_153779_, Entity p_153780_) {
        if (!p_153780_.isSteppingCarefully() && p_153780_ instanceof LivingEntity && !(p_153780_ instanceof Player) && !EnchantmentHelper.hasFrostWalker((LivingEntity) p_153780_)) {
            p_153780_.hurt(DamageSource.HOT_FLOOR, 100.0F);

        }
    }
}
