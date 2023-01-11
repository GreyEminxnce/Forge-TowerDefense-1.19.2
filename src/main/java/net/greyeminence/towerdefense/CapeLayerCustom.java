/*package net.greyeminence.towerdefense;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.greyeminence.towerdefense.client.models.TeacherModel;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CapeLayerCustom extends RenderLayer<Teacher, TeacherModel<Teacher>> {
    public CapeLayerCustom(RenderLayerParent<Teacher, TeacherModel<Teacher>> teacherModel) {
        super(teacherModel);
    }

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Teacher teacher, float float1, float float2, float float3, float float4, float float5, float float6) {
        if (teacher.isCapeLoaded() && !teacher.isInvisible() && teacher.isModelPartShown(PlayerModelPart.CAPE) && teacher.getCloakTextureLocation() != null) {
            ItemStack $$10 = teacher.getItemBySlot(EquipmentSlot.CHEST);
            if (!$$10.is(Items.ELYTRA)) {
                poseStack.pushPose();
                poseStack.translate(0.0, 0.0, 0.125);
                double $$11 = Mth.lerp((double)float3, teacher.xCloakO, teacher.xCloak) - Mth.lerp((double)float3, teacher.xo, teacher.getX());
                double $$12 = Mth.lerp((double)float3, teacher.yCloakO, teacher.yCloak) - Mth.lerp((double)float3, teacher.yo, teacher.getY());
                double $$13 = Mth.lerp((double)float3, teacher.zCloakO, teacher.zCloak) - Mth.lerp((double)float3, teacher.zo, teacher.getZ());
                float $$14 = teacher.yBodyRotO + (teacher.yBodyRot - teacher.yBodyRotO);
                double $$15 = (double)Mth.sin($$14 * 0.017453292F);
                double $$16 = (double)(-Mth.cos($$14 * 0.017453292F));
                float $$17 = (float)$$12 * 10.0F;
                $$17 = Mth.clamp($$17, -6.0F, 32.0F);
                float $$18 = (float)($$11 * $$15 + $$13 * $$16) * 100.0F;
                $$18 = Mth.clamp($$18, 0.0F, 150.0F);
                float $$19 = (float)($$11 * $$16 - $$13 * $$15) * 100.0F;
                $$19 = Mth.clamp($$19, -20.0F, 20.0F);
                if ($$18 < 0.0F) {
                    $$18 = 0.0F;
                }

                float $$20 = Mth.lerp(float3, teacher.oBob, teacher.bob);
                $$17 += Mth.sin(Mth.lerp(float3, teacher.walkDistO, teacher.walkDist) * 6.0F) * 32.0F * $$20;
                if (teacher.isCrouching()) {
                    $$17 += 25.0F;
                }

                poseStack.mulPose(Vector3f.XP.rotationDegrees(6.0F + $$18 / 2.0F + $$17));
                poseStack.mulPose(Vector3f.ZP.rotationDegrees($$19 / 2.0F));
                poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - $$19 / 2.0F));
                VertexConsumer $$21 = multiBufferSource.getBuffer(RenderType.entitySolid(teacher.getCloakTextureLocation()));
                ((TeacherModel)this.getParentModel()).renderCloak(poseStack, $$21, int1, OverlayTexture.NO_OVERLAY);
                poseStack.popPose();
            }
        }
    }
}
*/