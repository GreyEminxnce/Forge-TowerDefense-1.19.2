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

    public static final RegistryObject<Item> TEACHER_SPAWN_EGG = ITEMS.register("teacher_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TEACHER, 0xff1493, 0xffaeb9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static final RegistryObject<Item> TRADE_MASTER_SPAWN_EGG = ITEMS.register("trade_master_spawn_egg",
            () -> new OnePerBlockSpawnEggItem(ModEntityTypes.TRADE_MASTER, 0x4f1f93, 0x2faef9,
                    new Item.Properties().tab(ModCreativeModeTab.TOWERDEFENSE_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
