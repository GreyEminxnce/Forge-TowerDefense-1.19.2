package net.greyeminence.towerdefense.block.custom;

import java.util.concurrent.TimeUnit;

import net.greyeminence.towerdefense.item.ModCreativeModeTab;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import java.util.function.Supplier;
public class StartBlock extends Block implements Runnable{
    public StartBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player,
                                 InteractionHand hand, BlockHitResult blockHitResult) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND)
        {
            ServerPlayer test = (ServerPlayer) player;
            test.setGameMode(GameType.SURVIVAL);
            player.setPos(0, 80, 0);
            player.getInventory().clearContent();
            player.getInventory().add(Items.STONE_SWORD.getDefaultInstance());
            player.setHealth(20);
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2147483647, 255));

            StartBlock obj = new StartBlock((BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()));
            Thread thread = new Thread(obj);
            thread.start();
        }
        return super.use(state, level, blockPos, player, hand, blockHitResult);
    }
    public void run()
    {
             try {
                TimeUnit.SECONDS.sleep(30);
            }
            catch (java.lang.InterruptedException exception)
            {
                System.out.println("Something went wrong");
            }
    }
}
