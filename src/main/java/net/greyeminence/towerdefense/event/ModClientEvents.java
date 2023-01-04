package net.greyeminence.towerdefense.event;

import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.client.models.StudentModel;
import net.greyeminence.towerdefense.client.renderer.StudentRenderer;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TowerDefense.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents
{
    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.STUDENT.get(), StudentRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(StudentModel.LAYER_LOCATION, StudentModel::createBodyLayer);
    }
}
