package net.greyeminence.towerdefense;

import com.mojang.blaze3d.vertex.PoseStack;
import net.greyeminence.towerdefense.client.models.StudentModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArrowLayerCustom<T extends LivingEntity, M extends StudentModel<T>> extends StuckInBodyLayerCustom<T, M> {
    private final EntityRenderDispatcher dispatcher;

    public ArrowLayerCustom(EntityRendererProvider.Context p_174465_, LivingEntityRendererCustom<T, M> p_174466_) {
        super(p_174466_);
        this.dispatcher = p_174465_.getEntityRenderDispatcher();
    }

    protected int numStuck(T p_116567_) {
        return p_116567_.getArrowCount();
    }

    protected void renderStuckItem(PoseStack p_116569_, MultiBufferSource p_116570_, int p_116571_, Entity p_116572_, float p_116573_, float p_116574_, float p_116575_, float p_116576_) {
        float $$8 = Mth.sqrt(p_116573_ * p_116573_ + p_116575_ * p_116575_);
        Arrow $$9 = new Arrow(p_116572_.level, p_116572_.getX(), p_116572_.getY(), p_116572_.getZ());
        $$9.setYRot((float)(Math.atan2((double)p_116573_, (double)p_116575_) * 57.2957763671875));
        $$9.setXRot((float)(Math.atan2((double)p_116574_, (double)$$8) * 57.2957763671875));
        $$9.yRotO = $$9.getYRot();
        $$9.xRotO = $$9.getXRot();
        this.dispatcher.render($$9, 0.0, 0.0, 0.0, 0.0F, p_116576_, p_116569_, p_116570_, p_116571_);
    }
}
