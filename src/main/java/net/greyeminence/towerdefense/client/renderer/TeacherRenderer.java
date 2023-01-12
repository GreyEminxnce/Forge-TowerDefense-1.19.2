package net.greyeminence.towerdefense.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.greyeminence.towerdefense.*;
import net.greyeminence.towerdefense.client.models.TeacherModel;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.ArrowLayer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.SpinAttackEffectLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;

@OnlyIn(Dist.CLIENT)
public class TeacherRenderer extends LivingEntityRenderer<Teacher, TeacherModel<Teacher>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TowerDefense.MOD_ID, "textures/entity/student.png");
    public TeacherRenderer(EntityRendererProvider.Context context)
    {
        this(context, true);
    }
    public TeacherRenderer(EntityRendererProvider.Context context, boolean bool) {
super(context, new TeacherModel(context.bakeLayer(TeacherModel.LAYER_LOCATION), bool), 0.5F);
        this.addLayer(new TeacherArmorLayer(this, new TeacherModel(context.bakeLayer(TeacherModel.LAYER_LOCATION), false), new TeacherModel(context.bakeLayer(TeacherModel.LAYER_LOCATION), false)));
        this.addLayer(new PlayerItemInHandLayer(this, context.getItemInHandRenderer()));
        this.addLayer(new ArrowLayer(context, this));
        this.addLayer(new Deadmau5EarsLayerTeacher(this));
//        this.addLayer(new CapeLayerCustom(this));
        this.addLayer(new CustomHeadLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
        this.addLayer(new ElytraLayer(this, context.getModelSet()));
//        this.addLayer(new ParrotOnShoulderLayer(this, context.getModelSet()));
        this.addLayer(new SpinAttackEffectLayer(this, context.getModelSet()));
        this.addLayer(new BeeStingerLayer(this));
    }

    public void render(Teacher teacher, float float1, float float2, PoseStack poseStack, MultiBufferSource multiBufferSource, int int1) {
        this.setModelProperties(teacher);
        if (!MinecraftForge.EVENT_BUS.post(new RenderTeacherEvent.Pre(teacher, this, float2, poseStack, multiBufferSource, int1))) {
            super.render(teacher, float1, float2, poseStack, multiBufferSource, int1);
            MinecraftForge.EVENT_BUS.post(new RenderTeacherEvent.Post(teacher, this, float2, poseStack, multiBufferSource, int1));
        }
    }

    public Vec3 getRenderOffset(Teacher teacher, float float1) {
        return teacher.isCrouching() ? new Vec3(0.0, -0.125, 0.0) : super.getRenderOffset(teacher, float1);
    }

    private void setModelProperties(Teacher teacher) {
        TeacherModel<Teacher> teacherModel = this.getModel();
        if (teacher.isSpectator()) {
            teacherModel.setAllVisible(false);
            teacherModel.head.visible = true;
            teacherModel.hat.visible = true;
        } else {
            teacherModel.setAllVisible(true);
            teacherModel.hat.visible = true;
            teacherModel.jacket.visible = true;
            teacherModel.leftPants.visible = true;
            teacherModel.rightPants.visible = true;
            teacherModel.leftSleeve.visible = true;
            teacherModel.rightSleeve.visible = true;
            teacherModel.crouching = teacher.isCrouching();
            TeacherModel.ArmPose teachermodel$armpose = getArmPose(teacher, InteractionHand.MAIN_HAND);
            TeacherModel.ArmPose teachermodel$armpose1 = getArmPose(teacher, InteractionHand.OFF_HAND);
            if (teachermodel$armpose.isTwoHanded()) {
                teachermodel$armpose1 = teacher.getOffhandItem().isEmpty() ? TeacherModel.ArmPose.EMPTY : TeacherModel.ArmPose.ITEM;
            }

            if (teacher.getMainArm() == HumanoidArm.RIGHT) {
                teacherModel.rightArmPose = teachermodel$armpose;
                teacherModel.leftArmPose = teachermodel$armpose1;
            } else {
                teacherModel.rightArmPose = teachermodel$armpose1;
                teacherModel.leftArmPose = teachermodel$armpose;
            }
        }

    }

    private static TeacherModel.ArmPose getArmPose(Teacher teacher, InteractionHand interactionHand) {
        ItemStack itemstack = teacher.getItemInHand(interactionHand);
        if (itemstack.isEmpty()) {
            return TeacherModel.ArmPose.EMPTY;
        } else {
            if (teacher.getUsedItemHand() == interactionHand /*&& teacher.getUseItemRemainingTicks() > 0*/) {
                UseAnim useanim = itemstack.getUseAnimation();
                if (useanim == UseAnim.BLOCK) {
                    return TeacherModel.ArmPose.BLOCK;
                }

                if (useanim == UseAnim.BOW) {
                    return TeacherModel.ArmPose.BOW_AND_ARROW;
                }

                if (useanim == UseAnim.SPEAR) {
                    return TeacherModel.ArmPose.THROW_SPEAR;
                }

                if (useanim == UseAnim.CROSSBOW && interactionHand == teacher.getUsedItemHand()) {
                    return TeacherModel.ArmPose.CROSSBOW_CHARGE;
                }

                if (useanim == UseAnim.SPYGLASS) {
                    return TeacherModel.ArmPose.SPYGLASS;
                }

                if (useanim == UseAnim.TOOT_HORN) {
                    return TeacherModel.ArmPose.TOOT_HORN;
                }
            } else if (!teacher.swinging && itemstack.getItem() instanceof CrossbowItem && CrossbowItem.isCharged(itemstack)) {
                return TeacherModel.ArmPose.CROSSBOW_HOLD;
            }

            TeacherModel.ArmPose forgeArmPose = IClientItemExtensionsTeacher.of(itemstack).getArmPose(teacher, interactionHand, itemstack);
            return forgeArmPose != null ? forgeArmPose : TeacherModel.ArmPose.ITEM;
        }
    }

    public ResourceLocation getTextureLocation(Teacher teacher) {
        return TEXTURE;
    }

    protected void scale(Teacher teacher, PoseStack poseStack, float float1) {
        float f = 0.9375F;
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    protected void renderNameTag(Teacher teacher, Component component, PoseStack poseStack, MultiBufferSource multiBufferSource, int int1) {
/*        double d0 = this.entityRenderDispatcher.distanceToSqr(teacher);
        poseStack.pushPose();
        if (d0 < 100.0) {
            Scoreboard scoreboard = teacher.getScoreboard();
            Objective objective = scoreboard.getDisplayObjective(2);
            if (objective != null) {
                Score score = scoreboard.getOrCreatePlayerScore(teacher.getScoreboardName(), objective);
                super.renderNameTag(teacher, Component.literal(Integer.toString(score.getScore())).append(" ").append(objective.getDisplayName()), poseStack, multiBufferSource, int1);
                poseStack.translate(0.0, 0.25874999165534973, 0.0);

        }

        super.renderNameTag(teacher, component, poseStack, multiBufferSource, int1);
        poseStack.popPose();*/
    }

    public void renderRightHand(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Teacher teacher) {
        if (!ForgeHooksClientTeacher.renderSpecificFirstPersonArm(poseStack, multiBufferSource, int1, teacher, HumanoidArm.RIGHT)) {
            this.renderHand(poseStack, multiBufferSource, int1, teacher, ((TeacherModel)this.model).rightArm, ((TeacherModel)this.model).rightSleeve);
        }

    }

    public void renderLeftHand(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Teacher teacher) {
        if (!ForgeHooksClientTeacher.renderSpecificFirstPersonArm(poseStack, multiBufferSource, int1, teacher, HumanoidArm.LEFT)) {
            this.renderHand(poseStack, multiBufferSource, int1, teacher, ((TeacherModel)this.model).leftArm, ((TeacherModel)this.model).leftSleeve);
        }

    }

    private void renderHand(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Teacher teacher, ModelPart modelPart1, ModelPart modelPart2) {
        TeacherModel<Teacher> teacherModel = (TeacherModel)this.getModel();
        this.setModelProperties(teacher);
        teacherModel.attackTime = 0.0F;
        teacherModel.crouching = false;
        teacherModel.swimAmount = 0.0F;
        teacherModel.setupAnim(teacher, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        modelPart1.xRot = 0.0F;
        modelPart1.render(poseStack, multiBufferSource.getBuffer(RenderType.entitySolid(this.getTextureLocation(teacher))), int1, OverlayTexture.NO_OVERLAY);
        modelPart2.xRot = 0.0F;
        modelPart2.render(poseStack, multiBufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(teacher))), int1, OverlayTexture.NO_OVERLAY);
    }

    protected void setupRotations(Teacher teacher, PoseStack poseStack, float float1, float float2, float float3) {
        float f = teacher.getSwimAmount(float3);
        float f3;
        float f2;
        if (teacher.isFallFlying()) {
            super.setupRotations(teacher, poseStack, float1, float2, float3);
            f3 = (float)teacher.getFallFlyingTicks() + float3;
            f2 = Mth.clamp(f3 * f3 / 100.0F, 0.0F, 1.0F);
            if (!teacher.isAutoSpinAttack()) {
                poseStack.mulPose(Vector3f.XP.rotationDegrees(f2 * (-90.0F - teacher.getXRot())));
            }

            Vec3 vec3 = teacher.getViewVector(float3);
            Vec3 vec31 = teacher.getDeltaMovement();
            double d0 = vec31.horizontalDistanceSqr();
            double d1 = vec3.horizontalDistanceSqr();
            if (d0 > 0.0 && d1 > 0.0) {
                double d2 = (vec31.x * vec3.x + vec31.z * vec3.z) / Math.sqrt(d0 * d1);
                double d3 = vec31.x * vec3.z - vec31.z * vec3.x;
                poseStack.mulPose(Vector3f.YP.rotation((float)(Math.signum(d3) * Math.acos(d2))));
            }
        } else if (f > 0.0F) {
            super.setupRotations(teacher, poseStack, float1, float2, float3);
            f3 = !teacher.isInWater() && !teacher.isInFluidType((fluidType, height) -> {
                return teacher.canSwimInFluidType(fluidType);
            }) ? -90.0F : -90.0F - teacher.getXRot();
            f2 = Mth.lerp(f, 0.0F, f3);
            poseStack.mulPose(Vector3f.XP.rotationDegrees(f2));
            if (teacher.isVisuallySwimming()) {
                poseStack.translate(0.0, -1.0, 0.30000001192092896);
            }
        } else {
            super.setupRotations(teacher, poseStack, float1, float2, float3);
        }

    }
}
