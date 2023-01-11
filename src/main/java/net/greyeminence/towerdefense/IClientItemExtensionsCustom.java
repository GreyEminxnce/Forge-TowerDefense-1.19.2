package net.greyeminence.towerdefense;

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

public interface IClientItemExtensionsCustom extends IClientItemExtensions
{
    IClientItemExtensionsCustom DEFAULT = new IClientItemExtensionsCustom() {
    };
    static IClientItemExtensionsCustom of(ItemStack stack) {
        return of(stack.getItem());
    }

    static IClientItemExtensionsCustom of(Item item) {
        Object var2 = item.getRenderPropertiesInternal();
        IClientItemExtensionsCustom var10000;
        if (var2 instanceof IClientItemExtensionsCustom e) {
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
            TowerDefenseHooksClient.copyModelProperties(original, replacement);
            return replacement;
        } else {
            return original;
        }
    }

    default @NotNull TeacherModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, TeacherModel<?> original) {
        return original;
    }
}
