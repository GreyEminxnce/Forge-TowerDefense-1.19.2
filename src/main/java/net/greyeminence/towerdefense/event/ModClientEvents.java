package net.greyeminence.towerdefense.event;

import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.client.models.StudentModel;
import net.greyeminence.towerdefense.client.models.TeacherModel;
import net.greyeminence.towerdefense.client.models.TradeMasterModel;
import net.greyeminence.towerdefense.client.renderer.StudentRenderer;
import net.greyeminence.towerdefense.client.renderer.TeacherRenderer;
import net.greyeminence.towerdefense.client.renderer.TradeMasterRenderer;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.entity.custom.TradeMaster;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TowerDefense.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents
{
    @SubscribeEvent
    public static void entityRenderersStudent(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.STUDENT.get(), StudentRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsStudent(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(StudentModel.LAYER_LOCATION, () -> LayerDefinition.create(StudentModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersStudentElementary(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.STUDENT_ELEMENTARY.get(), StudentRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsStudentElementary(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(StudentModel.LAYER_LOCATION, () -> LayerDefinition.create(StudentModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersStudentIntermediate(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.STUDENT_INTERMEDIATE.get(), StudentRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsStudentIntermediate(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(StudentModel.LAYER_LOCATION, () -> LayerDefinition.create(StudentModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersStudentSenior(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.STUDENT_SENIOR.get(), StudentRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsStudentSenior(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(StudentModel.LAYER_LOCATION, () -> LayerDefinition.create(StudentModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

       @SubscribeEvent
    public static void entityRenderersTeacher(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TEACHER.get(), TeacherRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTeacher(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TeacherModel.LAYER_LOCATION, () -> LayerDefinition.create(TeacherModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersTeacherBowLevel1(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TEACHER_BOW_LEVEL_1.get(), TeacherRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTeacherBowLevel1(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TeacherModel.LAYER_LOCATION, () -> LayerDefinition.create(TeacherModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersTeacherBowLevel2(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TEACHER_BOW_LEVEL_2.get(), TeacherRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTeacherBowLevel2(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TeacherModel.LAYER_LOCATION, () -> LayerDefinition.create(TeacherModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersTeacherBowLevel3(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TEACHER_BOW_LEVEL_3.get(), TeacherRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTeacherBowLevel3(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TeacherModel.LAYER_LOCATION, () -> LayerDefinition.create(TeacherModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersTeacherSwordLevel1(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TEACHER_SWORD_LEVEL_1.get(), TeacherRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTeacherSwordLevel1(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TeacherModel.LAYER_LOCATION, () -> LayerDefinition.create(TeacherModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersTeacherSwordLevel2(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TEACHER_SWORD_LEVEL_2.get(), TeacherRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTeacherSwordLevel2(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TeacherModel.LAYER_LOCATION, () -> LayerDefinition.create(TeacherModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersTeacherSwordLevel3(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TEACHER_SWORD_LEVEL_3.get(), TeacherRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTeacherSwordLevel3(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TeacherModel.LAYER_LOCATION, () -> LayerDefinition.create(TeacherModel.createMesh(new CubeDeformation(0.5F), false), 64, 64));
    }

    @SubscribeEvent
    public static void entityRenderersTradeMaster(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TRADE_MASTER.get(), TradeMasterRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTradeMaster(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TradeMasterModel.LAYER_LOCATION, () -> LayerDefinition.create(TradeMasterModel.createBodyModel(), 64, 64));
    }

}
