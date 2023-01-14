package net.greyeminence.towerdefense.entity;

import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.entity.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
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

    public static final RegistryObject<EntityType<StudentElementary>> STUDENT_ELEMENTARY =
            ENTITY_TYPES.register("student_elementary", () -> EntityType.Builder.of(StudentElementary::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "student_elementary").toString()));

    public static final RegistryObject<EntityType<StudentIntermediate>> STUDENT_INTERMEDIATE =
            ENTITY_TYPES.register("student_intermediate", () -> EntityType.Builder.of(StudentIntermediate::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "student_intermediate").toString()));

    public static final RegistryObject<EntityType<StudentSenior>> STUDENT_SENIOR =
            ENTITY_TYPES.register("student_senior", () -> EntityType.Builder.of(StudentSenior::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "student_senior").toString()));

     public static final RegistryObject<EntityType<Teacher>> TEACHER =
            ENTITY_TYPES.register("teacher", () -> EntityType.Builder.of(Teacher::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "teacher").toString()));

    public static final RegistryObject<EntityType<TeacherBowLevel1>> TEACHER_BOW_LEVEL_1 =
            ENTITY_TYPES.register("teacher_bow_level_1", () -> EntityType.Builder.of(TeacherBowLevel1::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "teacher_bow_level_1").toString()));

    public static final RegistryObject<EntityType<TeacherBowLevel2>> TEACHER_BOW_LEVEL_2 =
            ENTITY_TYPES.register("teacher_bow_level_2", () -> EntityType.Builder.of(TeacherBowLevel2::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "teacher_bow_level_2").toString()));

    public static final RegistryObject<EntityType<TeacherBowLevel3>> TEACHER_BOW_LEVEL_3 =
            ENTITY_TYPES.register("teacher_bow_level_3", () -> EntityType.Builder.of(TeacherBowLevel3::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "teacher_bow_level_3").toString()));

    public static final RegistryObject<EntityType<TeacherSwordLevel1>> TEACHER_SWORD_LEVEL_1 =
            ENTITY_TYPES.register("teacher_sword_level_1", () -> EntityType.Builder.of(TeacherSwordLevel1::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "teacher_sword_level_1").toString()));

    public static final RegistryObject<EntityType<TeacherSwordLevel2>> TEACHER_SWORD_LEVEL_2 =
            ENTITY_TYPES.register("teacher_sword_level_2", () -> EntityType.Builder.of(TeacherSwordLevel2::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "teacher_sword_level_2").toString()));

    public static final RegistryObject<EntityType<TeacherSwordLevel3>> TEACHER_SWORD_LEVEL_3 =
            ENTITY_TYPES.register("teacher_sword_level_3", () -> EntityType.Builder.of(TeacherSwordLevel3::new,
                    MobCategory.MONSTER).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "teacher_sword_level_3").toString()));

    public static final RegistryObject<EntityType<TradeMaster>> TRADE_MASTER =
            ENTITY_TYPES.register("trade_master", () -> EntityType.Builder.of(TradeMaster::new,
                    MobCategory.CREATURE).sized(0.6f, 1.95f)
                    .build(new ResourceLocation(TowerDefense.MOD_ID, "trade_master").toString()));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
