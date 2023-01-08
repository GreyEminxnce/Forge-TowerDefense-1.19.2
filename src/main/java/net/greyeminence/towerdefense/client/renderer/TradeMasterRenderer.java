package net.greyeminence.towerdefense.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.client.models.TradeMasterModel;
import net.greyeminence.towerdefense.entity.custom.TradeMaster;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.VillagerProfessionLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TradeMasterRenderer extends MobRenderer<TradeMaster, TradeMasterModel<TradeMaster>> {
    private static final ResourceLocation VILLAGER_BASE_SKIN = new ResourceLocation("textures/entity/villager/villager.png");

    public TradeMasterRenderer(EntityRendererProvider.Context context) {
        super(context, new TradeMasterModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5F);
        this.addLayer(new CustomHeadLayer(this, context.getModelSet(), context.getItemInHandRenderer()));
        this.addLayer(new VillagerProfessionLayer(this, context.getResourceManager(), "villager"));
        this.addLayer(new CrossedArmsItemLayer(this, context.getItemInHandRenderer()));
    }

    public ResourceLocation getTextureLocation(TradeMaster tradeMaster) {
        return VILLAGER_BASE_SKIN;
    }

    protected void scale(TradeMaster tradeMaster, PoseStack poseStack, float v) {
        float $$3 = 0.9375F;
        if (tradeMaster.isBaby()) {
            $$3 *= 0.5F;
            this.shadowRadius = 0.25F;
        } else {
            this.shadowRadius = 0.5F;
        }

        poseStack.scale($$3, $$3, $$3);
    }
}

