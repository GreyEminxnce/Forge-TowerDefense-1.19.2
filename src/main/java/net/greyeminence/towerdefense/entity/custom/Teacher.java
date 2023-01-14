package net.greyeminence.towerdefense.entity.custom;

import net.greyeminence.towerdefense.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class Teacher extends Monster implements RangedAttackMob
{
    protected int price;
    protected static final double sellPriceMultiplier = 0.75;
    public Teacher(EntityType<? extends Monster> entityType, Level level)
    {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes()
    {
        return Monster.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0)
                .add(Attributes.ATTACK_DAMAGE, Attributes.ATTACK_DAMAGE.getDefaultValue())
                .add(Attributes.ATTACK_SPEED, Attributes.ATTACK_SPEED.getDefaultValue() * 2)
                .add(Attributes.ATTACK_KNOCKBACK, Attributes.ATTACK_KNOCKBACK.getDefaultValue())
                .add(Attributes.KNOCKBACK_RESISTANCE, Double.MAX_VALUE)
                .add(ForgeMod.ATTACK_RANGE.get(), 5)
                .build();
    }

    @Override
    protected void registerGoals()
    {
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal(this, Student.class, 10, true, true, null));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource)
    {
        return damageSource != DamageSource.OUT_OF_WORLD;
    }

    @Override
    public boolean isPushable()
    {
        return false;
    }

    @Override
    protected boolean shouldDespawnInPeaceful()
    {
        return false;
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand interactionHand)
    {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (itemstack.getItem() == ModItems.REMOVER.get())
        {
            int sellPrice = 10;
            if (this instanceof TeacherBowLevel1)
            {
                sellPrice = TeacherBowLevel1.getPrice();
            }
            if (this instanceof TeacherBowLevel2)
            {
                sellPrice = TeacherBowLevel2.getPrice();
            }
            if (this instanceof TeacherBowLevel3)
            {
                sellPrice = TeacherBowLevel3.getPrice();
            }
            if (this instanceof TeacherSwordLevel1)
            {
                sellPrice = TeacherSwordLevel1.getPrice();
            }
            if (this instanceof TeacherSwordLevel2)
            {
                sellPrice = TeacherSwordLevel2.getPrice();
            }
            if (this instanceof TeacherSwordLevel3)
            {
                sellPrice = TeacherSwordLevel3.getPrice();
            }
            player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, (int) (sellPrice * sellPriceMultiplier)));
            this.kill();
        }
        return InteractionResult.PASS;
    }

    protected AbstractArrow getArrow(ItemStack p_32156_, float p_32157_) {
        return ProjectileUtil.getMobArrow(this, p_32156_, p_32157_);
    }

    public void performRangedAttack(LivingEntity p_32141_, float p_32142_) {
        ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> {
            return item instanceof BowItem;
        })));
        AbstractArrow abstractarrow = this.getArrow(itemstack, p_32142_);
        if (this.getMainHandItem().getItem() instanceof BowItem) {
            abstractarrow = ((BowItem)this.getMainHandItem().getItem()).customArrow(abstractarrow);
        }



        double d0 = p_32141_.getX() - this.getX();
        double d1 = p_32141_.getY(0.3333333333333333) - abstractarrow.getY();
        double d2 = p_32141_.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        abstractarrow.shoot(d0, d1 + d3 * 0.20000000298023224, d2, 1.6F, (float)(14 - this.level.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(abstractarrow);
    }
}
