package net.greyeminence.towerdefense;

import com.mojang.blaze3d.vertex.PoseStack;
import net.greyeminence.towerdefense.client.renderer.StudentRenderer;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraftforge.eventbus.api.Cancelable;
import org.jetbrains.annotations.ApiStatus.Internal;

public abstract class RenderStudentEvent extends StudentEvent {
    private final StudentRenderer renderer;
    private final float partialTick;
    private final PoseStack poseStack;
    private final MultiBufferSource multiBufferSource;
    private final int packedLight;

    @Internal
    protected RenderStudentEvent(Student student, StudentRenderer renderer, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        super(student);
        this.renderer = renderer;
        this.partialTick = partialTick;
        this.poseStack = poseStack;
        this.multiBufferSource = multiBufferSource;
        this.packedLight = packedLight;
    }

    public StudentRenderer getRenderer() {
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

    public static class Post extends RenderStudentEvent {
        @Internal
        public Post(Student student, StudentRenderer renderer, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
            super(student, renderer, partialTick, poseStack, multiBufferSource, packedLight);
        }
    }

    @Cancelable
    public static class Pre extends RenderStudentEvent {
        @Internal
        public Pre(Student student, StudentRenderer renderer, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
            super(student, renderer, partialTick, poseStack, multiBufferSource, packedLight);
        }
    }
}
