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
        event.registerLayerDefinition(StudentModel.LAYER_LOCATION, () -> LayerDefinition.create(StudentModel.createMesh(new CubeDeformation(0.5F), true), 64, 64));
    }
    @SubscribeEvent
    public static void entityRenderersTeacher(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.TEACHER.get(), TeacherRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitionsTeacher(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(TeacherModel.LAYER_LOCATION, () -> LayerDefinition.create(TeacherModel.createMesh(new CubeDeformation(0.5F), true), 64, 64));
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
