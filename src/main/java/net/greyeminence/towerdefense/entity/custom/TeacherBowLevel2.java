package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

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

    public static int getPrice()
    {
        return price;
    }
}
