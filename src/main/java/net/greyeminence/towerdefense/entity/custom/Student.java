package net.greyeminence.towerdefense.entity.custom;

import net.greyeminence.towerdefense.changed.MoveToBlockPosGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class Student extends Monster
{
    private int cashDropAmount = 1;
    private boolean hasDropped = false;
    private int currentTarget = 0;
    private int lastTarget;
    protected double spawnPositionX = 0;
    protected double spawnPositionY = 0;
    protected double spawnPositionZ = 0;
    protected int route;

    public Student(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
        registerGoals();
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag)
    {
        SpawnGroupData spawnGroupDataReturn = super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
        spawnPositionX = this.getX();
        spawnPositionY = this.getY();
        spawnPositionZ = this.getZ();

        System.out.println("x: " + this.getX() + " y: " + this.getY() + " z: " + this.getZ());
        registerGoals();
        return spawnGroupDataReturn;

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
        if (spawnPositionX == 60.5 && spawnPositionY == -36.0 && spawnPositionZ == -41.5)
        {
            route = 1;
        }
        else
        {
            route = 0;
        }

        switch (route)
        {
            case 1:
                lastTarget = 10;
                if (currentTarget == 0)
                {
                    this.goalSelector.addGoal(10, new MoveToBlockPosGoal(this, new BlockPos(33, -36, -41.5), 1.0));
                }
                else if (currentTarget == 1)
                {
                    this.goalSelector.addGoal(9, new MoveToBlockPosGoal(this, new BlockPos(33, -40, -25), 1.0));
                }
                else if (currentTarget == 2)
                {
                    this.goalSelector.addGoal(8, new MoveToBlockPosGoal(this, new BlockPos(25, -40, -25), 1.0));
                }
                else if (currentTarget == 3)
                {
                    this.goalSelector.addGoal(7, new MoveToBlockPosGoal(this, new BlockPos(25, -44, -40.5), 1.0));
                }
                else if (currentTarget == 4)
                {
                    this.goalSelector.addGoal(6, new MoveToBlockPosGoal(this, new BlockPos(33, -44, -40.5), 1.0));
                }
                else if (currentTarget == 5)
                {
                    this.goalSelector.addGoal(5, new MoveToBlockPosGoal(this, new BlockPos(33, -48, -25.5), 1.0));
                }
                else if (currentTarget == 6)
                {
                    this.goalSelector.addGoal(4, new MoveToBlockPosGoal(this, new BlockPos(25, -48, -25.5), 1.0));
                }
                else if (currentTarget == 7)
                {
                    this.goalSelector.addGoal(3, new MoveToBlockPosGoal(this, new BlockPos(25, -51, -36.5), 1.0));
                }
                else if (currentTarget == 8)
                {
                    this.goalSelector.addGoal(2, new MoveToBlockPosGoal(this, new BlockPos(35.5, -52, -36.5), 1.0));
                }
                else if (currentTarget == 9)
                {
                    this.goalSelector.addGoal(1, new MoveToBlockPosGoal(this, new BlockPos(35.5, -52, -33.5), 1.0));
                }
                else if (currentTarget == 10)
                {
                    this.goalSelector.addGoal(0, new MoveToBlockPosGoal(this, new BlockPos(76.5, -52, -33.5), 1.0));
                }
                break;
        }
    }

    @Override
    public void tick()
    {
        super.tick();
        if (currentTarget <= lastTarget && route != 0 && ((MoveToBlockPosGoal) ((WrappedGoal) this.goalSelector.getAvailableGoals().toArray()[currentTarget]).getGoal()).isReachedTarget())
        {
            currentTarget++;
            this.registerGoals();
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
    @Override
    public void knockback(double p_147241_, double p_147242_, double p_147243_) {}

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
