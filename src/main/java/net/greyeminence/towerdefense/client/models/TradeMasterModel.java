package net.greyeminence.towerdefense.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.greyeminence.towerdefense.TowerDefense;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.VillagerHeadModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.AbstractVillager;

public class TradeMasterModel<T extends Entity> extends HierarchicalModel<T> implements HeadedModel, VillagerHeadModel
{
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TowerDefense.MOD_ID, "trade_master"), "main");

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart hatRim;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    protected final ModelPart nose;

    public TradeMasterModel(ModelPart modelPart) {
        this.root = modelPart;
        this.head = modelPart.getChild("head");
        this.hat = this.head.getChild("hat");
        this.hatRim = this.hat.getChild("hat_rim");
        this.nose = this.head.getChild("nose");
        this.rightLeg = modelPart.getChild("right_leg");
        this.leftLeg = modelPart.getChild("left_leg");
    }

    public static MeshDefinition createBodyModel() {
        MeshDefinition $$0 = new MeshDefinition();
        PartDefinition $$1 = $$0.getRoot();
        float $$2 = 0.5F;
        PartDefinition $$3 = $$1.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F), PartPose.ZERO);
        PartDefinition $$4 = $$3.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.51F)), PartPose.ZERO);
        $$4.addOrReplaceChild("hat_rim", CubeListBuilder.create().texOffs(30, 47).addBox(-8.0F, -8.0F, -6.0F, 16.0F, 16.0F, 1.0F), PartPose.rotation(-1.5707964F, 0.0F, 0.0F));
        $$3.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
        PartDefinition $$5 = $$1.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F), PartPose.ZERO);
        $$5.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(0, 38).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 20.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.ZERO);
        $$1.addOrReplaceChild("arms", CubeListBuilder.create().texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, true).texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.75F, 0.0F, 0.0F));
        $$1.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-2.0F, 12.0F, 0.0F));
        $$1.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(2.0F, 12.0F, 0.0F));
        return $$0;
    }

    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(T trade_master, float f1, float f2, float f3, float f4, float f5) {
        boolean bool = false;
        if (trade_master instanceof AbstractVillager) {
            bool = ((AbstractVillager) trade_master).getUnhappyCounter() > 0;
        }

        this.head.yRot = f4 * 0.017453292F;
        this.head.xRot = f5 * 0.017453292F;
        if (bool) {
            this.head.zRot = 0.3F * Mth.sin(0.45F * f3);
            this.head.xRot = 0.4F;
        } else {
            this.head.zRot = 0.0F;
        }

        this.rightLeg.xRot = Mth.cos(f1 * 0.6662F) * 1.4F * f2 * 0.5F;
        this.leftLeg.xRot = Mth.cos(f1 * 0.6662F + 3.1415927F) * 1.4F * f2 * 0.5F;
        this.rightLeg.yRot = 0.0F;
        this.leftLeg.yRot = 0.0F;
    }

    public ModelPart getHead() {
        return this.head;
    }

    public void hatVisible(boolean isVisible) {
        this.head.visible = isVisible;
        this.hat.visible = isVisible;
        this.hatRim.visible = isVisible;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, float v, float v1, float v2, float v3) {
        root.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3);
        head.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3);
        rightLeg.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3);
        leftLeg.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3);
    }
}