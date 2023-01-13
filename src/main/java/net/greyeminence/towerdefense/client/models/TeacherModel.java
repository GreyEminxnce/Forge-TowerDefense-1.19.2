package net.greyeminence.towerdefense.client.models;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.greyeminence.towerdefense.changed.IArmPoseTransformerCustom;
import net.greyeminence.towerdefense.TowerDefense;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IExtensibleEnum;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class TeacherModel<T extends LivingEntity> extends EntityModel<T> implements ArmedModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TowerDefense.MOD_ID, "teacher"), "main");
    private final boolean scaleHead;
    private final float babyYHeadOffset;
    private final float babyZHeadOffset;
    private final float babyHeadScale;
    private final float babyBodyScale;
    private final float bodyYOffset;
    public static final float OVERLAY_SCALE = 0.25F;
    public static final float HAT_OVERLAY_SCALE = 0.5F;
    private static final float SPYGLASS_ARM_ROT_Y = 0.2617994F;
    private static final float SPYGLASS_ARM_ROT_X = 1.9198622F;
    private static final float SPYGLASS_ARM_CROUCH_ROT_X = 0.2617994F;
    public static final float TOOT_HORN_XROT_BASE = 1.4835298F;
    public static final float TOOT_HORN_YROT_BASE = 0.5235988F;
    public final ModelPart head;
    public final ModelPart hat;
    public final ModelPart body;
    public final ModelPart rightArm;
    public final ModelPart leftArm;
    public final ModelPart rightLeg;
    public final ModelPart leftLeg;
    public ArmPose leftArmPose;
    public ArmPose rightArmPose;
    public boolean crouching;
    public float swimAmount;
    private static final String EAR = "ear";
    private static final String CLOAK = "cloak";
    private static final String LEFT_SLEEVE = "left_sleeve";
    private static final String RIGHT_SLEEVE = "right_sleeve";
    private static final String LEFT_PANTS = "left_pants";
    private static final String RIGHT_PANTS = "right_pants";
    private final List<ModelPart> parts;
    public final ModelPart leftSleeve;
    public final ModelPart rightSleeve;
    public final ModelPart leftPants;
    public final ModelPart rightPants;
    public final ModelPart jacket;
    private final ModelPart cloak;
    private final ModelPart ear;
    private final boolean slim;
    private net.minecraft.world.InteractionHand InteractionHand;

    public TeacherModel(ModelPart modelPart, boolean isSlim) {
        super(RenderType::entityTranslucent);
        this.scaleHead = true;
        this.babyYHeadOffset = 16.0F;
        this.babyZHeadOffset = 0.0F;
        this.babyHeadScale = 2.0F;
        this.babyBodyScale = 2.0F;
        this.bodyYOffset = 24.0F;
        this.leftArmPose = ArmPose.EMPTY;
        this.rightArmPose = ArmPose.EMPTY;
        this.head = modelPart.getChild("head");
        this.hat = modelPart.getChild("hat");
        this.body = modelPart.getChild("body");
        this.rightArm = modelPart.getChild("right_arm");
        this.leftArm = modelPart.getChild("left_arm");
        this.rightLeg = modelPart.getChild("right_leg");
        this.leftLeg = modelPart.getChild("left_leg");
        this.slim = isSlim;
        this.ear = modelPart.getChild("ear");
        this.cloak = modelPart.getChild("cloak");
        this.leftSleeve = modelPart.getChild("left_sleeve");
        this.rightSleeve = modelPart.getChild("right_sleeve");
        this.leftPants = modelPart.getChild("left_pants");
        this.rightPants = modelPart.getChild("right_pants");
        this.jacket = modelPart.getChild("jacket");
        this.parts = (List)modelPart.getAllParts().filter((p_170824_) -> {
            return !p_170824_.isEmpty();
        }).collect(ImmutableList.toImmutableList());
    }

    public static MeshDefinition createMesh(CubeDeformation cubeDeformation, boolean bool) {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
        partdefinition.addOrReplaceChild("ear", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -1.0F, 6.0F, 6.0F, 1.0F, cubeDeformation), PartPose.ZERO);
        partdefinition.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 16.0F, 1.0F, cubeDeformation, 1.0F, 0.5F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_pants", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubeDeformation.extend(0.25F)), PartPose.offset(1.9F, 12.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_pants", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, cubeDeformation.extend(0.25F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
        partdefinition.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, cubeDeformation.extend(0.25F)), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48).addBox(0F, 0F, 0F, 0F, 0F, 0F, cubeDeformation.extend(0.25F)), PartPose.offset(5.0F, 2.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32).addBox(0F, 0F, 0F, 0F, 0F, 0F, cubeDeformation.extend(0.25F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
        return meshdefinition;
    }

    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head);
    }

    protected Iterable<ModelPart> bodyParts() {
        return Iterables.concat(ImmutableList.of(this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg, this.hat), ImmutableList.of(this.leftPants, this.rightPants, this.leftSleeve, this.rightSleeve, this.jacket));
    }

    public void prepareMobModel(T teacher, float p_102862_, float p_102863_, float p_102864_) {
        this.swimAmount = teacher.getSwimAmount(p_102864_);
    }

    public void renderEars(PoseStack p_103402_, VertexConsumer p_103403_, int p_103404_, int p_103405_) {
        this.ear.copyFrom(this.head);
        this.ear.x = 0.0F;
        this.ear.y = 0.0F;
        this.ear.render(p_103402_, p_103403_, p_103404_, p_103405_);
    }

    public void renderCloak(PoseStack p_103412_, VertexConsumer p_103413_, int p_103414_, int p_103415_) {
        this.cloak.render(p_103412_, p_103413_, p_103414_, p_103415_);
    }

    public void setupAnim(T teacher, float float1, float float2, float float3, float float4, float float5) {
        boolean flag = teacher.getFallFlyingTicks() > 4;
        boolean flag1 = teacher.isVisuallySwimming();
        this.head.yRot = float4 * 0.017453292F;
        if (flag) {
            this.head.xRot = -0.7853982F;
        } else if (this.swimAmount > 0.0F) {
            if (flag1) {
                this.head.xRot = this.rotlerpRad(this.swimAmount, this.head.xRot, -0.7853982F);
            } else {
                this.head.xRot = this.rotlerpRad(this.swimAmount, this.head.xRot, float5 * 0.017453292F);
            }
        } else {
            this.head.xRot = float5 * 0.017453292F;
        }

        this.body.yRot = 0.0F;
        this.rightArm.z = 0.0F;
        this.rightArm.x = -5.0F;
        this.leftArm.z = 0.0F;
        this.leftArm.x = 5.0F;
        float f = 1.0F;
        if (flag) {
            f = (float)teacher.getDeltaMovement().lengthSqr();
            f /= 0.2F;
            f *= f * f;
        }

        if (f < 1.0F) {
            f = 1.0F;
        }

        this.rightArm.xRot = Mth.cos(float1 * 0.6662F + 3.1415927F) * 2.0F * float2 * 0.5F / f;
        this.leftArm.xRot = Mth.cos(float1 * 0.6662F) * 2.0F * float2 * 0.5F / f;
        this.rightArm.zRot = 0.0F;
        this.leftArm.zRot = 0.0F;
        this.rightLeg.xRot = Mth.cos(float1 * 0.6662F) * 1.4F * float2 / f;
        this.leftLeg.xRot = Mth.cos(float1 * 0.6662F + 3.1415927F) * 1.4F * float2 / f;
        this.rightLeg.yRot = 0.0F;
        this.leftLeg.yRot = 0.0F;
        this.rightLeg.zRot = 0.0F;
        this.leftLeg.zRot = 0.0F;
        ModelPart var10000;
        if (this.riding) {
            var10000 = this.rightArm;
            var10000.xRot += -0.62831855F;
            var10000 = this.leftArm;
            var10000.xRot += -0.62831855F;
            this.rightLeg.xRot = -1.4137167F;
            this.rightLeg.yRot = 0.31415927F;
            this.rightLeg.zRot = 0.07853982F;
            this.leftLeg.xRot = -1.4137167F;
            this.leftLeg.yRot = -0.31415927F;
            this.leftLeg.zRot = -0.07853982F;
        }

        this.rightArm.yRot = 0.0F;
        this.leftArm.yRot = 0.0F;
        boolean flag2 = teacher.getMainArm() == HumanoidArm.RIGHT;
        boolean flag3;
        if (teacher.isUsingItem()) {
            flag3 = teacher.getUsedItemHand() == InteractionHand.MAIN_HAND;
            if (flag3 == flag2) {
                this.poseRightArm(teacher);
            } else {
                this.poseLeftArm(teacher);
            }
        } else {
            flag3 = flag2 ? this.leftArmPose.isTwoHanded() : this.rightArmPose.isTwoHanded();
            if (flag2 != flag3) {
                this.poseLeftArm(teacher);
                this.poseRightArm(teacher);
            } else {
                this.poseRightArm(teacher);
                this.poseLeftArm(teacher);
            }
        }

        this.setupAttackAnimation(teacher, float3);
        if (this.crouching) {
            this.body.xRot = 0.5F;
            var10000 = this.rightArm;
            var10000.xRot += 0.4F;
            var10000 = this.leftArm;
            var10000.xRot += 0.4F;
            this.rightLeg.z = 4.0F;
            this.leftLeg.z = 4.0F;
            this.rightLeg.y = 12.2F;
            this.leftLeg.y = 12.2F;
            this.head.y = 4.2F;
            this.body.y = 3.2F;
            this.leftArm.y = 5.2F;
            this.rightArm.y = 5.2F;
        } else {
            this.body.xRot = 0.0F;
            this.rightLeg.z = 0.1F;
            this.leftLeg.z = 0.1F;
            this.rightLeg.y = 12.0F;
            this.leftLeg.y = 12.0F;
            this.head.y = 0.0F;
            this.body.y = 0.0F;
            this.leftArm.y = 2.0F;
            this.rightArm.y = 2.0F;
        }

        if (this.rightArmPose != ArmPose.SPYGLASS) {
            AnimationUtils.bobModelPart(this.rightArm, float3, 1.0F);
        }

        if (this.leftArmPose != ArmPose.SPYGLASS) {
            AnimationUtils.bobModelPart(this.leftArm, float3, -1.0F);
        }

        if (this.swimAmount > 0.0F) {
            float f5 = float1 % 26.0F;
            HumanoidArm humanoidarm = this.getAttackArm(teacher);
            float f1 = humanoidarm == HumanoidArm.RIGHT && this.attackTime > 0.0F ? 0.0F : this.swimAmount;
            float f2 = humanoidarm == HumanoidArm.LEFT && this.attackTime > 0.0F ? 0.0F : this.swimAmount;
            float f3;
            if (!teacher.isUsingItem()) {
                if (f5 < 14.0F) {
                    this.leftArm.xRot = this.rotlerpRad(f2, this.leftArm.xRot, 0.0F);
                    this.rightArm.xRot = Mth.lerp(f1, this.rightArm.xRot, 0.0F);
                    this.leftArm.yRot = this.rotlerpRad(f2, this.leftArm.yRot, 3.1415927F);
                    this.rightArm.yRot = Mth.lerp(f1, this.rightArm.yRot, 3.1415927F);
                    this.leftArm.zRot = this.rotlerpRad(f2, this.leftArm.zRot, 3.1415927F + 1.8707964F * this.quadraticArmUpdate(f5) / this.quadraticArmUpdate(14.0F));
                    this.rightArm.zRot = Mth.lerp(f1, this.rightArm.zRot, 3.1415927F - 1.8707964F * this.quadraticArmUpdate(f5) / this.quadraticArmUpdate(14.0F));
                } else if (f5 >= 14.0F && f5 < 22.0F) {
                    f3 = (f5 - 14.0F) / 8.0F;
                    this.leftArm.xRot = this.rotlerpRad(f2, this.leftArm.xRot, 1.5707964F * f3);
                    this.rightArm.xRot = Mth.lerp(f1, this.rightArm.xRot, 1.5707964F * f3);
                    this.leftArm.yRot = this.rotlerpRad(f2, this.leftArm.yRot, 3.1415927F);
                    this.rightArm.yRot = Mth.lerp(f1, this.rightArm.yRot, 3.1415927F);
                    this.leftArm.zRot = this.rotlerpRad(f2, this.leftArm.zRot, 5.012389F - 1.8707964F * f3);
                    this.rightArm.zRot = Mth.lerp(f1, this.rightArm.zRot, 1.2707963F + 1.8707964F * f3);
                } else if (f5 >= 22.0F && f5 < 26.0F) {
                    f3 = (f5 - 22.0F) / 4.0F;
                    this.leftArm.xRot = this.rotlerpRad(f2, this.leftArm.xRot, 1.5707964F - 1.5707964F * f3);
                    this.rightArm.xRot = Mth.lerp(f1, this.rightArm.xRot, 1.5707964F - 1.5707964F * f3);
                    this.leftArm.yRot = this.rotlerpRad(f2, this.leftArm.yRot, 3.1415927F);
                    this.rightArm.yRot = Mth.lerp(f1, this.rightArm.yRot, 3.1415927F);
                    this.leftArm.zRot = this.rotlerpRad(f2, this.leftArm.zRot, 3.1415927F);
                    this.rightArm.zRot = Mth.lerp(f1, this.rightArm.zRot, 3.1415927F);
                }
            }

            f3 = 0.3F;
            float f4 = 0.33333334F;
            this.leftLeg.xRot = Mth.lerp(this.swimAmount, this.leftLeg.xRot, 0.3F * Mth.cos(float1 * 0.33333334F + 3.1415927F));
            this.rightLeg.xRot = Mth.lerp(this.swimAmount, this.rightLeg.xRot, 0.3F * Mth.cos(float1 * 0.33333334F));
        }

        this.hat.copyFrom(this.head);
        this.leftPants.copyFrom(this.leftLeg);
        this.rightPants.copyFrom(this.rightLeg);
        this.leftSleeve.copyFrom(this.leftArm);
        this.rightSleeve.copyFrom(this.rightArm);
        this.jacket.copyFrom(this.body);
        if (teacher.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
            if (teacher.isCrouching()) {
                this.cloak.z = 1.4F;
                this.cloak.y = 1.85F;
            } else {
                this.cloak.z = 0.0F;
                this.cloak.y = 0.0F;
            }
        } else if (teacher.isCrouching()) {
            this.cloak.z = 0.3F;
            this.cloak.y = 0.8F;
        } else {
            this.cloak.z = -1.1F;
            this.cloak.y = -0.85F;
        }

    }

    private void poseRightArm(T teacher) {
        switch (this.rightArmPose) {
            case EMPTY:
                this.rightArm.yRot = 0.0F;
                break;
            case BLOCK:
                this.rightArm.xRot = this.rightArm.xRot * 0.5F - 0.9424779F;
                this.rightArm.yRot = -0.5235988F;
                break;
            case ITEM:
                this.rightArm.xRot = this.rightArm.xRot * 0.5F - 0.31415927F;
                this.rightArm.yRot = 0.0F;
                break;
            case THROW_SPEAR:
                this.rightArm.xRot = this.rightArm.xRot * 0.5F - 3.1415927F;
                this.rightArm.yRot = 0.0F;
                break;
            case BOW_AND_ARROW:
                this.rightArm.yRot = -0.1F + this.head.yRot;
                this.leftArm.yRot = 0.1F + this.head.yRot + 0.4F;
                this.rightArm.xRot = -1.5707964F + this.head.xRot;
                this.leftArm.xRot = -1.5707964F + this.head.xRot;
                break;
            case CROSSBOW_CHARGE:
                AnimationUtils.animateCrossbowCharge(this.rightArm, this.leftArm, teacher, true);
                break;
            case CROSSBOW_HOLD:
                AnimationUtils.animateCrossbowHold(this.rightArm, this.leftArm, this.head, true);
                break;
            case SPYGLASS:
                this.rightArm.xRot = Mth.clamp(this.head.xRot - 1.9198622F - (teacher.isCrouching() ? 0.2617994F : 0.0F), -2.4F, 3.3F);
                this.rightArm.yRot = this.head.yRot - 0.2617994F;
                break;
            case TOOT_HORN:
                this.rightArm.xRot = Mth.clamp(this.head.xRot, -1.2F, 1.2F) - 1.4835298F;
                this.rightArm.yRot = this.head.yRot - 0.5235988F;
            default:
                this.rightArmPose.applyTransform(this, teacher, HumanoidArm.RIGHT);
        }

    }

    private void poseLeftArm(T teacher) {
        switch (this.leftArmPose) {
            case EMPTY:
                this.leftArm.yRot = 0.0F;
                break;
            case BLOCK:
                this.leftArm.xRot = this.leftArm.xRot * 0.5F - 0.9424779F;
                this.leftArm.yRot = 0.5235988F;
                break;
            case ITEM:
                this.leftArm.xRot = this.leftArm.xRot * 0.5F - 0.31415927F;
                this.leftArm.yRot = 0.0F;
                break;
            case THROW_SPEAR:
                this.leftArm.xRot = this.leftArm.xRot * 0.5F - 3.1415927F;
                this.leftArm.yRot = 0.0F;
                break;
            case BOW_AND_ARROW:
                this.rightArm.yRot = -0.1F + this.head.yRot - 0.4F;
                this.leftArm.yRot = 0.1F + this.head.yRot;
                this.rightArm.xRot = -1.5707964F + this.head.xRot;
                this.leftArm.xRot = -1.5707964F + this.head.xRot;
                break;
            case CROSSBOW_CHARGE:
                AnimationUtils.animateCrossbowCharge(this.rightArm, this.leftArm, teacher, false);
                break;
            case CROSSBOW_HOLD:
                AnimationUtils.animateCrossbowHold(this.rightArm, this.leftArm, this.head, false);
                break;
            case SPYGLASS:
                this.leftArm.xRot = Mth.clamp(this.head.xRot - 1.9198622F - (teacher.isCrouching() ? 0.2617994F : 0.0F), -2.4F, 3.3F);
                this.leftArm.yRot = this.head.yRot + 0.2617994F;
                break;
            case TOOT_HORN:
                this.leftArm.xRot = Mth.clamp(this.head.xRot, -1.2F, 1.2F) - 1.4835298F;
                this.leftArm.yRot = this.head.yRot + 0.5235988F;
            default:
                this.leftArmPose.applyTransform(this, teacher, HumanoidArm.LEFT);
        }

    }
    public void setAllVisible(boolean bool) {
        this.head.visible = bool;
        this.hat.visible = bool;
        this.body.visible = bool;
        this.rightArm.visible = bool;
        this.leftArm.visible = bool;
        this.rightLeg.visible = bool;
        this.leftLeg.visible = bool;
        this.leftSleeve.visible = bool;
        this.rightSleeve.visible = bool;
        this.leftPants.visible = bool;
        this.rightPants.visible = bool;
        this.jacket.visible = bool;
        this.cloak.visible = bool;
        this.ear.visible = false;
    }

    public void translateToHand(HumanoidArm humanoidArm, PoseStack poseStack) {
        ModelPart $$2 = this.getArm(humanoidArm);
        if (this.slim) {
            float $$3 = 0.5F * (float)(humanoidArm == HumanoidArm.RIGHT ? 1 : -1);
            $$2.x += $$3;
            $$2.translateAndRotate(poseStack);
            $$2.x -= $$3;
        } else {
            $$2.translateAndRotate(poseStack);
        }

    }

    public ModelPart getRandomModelPart(RandomSource randomSource) {
        return (ModelPart)this.parts.get(randomSource.nextInt(this.parts.size()));
    }

    protected void setupAttackAnimation(T teacher, float float1) {
        if (!(this.attackTime <= 0.0F)) {
            HumanoidArm humanoidarm = this.getAttackArm(teacher);
            ModelPart modelpart = this.getArm(humanoidarm);
            float f = this.attackTime;
            this.body.yRot = Mth.sin(Mth.sqrt(f) * 6.2831855F) * 0.2F;
            ModelPart var10000;
            if (humanoidarm == HumanoidArm.LEFT) {
                var10000 = this.body;
                var10000.yRot *= -1.0F;
            }

            this.rightArm.z = Mth.sin(this.body.yRot) * 5.0F;
            this.rightArm.x = -Mth.cos(this.body.yRot) * 5.0F;
            this.leftArm.z = -Mth.sin(this.body.yRot) * 5.0F;
            this.leftArm.x = Mth.cos(this.body.yRot) * 5.0F;
            var10000 = this.rightArm;
            var10000.yRot += this.body.yRot;
            var10000 = this.leftArm;
            var10000.yRot += this.body.yRot;
            var10000 = this.leftArm;
            var10000.xRot += this.body.yRot;
            f = 1.0F - this.attackTime;
            f *= f;
            f *= f;
            f = 1.0F - f;
            float f1 = Mth.sin(f * 3.1415927F);
            float f2 = Mth.sin(this.attackTime * 3.1415927F) * -(this.head.xRot - 0.7F) * 0.75F;
            modelpart.xRot -= f1 * 1.2F + f2;
            modelpart.yRot += this.body.yRot * 2.0F;
            modelpart.zRot += Mth.sin(this.attackTime * 3.1415927F) * -0.4F;
        }

    }

    protected float rotlerpRad(float float1, float float2, float float3) {
        float f = (float3 - float2) % 6.2831855F;
        if (f < -3.1415927F) {
            f += 6.2831855F;
        }

        if (f >= 3.1415927F) {
            f -= 6.2831855F;
        }

        return float2 + float1 * f;
    }

    private float quadraticArmUpdate(float float1) {
        return -65.0F * float1 + float1 * float1;
    }

    public void copyPropertiesTo(TeacherModel<T> teacherModel) {
        super.copyPropertiesTo(teacherModel);
        teacherModel.leftArmPose = this.leftArmPose;
        teacherModel.rightArmPose = this.rightArmPose;
        teacherModel.crouching = this.crouching;
        teacherModel.head.copyFrom(this.head);
        teacherModel.hat.copyFrom(this.hat);
        teacherModel.body.copyFrom(this.body);
        teacherModel.rightArm.copyFrom(this.rightArm);
        teacherModel.leftArm.copyFrom(this.leftArm);
        teacherModel.rightLeg.copyFrom(this.rightLeg);
        teacherModel.leftLeg.copyFrom(this.leftLeg);
    }

    protected ModelPart getArm(HumanoidArm humanoidArm) {
        return humanoidArm == HumanoidArm.LEFT ? this.leftArm : this.rightArm;
    }

    public ModelPart getHead() {
        return this.head;
    }

    private HumanoidArm getAttackArm(T teacher) {
        HumanoidArm humanoidarm = teacher.getMainArm();
        return teacher.swingingArm == InteractionHand.MAIN_HAND ? humanoidarm : humanoidarm.getOpposite();
    }

    @OnlyIn(Dist.CLIENT)
    public static enum ArmPose implements IExtensibleEnum {
        EMPTY(false),
        ITEM(false),
        BLOCK(false),
        BOW_AND_ARROW(true),
        THROW_SPEAR(false),
        CROSSBOW_CHARGE(true),
        CROSSBOW_HOLD(true),
        SPYGLASS(false),
        TOOT_HORN(false);

        private final boolean twoHanded;
        @Nullable
        private final IArmPoseTransformerCustom forgeArmPose;

        private ArmPose(boolean bool) {
            this.twoHanded = bool;
            this.forgeArmPose = null;
        }

        public boolean isTwoHanded() {
            return this.twoHanded;
        }

        private ArmPose(boolean twoHanded, @Nonnull IArmPoseTransformerCustom forgeArmPose) {
            this.twoHanded = twoHanded;
            Preconditions.checkNotNull(forgeArmPose, "Cannot create new ArmPose with null transformer!");
            this.forgeArmPose = forgeArmPose;
        }

        public static ArmPose create(String name, boolean twoHanded, @Nonnull IArmPoseTransformerCustom forgeArmPose) {
            throw new IllegalStateException("Enum not extended");
        }

        public <T extends LivingEntity> void applyTransform(TeacherModel<T> model, T teacher, HumanoidArm arm) {
            if (this.forgeArmPose != null) {
                this.forgeArmPose.applyTransform(model, teacher, arm);
            }

        }
    }
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int int1, int int2, float float1, float float2, float float3, float float4) {
        if (this.young) {
            poseStack.pushPose();
            float $$9;
            if (this.scaleHead) {
                $$9 = 1.5F / this.babyHeadScale;
                poseStack.scale($$9, $$9, $$9);
            }

            poseStack.translate(0.0, (double)(this.babyYHeadOffset / 16.0F), (double)(this.babyZHeadOffset / 16.0F));
            this.headParts().forEach((p_102081_) -> {
                p_102081_.render(poseStack, vertexConsumer, int1, int2, float1, float2, float3, float4);
            });
            poseStack.popPose();
            poseStack.pushPose();
            $$9 = 1.0F / this.babyBodyScale;
            poseStack.scale($$9, $$9, $$9);
            poseStack.translate(0.0, (double)(this.bodyYOffset / 16.0F), 0.0);
            this.bodyParts().forEach((p_102071_) -> {
                p_102071_.render(poseStack, vertexConsumer, int1, int2, float1, float2, float3, float4);
            });
            poseStack.popPose();
        } else {
            this.headParts().forEach((p_102061_) -> {
                p_102061_.render(poseStack, vertexConsumer, int1, int2, float1, float2, float3, float4);
            });
            this.bodyParts().forEach((p_102051_) -> {
                p_102051_.render(poseStack, vertexConsumer, int1, int2, float1, float2, float3, float4);
            });
        }

    }
}