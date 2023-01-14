package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class TeacherSwordLevel2 extends Teacher
{
    protected static int price = 30;

    public TeacherSwordLevel2(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
        this.setItemInHand(InteractionHand.MAIN_HAND, Items.DIAMOND_SWORD.getDefaultInstance());
    }

     @Override
     protected void registerGoals()
     {
         super.registerGoals();
         this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 3.0, false));
     }

    public static AttributeSupplier setAttributes()
    {
        return Monster.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0)
                .add(Attributes.ATTACK_DAMAGE, Attributes.ATTACK_DAMAGE.getDefaultValue() * 3)
                .add(Attributes.ATTACK_SPEED, Attributes.ATTACK_SPEED.getDefaultValue() * 3)
                .add(Attributes.ATTACK_KNOCKBACK, Attributes.ATTACK_KNOCKBACK.getDefaultValue())
                .add(Attributes.KNOCKBACK_RESISTANCE, Double.MAX_VALUE)
                .add(ForgeMod.ATTACK_RANGE.get(), 5)
                .build();
    }
    public static int getPrice()
    {
        return price;
    }
}
