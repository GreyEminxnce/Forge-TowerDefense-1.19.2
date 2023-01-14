package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class TeacherSwordLevel3 extends Teacher
{
    protected static int price = 100;

    public TeacherSwordLevel3(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
        ItemStack sword = Items.NETHERITE_SWORD.getDefaultInstance();
        sword.setDamageValue(10);
        this.setItemInHand(InteractionHand.MAIN_HAND,sword);
    }

    public static AttributeSupplier setAttributes()
    {
        return Monster.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0)
                .add(Attributes.ATTACK_DAMAGE, Attributes.ATTACK_DAMAGE.getDefaultValue() * 10)
                .add(Attributes.ATTACK_SPEED, Attributes.ATTACK_SPEED.getDefaultValue() * 10)
                .add(Attributes.ATTACK_KNOCKBACK, Attributes.ATTACK_KNOCKBACK.getDefaultValue())
                .add(Attributes.KNOCKBACK_RESISTANCE, Double.MAX_VALUE)
                .add(ForgeMod.ATTACK_RANGE.get(), 5)
                .build();
    }

     @Override
     protected void registerGoals()
     {
         super.registerGoals();
         this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 10.0, false));
     }

    public static int getPrice()
    {
        return price;
    }
}
