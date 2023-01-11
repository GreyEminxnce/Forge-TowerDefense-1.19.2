package net.greyeminence.towerdefense.entity.custom;

import net.greyeminence.towerdefense.item.ModItems;
import net.greyeminence.towerdefense.villager.ModVillagers;
import net.minecraft.core.GlobalPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;


public class TradeMaster extends Villager {

    private int villagerXp;
    private Player lastTradedPlayer;
    private int updateMerchantTimer;
    private boolean increaseProfessionLevelOnUpdate;

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

    public void startTrading(Player player) {
        this.setTradingPlayer(player);
        this.openTradingScreen(player, this.getDisplayName(), this.getVillagerData().getLevel());
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand interactionHand)
    {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && itemstack.getItem() != ModItems.REMOVER.get() && this.isAlive() && !this.isTrading() && !this.isSleeping() && !player.isSecondaryUseActive())
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
            return InteractionResult.PASS;
        }
        else
        {
            return InteractionResult.PASS;
        }
    }

    @Override
    protected void rewardTradeXp(MerchantOffer merchantOffer)
    {
        int i = 3 + this.random.nextInt(4);
        this.villagerXp += merchantOffer.getXp();
        this.lastTradedPlayer = this.getTradingPlayer();
        if (this.shouldIncreaseLevel())
        {
            this.updateMerchantTimer = 40;
            this.increaseProfessionLevelOnUpdate = true;
            i += 5;
        }

        if (merchantOffer.shouldRewardExp())
        {
            this.level.addFreshEntity(new ExperienceOrb(this.level, this.getX(), this.getY() + 0.5, this.getZ(), i));
        }
    }

    private boolean shouldIncreaseLevel()
    {
        int i = this.getVillagerData().getLevel();
        return VillagerData.canLevelUp(i) && this.villagerXp >= VillagerData.getMaxXpPerLevel(i);
    }

    @Override
    protected void customServerAiStep()
    {
        if (!this.isTrading() && this.updateMerchantTimer > 0)
        {
            --this.updateMerchantTimer;
            if (this.updateMerchantTimer <= 0)
            {
                if (this.increaseProfessionLevelOnUpdate)
                {
                    this.increaseMerchantCareer();
                    this.increaseProfessionLevelOnUpdate = false;
                }
            }
        }
    }
    private void increaseMerchantCareer()
    {
        this.setVillagerData(this.getVillagerData().setLevel(this.getVillagerData().getLevel() + 1));
        this.updateTrades();
    }
}
