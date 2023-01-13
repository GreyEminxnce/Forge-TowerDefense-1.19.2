package net.greyeminence.towerdefense.changed;

import com.mojang.blaze3d.vertex.PoseStack;
import net.greyeminence.towerdefense.client.models.StudentModel;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;

public class ForgeHooksClientStudent extends ForgeHooksClient
{
    public static Model getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot slot, StudentModel<?> _default)
    {
        return IClientItemExtensionsStudent.of(itemStack).getGenericArmorModel(entityLiving, itemStack, slot, _default);
    }

    public static <T extends LivingEntity> void copyModelProperties(StudentModel<T> original, StudentModel<?> replacement) {
        original.copyPropertiesTo((StudentModel<T>) replacement);
        replacement.head.visible = original.head.visible;
        replacement.hat.visible = original.hat.visible;
        replacement.body.visible = original.body.visible;
        replacement.rightArm.visible = original.rightArm.visible;
        replacement.leftArm.visible = original.leftArm.visible;
        replacement.rightLeg.visible = original.rightLeg.visible;
        replacement.leftLeg.visible = original.leftLeg.visible;
    }
    public static boolean renderSpecificFirstPersonArm(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Student student, HumanoidArm arm) {
        return MinecraftForge.EVENT_BUS.post(new RenderStudentArmEvent(poseStack, multiBufferSource, packedLight, student, arm));
    }
}
