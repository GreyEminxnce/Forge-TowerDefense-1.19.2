package net.greyeminence.towerdefense.changed;

import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.LevelReader;

public class MoveToBlockPosGoal extends Goal {
    protected final PathfinderMob mob;
    public final double speedModifier;
    protected BlockPos blockPos;
    private boolean reachedTarget;

    public MoveToBlockPosGoal(PathfinderMob pathfinderMob, BlockPos blockPos, double speedModifier) {
        this.blockPos = blockPos;
        this.mob = pathfinderMob;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
    }


    @Override
    public boolean canUse() {
        return true;
    }

    public void start() {
        this.moveMobToBlock();
    }

    public double acceptedDistance() {
        return 2;
    }

    protected void moveMobToBlock() {
        this.mob.getNavigation().moveTo((double) ((float) this.blockPos.getX()) + 0.5, (double) (this.blockPos.getY() + 1), (double) ((float) this.blockPos.getZ()) + 0.5, this.speedModifier);
    }

    protected BlockPos getMoveToTarget() {
        return this.blockPos.above();
    }

    public void tick() {
        BlockPos blockPosGoal = this.getMoveToTarget();
        if (!blockPosGoal.closerToCenterThan(this.mob.position(), this.acceptedDistance())) {
            this.reachedTarget = false;
            ++this.tryTicks;
            if (this.shouldRecalculatePath()) {
                this.mob.getNavigation().moveTo((double)((float)blockPosGoal.getX()) + 0.5, (double)blockPosGoal.getY(), (double)((float)blockPosGoal.getZ()) + 0.5, this.speedModifier);
            }
        } else {
            this.reachedTarget = true;
            System.out.println("reachedTarget ist true!");
            --this.tryTicks;
        }

    }

    public boolean shouldRecalculatePath() {
        return this.tryTicks % 40 == 0;
    }

    public boolean isReachedTarget() {
        return this.reachedTarget;
    }
    private static final int GIVE_UP_TICKS = 1200;
    private static final int STAY_TICKS = 1200;
    private static final int INTERVAL_TICKS = 200;
    protected int nextStartTick;
    protected int tryTicks;
    private int maxStayTicks;


    protected int nextStartTick(PathfinderMob p_25618_) {
        return reducedTickDelay(200 + p_25618_.getRandom().nextInt(200));
    }

    public boolean canContinueToUse() {
        return true;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    protected boolean isValidTarget(LevelReader var1, BlockPos var2)
    {
        return true;
    }
}