package net.greyeminence.towerdefense.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class TeacherSwordLevel3 extends Teacher
{
    protected static int price = 64;

    public TeacherSwordLevel3(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
        ItemStack sword = Items.NETHERITE_SWORD.getDefaultInstance();
        sword.enchant(Enchantments.SHARPNESS, 10);
        this.setItemInHand(InteractionHand.MAIN_HAND, sword);
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
