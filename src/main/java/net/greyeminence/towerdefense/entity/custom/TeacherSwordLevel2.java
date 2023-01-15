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
         this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0, false));
     }

    public static int getPrice()
    {
        return price;
    }
}
