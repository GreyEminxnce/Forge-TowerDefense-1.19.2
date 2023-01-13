package net.greyeminence.towerdefense.changed;

import net.greyeminence.towerdefense.client.models.TeacherModel;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraft.client.model.Model;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public interface IClientItemExtensionsTeacher extends IClientItemExtensions
{
    IClientItemExtensionsTeacher DEFAULT = new IClientItemExtensionsTeacher() {
    };
    static IClientItemExtensionsTeacher of(ItemStack stack) {
        return of(stack.getItem());
    }

    static IClientItemExtensionsTeacher of(Item item) {
        Object var2 = item.getRenderPropertiesInternal();
        IClientItemExtensionsTeacher var10000;
        if (var2 instanceof IClientItemExtensionsTeacher e) {
            var10000 = e;
        } else {
            var10000 = DEFAULT;
        }

        return var10000;
    }
    @Nullable
    default TeacherModel.ArmPose getArmPose(Teacher teacher, InteractionHand hand, ItemStack itemStack) {
        return null;
    }

    default @NotNull Model getGenericArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, TeacherModel<?> original) {
        TeacherModel<?> replacement = this.getHumanoidArmorModel(livingEntity, itemStack, equipmentSlot, original);
        if (replacement != original) {
            ForgeHooksClientTeacher.copyModelProperties(original, replacement);
            return replacement;
        } else {
            return original;
        }
    }

    default @NotNull TeacherModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, TeacherModel<?> original) {
        return original;
    }
}
