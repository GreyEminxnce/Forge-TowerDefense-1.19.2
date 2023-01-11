package net.greyeminence.towerdefense;

import com.mojang.blaze3d.vertex.PoseStack;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.ApiStatus.Internal;

@Cancelable
public class RenderTeacherArmEvent extends Event {
    private final PoseStack poseStack;
    private final MultiBufferSource multiBufferSource;
    private final int packedLight;
    private final Teacher teacher;
    private final HumanoidArm arm;

    @Internal
    public RenderTeacherArmEvent(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Teacher teacher, HumanoidArm arm) {
        this.poseStack = poseStack;
        this.multiBufferSource = multiBufferSource;
        this.packedLight = packedLight;
        this.teacher = teacher;
        this.arm = arm;
    }

    public HumanoidArm getArm() {
        return this.arm;
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

    public Teacher getTeacher() {
        return this.teacher;
    }
}
