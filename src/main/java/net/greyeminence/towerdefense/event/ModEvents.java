package net.greyeminence.towerdefense.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.greyeminence.towerdefense.entity.custom.TradeMaster;
import net.greyeminence.towerdefense.item.ModItems;
import net.greyeminence.towerdefense.villager.ModVillagers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TowerDefense.MOD_ID)
public class ModEvents
{
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
            if(event.getType() == ModVillagers.TRADE_MASTER.get())
            {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

                ItemStack stack = new ItemStack(ModItems.TEACHER_SPAWN_EGG.get(), 1);

                int villagerLevel = 1;

                CompoundTag offerOne = new MerchantOffer(new ItemStack(Items.GOLD_NUGGET, Teacher.getPrice()), stack,
                        Integer.MAX_VALUE,10,1F).createTag();
                offerOne.putBoolean("rewardExp", false);
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(offerOne));

               villagerLevel = 2;
                CompoundTag offerTwo = new MerchantOffer(new ItemStack(Items.GOLD_NUGGET, Teacher.getPrice()), stack,
                        Integer.MAX_VALUE,10,1F).createTag();

                offerTwo.putBoolean("rewardExp", false);
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(offerTwo));

            }
    }
    @Mod.EventBusSubscriber(modid = TowerDefense.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents
    {
        @SubscribeEvent
        public static void entityAttributeEventStudent(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.STUDENT.get(), Student.setAttributes());
        }
        @SubscribeEvent
        public static void entityAttributeEventTeacher(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER.get(), Teacher.setAttributes());
        }
        @SubscribeEvent
        public static void entityAttributeEventTradeMaster(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TRADE_MASTER.get(), TradeMaster.setAttributes());
        }
    }

}
