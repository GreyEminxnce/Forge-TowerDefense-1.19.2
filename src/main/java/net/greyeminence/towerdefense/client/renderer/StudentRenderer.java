package net.greyeminence.towerdefense.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.greyeminence.towerdefense.*;
import net.greyeminence.towerdefense.changed.*;
import net.greyeminence.towerdefense.client.models.StudentModel;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.greyeminence.towerdefense.entity.custom.StudentElementary;
import net.greyeminence.towerdefense.entity.custom.StudentIntermediate;
import net.greyeminence.towerdefense.entity.custom.StudentSenior;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.SpinAttackEffectLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
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
public class StudentRenderer extends LivingEntityRendererCustom<Student, StudentModel<Student>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TowerDefense.MOD_ID, "textures/entity/student.png");
    private static final ResourceLocation TEXTURE_ELEMENTARY = new ResourceLocation(TowerDefense.MOD_ID, "textures/entity/student_elementary.png");
    private static final ResourceLocation TEXTURE_INTERMEDIATE = new ResourceLocation(TowerDefense.MOD_ID, "textures/entity/student_intermediate.png");
    private static final ResourceLocation TEXTURE_SENIOR = new ResourceLocation(TowerDefense.MOD_ID, "textures/entity/student_senior.png");

    public StudentRenderer(EntityRendererProvider.Context context)
    {
        this(context, true);
    }
    public StudentRenderer(EntityRendererProvider.Context context, boolean bool) {
super(context, new StudentModel(context.bakeLayer(StudentModel.LAYER_LOCATION), bool), 0.5F);
        this.addLayer(new StudentArmorLayer(this, new StudentModel(context.bakeLayer(StudentModel.LAYER_LOCATION), false), new StudentModel(context.bakeLayer(StudentModel.LAYER_LOCATION), false)));
        this.addLayer(new PlayerItemInHandLayer(this, context.getItemInHandRenderer()));
        this.addLayer(new ArrowLayerCustom(context, this));
        this.addLayer(new Deadmau5EarsLayerStudent(this));
//        this.addLayer(new CapeLayerCustom(this));
        this.addLayer(new CustomHeadLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
        this.addLayer(new ElytraLayer(this, context.getModelSet()));
//        this.addLayer(new ParrotOnShoulderLayer(this, context.getModelSet()));
        this.addLayer(new SpinAttackEffectLayer(this, context.getModelSet()));
//        this.addLayer(new BeeStingerLayer(this));
    }

    public void render(Student student, float float1, float float2, PoseStack poseStack, MultiBufferSource multiBufferSource, int int1) {
        this.setModelProperties(student);
        if (!MinecraftForge.EVENT_BUS.post(new RenderStudentEvent.Pre(student, this, float2, poseStack, multiBufferSource, int1))) {
            super.render(student, float1, float2, poseStack, multiBufferSource, int1);
            MinecraftForge.EVENT_BUS.post(new RenderStudentEvent.Post(student, this, float2, poseStack, multiBufferSource, int1));
        }
    }

    public Vec3 getRenderOffset(Student student, float float1) {
        return student.isCrouching() ? new Vec3(0.0, -0.125, 0.0) : super.getRenderOffset(student, float1);
    }

    private void setModelProperties(Student student) {
        StudentModel<Student> studentModel = this.getModel();
        if (student.isSpectator()) {
            studentModel.setAllVisible(false);
            studentModel.head.visible = true;
            studentModel.hat.visible = true;
        } else {
            studentModel.setAllVisible(true);
            studentModel.hat.visible = true;
            studentModel.jacket.visible = true;
            studentModel.leftPants.visible = true;
            studentModel.rightPants.visible = true;
            studentModel.leftSleeve.visible = true;
            studentModel.rightSleeve.visible = true;
            studentModel.crouching = student.isCrouching();
            StudentModel.ArmPose studentmodel$armpose = getArmPose(student, InteractionHand.MAIN_HAND);
            StudentModel.ArmPose studentmodel$armpose1 = getArmPose(student, InteractionHand.OFF_HAND);
            if (studentmodel$armpose.isTwoHanded()) {
                studentmodel$armpose1 = student.getOffhandItem().isEmpty() ? StudentModel.ArmPose.EMPTY : StudentModel.ArmPose.ITEM;
            }

            if (student.getMainArm() == HumanoidArm.RIGHT) {
                studentModel.rightArmPose = studentmodel$armpose;
                studentModel.leftArmPose = studentmodel$armpose1;
            } else {
                studentModel.rightArmPose = studentmodel$armpose1;
                studentModel.leftArmPose = studentmodel$armpose;
            }
        }

    }

    private static StudentModel.ArmPose getArmPose(Student student, InteractionHand interactionHand) {
        ItemStack itemstack = student.getItemInHand(interactionHand);
        if (itemstack.isEmpty()) {
            return StudentModel.ArmPose.EMPTY;
        } else {
            if (student.getUsedItemHand() == interactionHand /*&& student.getUseItemRemainingTicks() > 0*/) {
                UseAnim useanim = itemstack.getUseAnimation();
                if (useanim == UseAnim.BLOCK) {
                    return StudentModel.ArmPose.BLOCK;
                }

                if (useanim == UseAnim.BOW) {
                    return StudentModel.ArmPose.BOW_AND_ARROW;
                }

                if (useanim == UseAnim.SPEAR) {
                    return StudentModel.ArmPose.THROW_SPEAR;
                }

                if (useanim == UseAnim.CROSSBOW && interactionHand == student.getUsedItemHand()) {
                    return StudentModel.ArmPose.CROSSBOW_CHARGE;
                }

                if (useanim == UseAnim.SPYGLASS) {
                    return StudentModel.ArmPose.SPYGLASS;
                }

                if (useanim == UseAnim.TOOT_HORN) {
                    return StudentModel.ArmPose.TOOT_HORN;
                }
            } else if (!student.swinging && itemstack.getItem() instanceof CrossbowItem && CrossbowItem.isCharged(itemstack)) {
                return StudentModel.ArmPose.CROSSBOW_HOLD;
            }

            StudentModel.ArmPose forgeArmPose = IClientItemExtensionsStudent.of(itemstack).getArmPose(student, interactionHand, itemstack);
            return forgeArmPose != null ? forgeArmPose : StudentModel.ArmPose.ITEM;
        }
    }

    public ResourceLocation getTextureLocation(Student student)
    {
        if (student instanceof StudentElementary)
        {
            return TEXTURE_ELEMENTARY;
        }
        if (student instanceof StudentIntermediate)
        {
            return TEXTURE_INTERMEDIATE;
        }
        if (student instanceof StudentSenior)
        {
            return TEXTURE_SENIOR;
        }
        return TEXTURE;
    }

    protected void scale(Student student, PoseStack poseStack, float float1) {
        float f = 0.9375F;
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    protected void renderNameTag(Student student, Component component, PoseStack poseStack, MultiBufferSource multiBufferSource, int int1) {
/*        double d0 = this.entityRenderDispatcher.distanceToSqr(student);
        poseStack.pushPose();
        if (d0 < 100.0) {
            Scoreboard scoreboard = student.getScoreboard();
            Objective objective = scoreboard.getDisplayObjective(2);
            if (objective != null) {
                Score score = scoreboard.getOrCreatePlayerScore(student.getScoreboardName(), objective);
                super.renderNameTag(student, Component.literal(Integer.toString(score.getScore())).append(" ").append(objective.getDisplayName()), poseStack, multiBufferSource, int1);
                poseStack.translate(0.0, 0.25874999165534973, 0.0);

        }

        super.renderNameTag(student, component, poseStack, multiBufferSource, int1);
        poseStack.popPose();*/
    }

    public void renderRightHand(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Student student) {
        if (!ForgeHooksClientStudent.renderSpecificFirstPersonArm(poseStack, multiBufferSource, int1, student, HumanoidArm.RIGHT)) {
            this.renderHand(poseStack, multiBufferSource, int1, student, ((StudentModel)this.model).rightArm, ((StudentModel)this.model).rightSleeve);
        }

    }

    public void renderLeftHand(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Student student) {
        if (!ForgeHooksClientStudent.renderSpecificFirstPersonArm(poseStack, multiBufferSource, int1, student, HumanoidArm.LEFT)) {
            this.renderHand(poseStack, multiBufferSource, int1, student, ((StudentModel)this.model).leftArm, ((StudentModel)this.model).leftSleeve);
        }

    }

    private void renderHand(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, Student student, ModelPart modelPart1, ModelPart modelPart2) {
        StudentModel<Student> studentModel = (StudentModel)this.getModel();
        this.setModelProperties(student);
        studentModel.attackTime = 0.0F;
        studentModel.crouching = false;
        studentModel.swimAmount = 0.0F;
        studentModel.setupAnim(student, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        modelPart1.xRot = 0.0F;
        modelPart1.render(poseStack, multiBufferSource.getBuffer(RenderType.entitySolid(this.getTextureLocation(student))), int1, OverlayTexture.NO_OVERLAY);
        modelPart2.xRot = 0.0F;
        modelPart2.render(poseStack, multiBufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(student))), int1, OverlayTexture.NO_OVERLAY);
    }

    protected void setupRotations(Student student, PoseStack poseStack, float float1, float float2, float float3) {
        float f = student.getSwimAmount(float3);
        float f3;
        float f2;
        if (student.isFallFlying()) {
            super.setupRotations(student, poseStack, float1, float2, float3);
            f3 = (float)student.getFallFlyingTicks() + float3;
            f2 = Mth.clamp(f3 * f3 / 100.0F, 0.0F, 1.0F);
            if (!student.isAutoSpinAttack()) {
                poseStack.mulPose(Vector3f.XP.rotationDegrees(f2 * (-90.0F - student.getXRot())));
            }

            Vec3 vec3 = student.getViewVector(float3);
            Vec3 vec31 = student.getDeltaMovement();
            double d0 = vec31.horizontalDistanceSqr();
            double d1 = vec3.horizontalDistanceSqr();
            if (d0 > 0.0 && d1 > 0.0) {
                double d2 = (vec31.x * vec3.x + vec31.z * vec3.z) / Math.sqrt(d0 * d1);
                double d3 = vec31.x * vec3.z - vec31.z * vec3.x;
                poseStack.mulPose(Vector3f.YP.rotation((float)(Math.signum(d3) * Math.acos(d2))));
            }
        } else if (f > 0.0F) {
            super.setupRotations(student, poseStack, float1, float2, float3);
            f3 = !student.isInWater() && !student.isInFluidType((fluidType, height) -> {
                return student.canSwimInFluidType(fluidType);
            }) ? -90.0F : -90.0F - student.getXRot();
            f2 = Mth.lerp(f, 0.0F, f3);
            poseStack.mulPose(Vector3f.XP.rotationDegrees(f2));
            if (student.isVisuallySwimming()) {
                poseStack.translate(0.0, -1.0, 0.30000001192092896);
            }
        } else {
            super.setupRotations(student, poseStack, float1, float2, float3);
        }

    }
}

