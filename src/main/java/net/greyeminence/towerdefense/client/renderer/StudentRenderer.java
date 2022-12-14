package net.greyeminence.towerdefense.client.renderer;

import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.client.models.StudentModel;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StudentRenderer extends MobRenderer<Student, StudentModel>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(TowerDefense.MOD_ID, "textures/entity/student.png");

    public StudentRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx, new StudentModel(ctx.bakeLayer(StudentModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Student student)
    {
        return TEXTURE;
    }
}
