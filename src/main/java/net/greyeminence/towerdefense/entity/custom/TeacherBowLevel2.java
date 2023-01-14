package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class TeacherBowLevel2 extends Teacher
{
    protected static int price = 30;

    public TeacherBowLevel2(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
        ItemStack bow = Items.BOW.getDefaultInstance();
        bow.setDamageValue(5);
        this.setItemInHand(InteractionHand.MAIN_HAND, bow);
    }

    public static AttributeSupplier setAttributes()
    {
        return Monster.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0)
                .add(Attributes.ATTACK_DAMAGE, Attributes.ATTACK_DAMAGE.getDefaultValue())
                .add(Attributes.ATTACK_SPEED, Attributes.ATTACK_SPEED.getDefaultValue() * 4)
                .add(Attributes.ATTACK_KNOCKBACK, Attributes.ATTACK_KNOCKBACK.getDefaultValue())
                .add(Attributes.KNOCKBACK_RESISTANCE, Double.MAX_VALUE)
                .add(ForgeMod.ATTACK_RANGE.get(), 5)
                .build();
    }

     @Override
     protected void registerGoals()
     {
         super.registerGoals();
         this.goalSelector.addGoal(0, new RangedBowAttackGoal(this, 4.0, 20, 5.0f));
     }

    public static int getPrice()
    {
        return price;
    }
}
