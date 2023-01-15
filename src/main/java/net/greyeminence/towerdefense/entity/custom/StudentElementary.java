package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class StudentElementary extends Student
{
    private int cashDropAmount = 2;
    public StudentElementary(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes()
    {
        return Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, Attributes.FOLLOW_RANGE.getDefaultValue())
                .add(Attributes.ARMOR, Attributes.ARMOR.getDefaultValue())
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ARMOR_TOUGHNESS, Attributes.ARMOR_TOUGHNESS.getDefaultValue())
                .build();
    }
}
