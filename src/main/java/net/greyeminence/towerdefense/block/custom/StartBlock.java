package net.greyeminence.towerdefense.block.custom;


import net.greyeminence.towerdefense.Game;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class StartBlock extends Block{
    public static Level serverlevel;

    public StartBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player,
                                 InteractionHand hand, BlockHitResult blockHitResult) {

        serverlevel = level;
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND)
        {
            Thread thread = new Thread(new Game(player, level));
            thread.start();
        }
        return super.use(state, level, blockPos, player, hand, blockHitResult);
    }
}
