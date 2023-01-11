package net.greyeminence.towerdefense;

import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.IArmPoseTransformer;

public interface IArmPoseTransformerCustom extends IArmPoseTransformer
{
    void applyTransform(EntityModel<?> var1, LivingEntity var2, HumanoidArm var3);
}
