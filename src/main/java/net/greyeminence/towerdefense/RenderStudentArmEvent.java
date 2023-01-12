package net.greyeminence.towerdefense;

import com.mojang.blaze3d.vertex.PoseStack;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;
import org.jetbrains.annotations.ApiStatus.Internal;

@Cancelable
public class RenderStudentArmEvent extends Event {
    private final PoseStack poseStack;
    private final MultiBufferSource multiBufferSource;
    private final int packedLight;
    private final Student student;
    private final HumanoidArm arm;

    @Internal
    public RenderStudentArmEvent(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Student student, HumanoidArm arm) {
        this.poseStack = poseStack;
        this.multiBufferSource = multiBufferSource;
        this.packedLight = packedLight;
        this.student = student;
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

    public Student getStudent() {
        return this.student;
    }
}
