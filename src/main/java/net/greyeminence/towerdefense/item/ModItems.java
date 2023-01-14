package net.greyeminence.towerdefense.item;

import net.greyeminence.towerdefense.changed.OnePerBlockSpawnEggItem;
import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.item.custom.Remover;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TowerDefense.MOD_ID);

    public static final RegistryObject<Item> REMOVER = ITEMS.register("remover",
            () -> new Remover(new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> STUDENT_SPAWN_EGG = ITEMS.register("student_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.STUDENT, 0x22b341, 0x19732e,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> STUDENT_ELEMENTARY_SPAWN_EGG = ITEMS.register("student_elementary_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.STUDENT_ELEMENTARY, 0x22b341, 0xff0000,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> STUDENT_INTERMEDIATE_SPAWN_EGG = ITEMS.register("student_intermediate_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.STUDENT_INTERMEDIATE, 0x22b341, 0x00ff00,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> STUDENT_SENIOR_SPAWN_EGG = ITEMS.register("student_senior_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.STUDENT_SENIOR, 0x22b341, 0x0000ff,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

       public static final RegistryObject<Item> TEACHER_SPAWN_EGG = ITEMS.register("teacher_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TEACHER, 0xff1493, 0xffaeb9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> TEACHER_BOW_LEVEL_1_SPAWN_EGG = ITEMS.register("teacher_bow_level_1_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TEACHER_BOW_LEVEL_1, 0xff1493, 0xffaeb9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> TEACHER_BOW_LEVEL_2_SPAWN_EGG = ITEMS.register("teacher_bow_level_2_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TEACHER_BOW_LEVEL_2, 0xff1493, 0xffaeb9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> TEACHER_BOW_LEVEL_3_SPAWN_EGG = ITEMS.register("teacher_bow_level_3_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TEACHER_BOW_LEVEL_3, 0xff1493, 0xffaeb9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> TEACHER_SWORD_LEVEL_1_SPAWN_EGG = ITEMS.register("teacher_sword_level_1_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TEACHER_SWORD_LEVEL_1, 0xff1493, 0xabffb9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> TEACHER_SWORD_LEVEL_2_SPAWN_EGG = ITEMS.register("teacher_sword_level_2_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TEACHER_SWORD_LEVEL_2, 0xff1493, 0xaeffb9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> TEACHER_SWORD_LEVEL_3_SPAWN_EGG = ITEMS.register("teacher_sword_level_3_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TEACHER_SWORD_LEVEL_3, 0xff1493, 0xaeffb9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> TRADE_MASTER_SPAWN_EGG = ITEMS.register("trade_master_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TRADE_MASTER, 0x4f1f93, 0x2faef9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
