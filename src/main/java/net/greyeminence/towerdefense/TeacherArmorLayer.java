package net.greyeminence.towerdefense;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

import net.greyeminence.towerdefense.client.models.TeacherModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;

@OnlyIn(Dist.CLIENT)
public class TeacherArmorLayer<T extends LivingEntity, M extends TeacherModel<T>, A extends TeacherModel<T>> extends RenderLayer<T, M> {
    private static final Map<String, ResourceLocation> ARMOR_LOCATION_CACHE = Maps.newHashMap();
    private final A innerModel;
    private final A outerModel;

    public TeacherArmorLayer(RenderLayerParent<T, M> renderLayerParent, A innerModel, A outerModel) {
        super(renderLayerParent);
        this.innerModel = innerModel;
        this.outerModel = outerModel;
    }

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int int1, T t, float float1, float float2, float float3, float float4, float float5, float float6) {
        this.renderArmorPiece(poseStack, multiBufferSource, t, EquipmentSlot.CHEST, int1, this.getArmorModel(EquipmentSlot.CHEST));
        this.renderArmorPiece(poseStack, multiBufferSource, t, EquipmentSlot.LEGS, int1, this.getArmorModel(EquipmentSlot.LEGS));
        this.renderArmorPiece(poseStack, multiBufferSource, t, EquipmentSlot.FEET, int1, this.getArmorModel(EquipmentSlot.FEET));
        this.renderArmorPiece(poseStack, multiBufferSource, t, EquipmentSlot.HEAD, int1, this.getArmorModel(EquipmentSlot.HEAD));
    }

    private void renderArmorPiece(PoseStack poseStack, MultiBufferSource multiBufferSource, T t, EquipmentSlot equipmentSlot, int int1, A a) {
        ItemStack itemstack = t.getItemBySlot(equipmentSlot);
        if (itemstack.getItem() instanceof ArmorItem) {
            ArmorItem armoritem = (ArmorItem)itemstack.getItem();
            if (armoritem.getSlot() == equipmentSlot) {
                ((TeacherModel)this.getParentModel()).copyPropertiesTo(a);
                this.setPartVisibility(a, equipmentSlot);
                Model model = this.getArmorModelHook(t, itemstack, equipmentSlot, a);
                this.usesInnerModel(equipmentSlot);
                boolean flag1 = itemstack.hasFoil();
                if (armoritem instanceof DyeableLeatherItem) {
                    int i = ((DyeableLeatherItem)armoritem).getColor(itemstack);
                    float f = (float)(i >> 16 & 255) / 255.0F;
                    float f1 = (float)(i >> 8 & 255) / 255.0F;
                    float f2 = (float)(i & 255) / 255.0F;
                    this.renderModel(poseStack, multiBufferSource, int1, flag1, model, f, f1, f2, this.getArmorResource(t, itemstack, equipmentSlot, (String)null));
                    this.renderModel(poseStack, multiBufferSource, int1, flag1, model, 1.0F, 1.0F, 1.0F, this.getArmorResource(t, itemstack, equipmentSlot, "overlay"));
                } else {
                    this.renderModel(poseStack, multiBufferSource, int1, flag1, model, 1.0F, 1.0F, 1.0F, this.getArmorResource(t, itemstack, equipmentSlot, (String)null));
                }
            }
        }

    }

    protected void setPartVisibility(A model, EquipmentSlot equipmentSlot) {
        model.setAllVisible(false);
        switch (equipmentSlot) {
            case HEAD:
                model.head.visible = true;
                model.hat.visible = true;
                break;
            case CHEST:
                model.body.visible = true;
                model.rightArm.visible = true;
                model.leftArm.visible = true;
                break;
            case LEGS:
                model.body.visible = true;
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
                break;
            case FEET:
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
        }

    }

    private void renderModel(PoseStack p_117107_, MultiBufferSource p_117108_, int p_117109_, ArmorItem p_117110_, boolean p_117111_, A p_117112_, boolean p_117113_, float p_117114_, float p_117115_, float p_117116_, @Nullable String p_117117_) {
        this.renderModel(p_117107_, p_117108_, p_117109_, p_117111_, p_117112_, p_117114_, p_117115_, p_117116_, this.getArmorLocation(p_117110_, p_117113_, p_117117_));
    }

    private void renderModel(PoseStack p_117107_, MultiBufferSource p_117108_, int p_117109_, boolean p_117111_, Model p_117112_, float p_117114_, float p_117115_, float p_117116_, ResourceLocation armorResource) {
        VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(p_117108_, RenderType.armorCutoutNoCull(armorResource), false, p_117111_);
        p_117112_.renderToBuffer(p_117107_, vertexconsumer, p_117109_, OverlayTexture.NO_OVERLAY, p_117114_, p_117115_, p_117116_, 1.0F);
    }

    private A getArmorModel(EquipmentSlot p_117079_) {
        return this.usesInnerModel(p_117079_) ? this.innerModel : this.outerModel;
    }

    private boolean usesInnerModel(EquipmentSlot p_117129_) {
        return p_117129_ == EquipmentSlot.LEGS;
    }

    /** @deprecated */
    @Deprecated
    private ResourceLocation getArmorLocation(ArmorItem p_117081_, boolean p_117082_, @Nullable String p_117083_) {
        String var10000 = p_117081_.getMaterial().getName();
        String s = "textures/models/armor/" + var10000 + "_layer_" + (p_117082_ ? 2 : 1) + (p_117083_ == null ? "" : "_" + p_117083_) + ".png";
        return (ResourceLocation)ARMOR_LOCATION_CACHE.computeIfAbsent(s, ResourceLocation::new);
    }

    protected Model getArmorModelHook(T entity, ItemStack itemStack, EquipmentSlot slot, A model) {
        return TowerDefenseHooksClient.getArmorModel(entity, itemStack, slot, model);
    }

    public ResourceLocation getArmorResource(Entity entity, ItemStack stack, EquipmentSlot slot, @Nullable String type) {
        ArmorItem item = (ArmorItem)stack.getItem();
        String texture = item.getMaterial().getName();
        String domain = "minecraft";
        int idx = texture.indexOf(58);
        if (idx != -1) {
            domain = texture.substring(0, idx);
            texture = texture.substring(idx + 1);
        }

        String s1 = String.format(Locale.ROOT, "%s:textures/models/armor/%s_layer_%d%s.png", domain, texture, this.usesInnerModel(slot) ? 2 : 1, type == null ? "" : String.format(Locale.ROOT, "_%s", type));
        s1 = ForgeHooksClient.getArmorTexture(entity, stack, s1, slot, type);
        ResourceLocation resourcelocation = (ResourceLocation)ARMOR_LOCATION_CACHE.get(s1);
        if (resourcelocation == null) {
            resourcelocation = new ResourceLocation(s1);
            ARMOR_LOCATION_CACHE.put(s1, resourcelocation);
        }

        return resourcelocation;
    }
}
