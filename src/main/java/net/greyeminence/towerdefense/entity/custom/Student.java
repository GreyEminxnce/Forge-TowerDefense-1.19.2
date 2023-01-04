package net.greyeminence.towerdefense.entity.custom;

import net.greyeminence.towerdefense.EnterExitGoal;
import net.greyeminence.towerdefense.block.ModBlocks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class Student extends Monster
{
    public Student(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes()
    {
        return Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0).build();
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, new EnterExitGoal(ModBlocks.DEATH_BLOCK.get(), this, 1.0, 1000, 255));
    }
}
