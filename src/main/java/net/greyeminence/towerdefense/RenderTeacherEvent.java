package net.greyeminence.towerdefense;

import com.mojang.blaze3d.vertex.PoseStack;
import net.greyeminence.towerdefense.client.renderer.TeacherRenderer;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;
import org.jetbrains.annotations.ApiStatus.Internal;

public abstract class RenderTeacherEvent extends TeacherEvent {
    private final TeacherRenderer renderer;
    private final float partialTick;
    private final PoseStack poseStack;
    private final MultiBufferSource multiBufferSource;
    private final int packedLight;

    @Internal
    protected RenderTeacherEvent(Teacher teacher, TeacherRenderer renderer, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        super(teacher);
        this.renderer = renderer;
        this.partialTick = partialTick;
        this.poseStack = poseStack;
        this.multiBufferSource = multiBufferSource;
        this.packedLight = packedLight;
    }

    public TeacherRenderer getRenderer() {
        return this.renderer;
    }

    public float getPartialTick() {
        return this.partialTick;
    }

    public PoseStack getPoseStack() {
        return this.poseStack;
    }

    public MultiBufferSource getMultiBufferSource() {
        return this.multiBufferSource;
    }

    public int getPackedLight() {
        return this.packedLight;
    }

    public static class Post extends RenderTeacherEvent {
        @Internal
        public Post(Teacher teacher, TeacherRenderer renderer, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
            super(teacher, renderer, partialTick, poseStack, multiBufferSource, packedLight);
        }
    }

    @Cancelable
    public static class Pre extends RenderTeacherEvent {
        @Internal
        public Pre(Teacher teacher, TeacherRenderer renderer, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
            super(teacher, renderer, partialTick, poseStack, multiBufferSource, packedLight);
        }
    }
}
