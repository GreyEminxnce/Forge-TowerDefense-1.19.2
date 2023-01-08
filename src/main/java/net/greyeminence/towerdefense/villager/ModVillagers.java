package net.greyeminence.towerdefense.villager;

import com.google.common.collect.ImmutableSet;
import com.ibm.icu.impl.locale.XCldrStub;
import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers
{
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TowerDefense.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TowerDefense.MOD_ID);

    public static final RegistryObject<PoiType> TRADE_BLOCK_POI = POI_TYPES.register("trade_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.TRADE_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> TRADE_MASTER = VILLAGER_PROFESSIONS.register("trade_master",
            () -> new VillagerProfession("trade_master", x -> x.get() == TRADE_BLOCK_POI.get(), x -> x.get() ==
                    TRADE_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static void registerPOIs()
    {
        try
        {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class)
                    .invoke(null, TRADE_BLOCK_POI.get());
        }

        catch (InvocationTargetException | IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
