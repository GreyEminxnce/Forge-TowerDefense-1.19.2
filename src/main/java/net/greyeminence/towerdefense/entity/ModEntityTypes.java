package net.greyeminence.towerdefense.entity;

import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TowerDefense.MOD_ID);

    public static final RegistryObject<EntityType<Student>> STUDENT =
            ENTITY_TYPES.register("student", () -> EntityType.Builder.of(Student::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "student").toString()));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
