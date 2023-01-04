package net.greyeminence.towerdefense.client.renderer;

import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.client.models.TeacherModel;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TeacherRenderer extends MobRenderer<Teacher, TeacherModel>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(TowerDefense.MOD_ID, "textures/entity/teacher.png");

    public TeacherRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx, new TeacherModel(ctx.bakeLayer(TeacherModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Teacher teacher)
    {
        return TEXTURE;
    }
}