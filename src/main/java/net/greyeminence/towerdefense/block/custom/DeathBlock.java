package net.greyeminence.towerdefense.block.custom;

import net.greyeminence.towerdefense.Game;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.core.BlockPos;
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
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        if (entity.isAlive() && entity instanceof LivingEntity && !(entity instanceof Player) && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity)) {
            ((Student) entity).setHasDropped(true);
            entity.kill();
            Game.new_health--;
        }
    }
}
