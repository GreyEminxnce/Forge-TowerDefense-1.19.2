package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class TeacherSwordLevel1 extends Teacher
{
    protected static int price = 10;

    public TeacherSwordLevel1(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
        this.setItemInHand(InteractionHand.MAIN_HAND, Items.STONE_SWORD.getDefaultInstance());
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
