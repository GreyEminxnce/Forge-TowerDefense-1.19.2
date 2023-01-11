package net.greyeminence.towerdefense;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.greyeminence.towerdefense.client.models.TeacherModel;
import net.greyeminence.towerdefense.client.renderer.TeacherRenderer;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Deadmau5EarsLayerCustom extends RenderLayer<Teacher, TeacherModel<Teacher>> {
    private final RenderLayerParent<Teacher, TeacherModel<Teacher>> teacherModelRenderLayerParent;

    public Deadmau5EarsLayerCustom(RenderLayerParent<Teacher, TeacherModel<Teacher>> teacherModelRenderLayerParent) {
        super(teacherModelRenderLayerParent);
        this.teacherModelRenderLayerParent = teacherModelRenderLayerParent;
    }

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Teacher teacher, float float1, float float2, float float3, float float4, float float5, float float6)
    {
        if ("deadmau5".equals(teacher.getName().getString()) /*&& teacher.isSkinLoaded()*/ && !teacher.isInvisible()) {
            VertexConsumer $$10 = multiBufferSource.getBuffer(RenderType.entitySolid(teacherModelRenderLayerParent.getTextureLocation(teacher)));
            int $$11 = LivingEntityRenderer.getOverlayCoords(teacher, 0.0F);

            for(int $$12 = 0; $$12 < 2; ++$$12) {
                float $$13 = Mth.lerp(float3, teacher.yRotO, teacher.getYRot()) - Mth.lerp(float3, teacher.yBodyRotO, teacher.yBodyRot);
                float $$14 = Mth.lerp(float3, teacher.xRotO, teacher.getXRot());
                poseStack.pushPose();
                poseStack.mulPose(Vector3f.YP.rotationDegrees($$13));
                poseStack.mulPose(Vector3f.XP.rotationDegrees($$14));
                poseStack.translate((double)(0.375F * (float)($$12 * 2 - 1)), 0.0, 0.0);
                poseStack.translate(0.0, -0.375, 0.0);
                poseStack.mulPose(Vector3f.XP.rotationDegrees(-$$14));
                poseStack.mulPose(Vector3f.YP.rotationDegrees(-$$13));
                float $$15 = 1.3333334F;
                poseStack.scale(1.3333334F, 1.3333334F, 1.3333334F);
                ((TeacherModel)this.getParentModel()).renderEars(poseStack, $$10, int1, $$11);
                poseStack.popPose();
            }

        }
    }
}
