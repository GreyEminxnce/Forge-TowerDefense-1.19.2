package net.greyeminence.towerdefense.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.entity.custom.*;
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

            int villagerLevel = 1;
            CompoundTag offer_Bow_Level_1 = new MerchantOffer(new ItemStack(Items.GOLD_NUGGET,
                    TeacherBowLevel1.getPrice()),
                    new ItemStack(ModItems.TEACHER_BOW_LEVEL_1_SPAWN_EGG.get(), 1),
                    Integer.MAX_VALUE,10,1F).createTag();
            offer_Bow_Level_1.putBoolean("rewardExp", false);
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(offer_Bow_Level_1));

            CompoundTag offer_Sword_Level_1 = new MerchantOffer(new ItemStack(Items.GOLD_NUGGET,
                    TeacherSwordLevel1.getPrice()),
                    new ItemStack(ModItems.TEACHER_SWORD_LEVEL_1_SPAWN_EGG.get(), 1),
                    Integer.MAX_VALUE,10,1F).createTag();
            offer_Sword_Level_1.putBoolean("rewardExp", false);
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(offer_Sword_Level_1));


            villagerLevel = 2;
            CompoundTag offer_Bow_Level_2 = new MerchantOffer(new ItemStack(Items.GOLD_NUGGET,
                    TeacherBowLevel2.getPrice()),
                    new ItemStack(ModItems.TEACHER_BOW_LEVEL_2_SPAWN_EGG.get(), 1),
                    Integer.MAX_VALUE,10,1F).createTag();
            offer_Bow_Level_2.putBoolean("rewardExp", false);
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(offer_Bow_Level_2));

            CompoundTag offer_Sword_Level_2 = new MerchantOffer(new ItemStack(Items.GOLD_NUGGET,
                    TeacherSwordLevel2.getPrice()),
                    new ItemStack(ModItems.TEACHER_SWORD_LEVEL_2_SPAWN_EGG.get(), 1),
                    Integer.MAX_VALUE,10,1F).createTag();
            offer_Sword_Level_2.putBoolean("rewardExp", false);
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(offer_Sword_Level_2));


            villagerLevel = 3;
            CompoundTag offer_Bow_Level_3 = new MerchantOffer(new ItemStack(Items.GOLD_NUGGET,
                    TeacherBowLevel3.getPrice()),
                    new ItemStack(ModItems.TEACHER_BOW_LEVEL_3_SPAWN_EGG.get(), 1),
                    Integer.MAX_VALUE,10,1F).createTag();
            offer_Bow_Level_3.putBoolean("rewardExp", false);
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(offer_Bow_Level_3));

            CompoundTag offer_Sword_Level_3 = new MerchantOffer(new ItemStack(Items.GOLD_NUGGET,
                    TeacherSwordLevel3.getPrice()),
                    new ItemStack(ModItems.TEACHER_SWORD_LEVEL_3_SPAWN_EGG.get(), 1),
                    Integer.MAX_VALUE,10,1F).createTag();
            offer_Sword_Level_3.putBoolean("rewardExp", false);
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(offer_Sword_Level_3));
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
        public static void entityAttributeEventStudentElementary(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.STUDENT_ELEMENTARY.get(), StudentElementary.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventStudentIntermediate(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.STUDENT_INTERMEDIATE.get(), StudentIntermediate.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventStudentSenior(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.STUDENT_SENIOR.get(), StudentSenior.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventTeacher(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER.get(), Teacher.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventTeacherBowLevel1(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER_BOW_LEVEL_1.get(), TeacherBowLevel1.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventTeacherBowLevel2(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER_BOW_LEVEL_2.get(), TeacherBowLevel2.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventTeacherBowLevel3(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER_BOW_LEVEL_3.get(), TeacherBowLevel3.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventTeacherSwordLevel1(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER_SWORD_LEVEL_1.get(), TeacherSwordLevel1.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventTeacherSwordLevel2(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER_SWORD_LEVEL_2.get(), TeacherSwordLevel2.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventTeacherSwordLevel3(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER_SWORD_LEVEL_3.get(), TeacherSwordLevel3.setAttributes());
        }

        @SubscribeEvent
        public static void entityAttributeEventTradeMaster(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TRADE_MASTER.get(), TradeMaster.setAttributes());
        }
    }

}
