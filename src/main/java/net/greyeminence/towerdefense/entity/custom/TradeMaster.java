package net.greyeminence.towerdefense.entity.custom;

import net.greyeminence.towerdefense.item.ModItems;
import net.greyeminence.towerdefense.villager.ModVillagers;
import net.minecraft.core.GlobalPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;


public class TradeMaster extends Villager {

    public TradeMaster(EntityType<? extends Villager> entityType, Level level) {
        super(entityType, level, VillagerType.PLAINS);
        this.setVillagerData(this.getVillagerData().setProfession(ModVillagers.TRADE_MASTER.get()));
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0)
                .build();
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return damageSource != DamageSource.OUT_OF_WORLD;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void releasePoi(MemoryModuleType<GlobalPos> globalPosMemoryModuleType) {
    }

    public void startTrading(Player player)
    {
        this.setTradingPlayer(player);
        this.openTradingScreen(player, this.getDisplayName(), this.getVillagerData().getLevel());
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand interactionHand)
    {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && this.isAlive() && !this.isTrading() && !this.isSleeping() && !player.isSecondaryUseActive())
        {
            if (this.isBaby())
            {
                return InteractionResult.sidedSuccess(this.level.isClientSide);
            }
            else
            {
                boolean flag = this.getOffers().isEmpty();
                if (interactionHand == InteractionHand.MAIN_HAND)
                {
                    player.awardStat(Stats.TALKED_TO_VILLAGER);
                }
                if (flag)
                {
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }
                else
                {
                    if (!this.level.isClientSide && !this.offers.isEmpty())
                    {
                        this.startTrading(player);
                    }
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }
            }
        }
        else if (itemstack.getItem() == ModItems.REMOVER.get())
        {
            player.getInventory().add(ModItems.TRADE_MASTER_SPAWN_EGG.get().getDefaultInstance());
            this.kill();
            return super.mobInteract(player, interactionHand);
        }
        else
        {
            return super.mobInteract(player, interactionHand);
        }
    }

    @Override
    protected void customServerAiStep() {};
}
