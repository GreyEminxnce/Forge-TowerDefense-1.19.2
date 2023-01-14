package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

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

    public static int getPrice()
    {
        return price;
    }
}
