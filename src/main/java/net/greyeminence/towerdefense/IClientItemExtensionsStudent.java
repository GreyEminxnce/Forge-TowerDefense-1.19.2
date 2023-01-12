package net.greyeminence.towerdefense;

import net.greyeminence.towerdefense.client.models.StudentModel;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.client.model.Model;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public interface IClientItemExtensionsStudent extends IClientItemExtensions
{
    IClientItemExtensionsStudent DEFAULT = new IClientItemExtensionsStudent() {
    };
    static IClientItemExtensionsStudent of(ItemStack stack) {
        return of(stack.getItem());
    }

    static IClientItemExtensionsStudent of(Item item) {
        Object var2 = item.getRenderPropertiesInternal();
        IClientItemExtensionsStudent var10000;
        if (var2 instanceof IClientItemExtensionsStudent e) {
            var10000 = e;
        } else {
            var10000 = DEFAULT;
        }

        return var10000;
    }
    @Nullable
    default StudentModel.ArmPose getArmPose(Student student, InteractionHand hand, ItemStack itemStack) {
        return null;
    }

    default @NotNull Model getGenericArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, StudentModel<?> original) {
        StudentModel<?> replacement = this.getHumanoidArmorModel(livingEntity, itemStack, equipmentSlot, original);
        if (replacement != original) {
            ForgeHooksClientStudent.copyModelProperties(original, replacement);
            return replacement;
        } else {
            return original;
        }
    }

    default @NotNull StudentModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, StudentModel<?> original) {
        return original;
    }
}
