package net.greyeminence.towerdefense.entity.custom;

import net.greyeminence.towerdefense.EnterExitGoal;
import net.greyeminence.towerdefense.MoveToBlockPosGoal;
import net.greyeminence.towerdefense.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class Student extends Monster
{
    private int cashDropAmount = 1;
    private boolean hasDropped = false;
    private int currentTarget = 0;
    private MoveToBlockPosGoal[] targets = new MoveToBlockPosGoal[2];
    private int targetsLength = targets.length;

    public Student(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
        targets[0] = new MoveToBlockPosGoal(this, new BlockPos(0, 80, 0), 1.0);
        targets[1] = new MoveToBlockPosGoal(this, new BlockPos(20, 80, 0), 1.0);
    }

    public static AttributeSupplier setAttributes()
    {
        return Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, Attributes.FOLLOW_RANGE.getDefaultValue())
                .add(Attributes.ARMOR, Attributes.ARMOR.getDefaultValue())
                .add(Attributes.MAX_HEALTH, Attributes.MAX_HEALTH.getDefaultValue())
                .add(Attributes.MOVEMENT_SPEED,Attributes.MOVEMENT_SPEED.getDefaultValue())
                .add(Attributes.ARMOR_TOUGHNESS, Attributes.ARMOR_TOUGHNESS.getDefaultValue())
                .build();
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, targets[0]);
        this.goalSelector.addGoal(2, targets[1]);
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.5));
    }

    @Override
    public void tick()
    {
        super.tick();
        if(currentTarget < targetsLength)
        {
            if (targets[currentTarget].isReachedTarget())
            {
                this.goalSelector.removeGoal(targets[currentTarget]);
                currentTarget++;
            }
        }
    }

    @Override
     public boolean shouldDropExperience()
    {
        return false;
    }

    @Override
    protected boolean shouldDespawnInPeaceful()
    {
        return false;
    }

    public int getCashDropAmount()
    {
        return cashDropAmount;
    }

    public void setCashDropAmount(int newCashDropAmount)
    {
        cashDropAmount = newCashDropAmount;
    }

    public boolean getHasDropped()
    {
        return hasDropped;
    }

    public void setHasDropped(boolean newHasDropped)
    {
        hasDropped = newHasDropped;
    }
}
