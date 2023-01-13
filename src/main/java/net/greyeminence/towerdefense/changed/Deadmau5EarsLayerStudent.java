package net.greyeminence.towerdefense.changed;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.greyeminence.towerdefense.client.models.StudentModel;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Deadmau5EarsLayerStudent extends RenderLayer<Student, StudentModel<Student>> {
    private final RenderLayerParent<Student, StudentModel<Student>> studentModelRenderLayerParent;

    public Deadmau5EarsLayerStudent(RenderLayerParent<Student, StudentModel<Student>> studentModelRenderLayerParent) {
        super(studentModelRenderLayerParent);
        this.studentModelRenderLayerParent = studentModelRenderLayerParent;
    }

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Student student, float float1, float float2, float float3, float float4, float float5, float float6)
    {
        if ("deadmau5".equals(student.getName().getString()) /*&& student.isSkinLoaded()*/ && !student.isInvisible()) {
            VertexConsumer $$10 = multiBufferSource.getBuffer(RenderType.entitySolid(studentModelRenderLayerParent.getTextureLocation(student)));
            int $$11 = LivingEntityRenderer.getOverlayCoords(student, 0.0F);

            for(int $$12 = 0; $$12 < 2; ++$$12) {
                float $$13 = Mth.lerp(float3, student.yRotO, student.getYRot()) - Mth.lerp(float3, student.yBodyRotO, student.yBodyRot);
                float $$14 = Mth.lerp(float3, student.xRotO, student.getXRot());
                poseStack.pushPose();
                poseStack.mulPose(Vector3f.YP.rotationDegrees($$13));
                poseStack.mulPose(Vector3f.XP.rotationDegrees($$14));
                poseStack.translate((double)(0.375F * (float)($$12 * 2 - 1)), 0.0, 0.0);
                poseStack.translate(0.0, -0.375, 0.0);
                poseStack.mulPose(Vector3f.XP.rotationDegrees(-$$14));
                poseStack.mulPose(Vector3f.YP.rotationDegrees(-$$13));
                float $$15 = 1.3333334F;
                poseStack.scale(1.3333334F, 1.3333334F, 1.3333334F);
                ((StudentModel)this.getParentModel()).renderEars(poseStack, $$10, int1, $$11);
                poseStack.popPose();
            }

        }
    }
}
