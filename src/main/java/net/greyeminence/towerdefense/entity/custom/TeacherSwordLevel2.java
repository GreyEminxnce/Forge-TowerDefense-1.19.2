package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class TeacherSwordLevel2 extends Teacher
{
    protected static int price = 30;

    public TeacherSwordLevel2(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
        this.setItemInHand(InteractionHand.MAIN_HAND, Items.DIAMOND_SWORD.getDefaultInstance());
    }

    public static int getPrice()
    {
        return price;
    }
}
