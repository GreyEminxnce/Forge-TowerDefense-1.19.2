package net.greyeminence.towerdefense;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

public class OnePerBlockSpawnEggItem extends ForgeSpawnEggItem {

    public OnePerBlockSpawnEggItem(Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor, Properties props)
    {
        super(type, backgroundColor, highlightColor, props);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext)
    {
        System.out.println("The useOn method was used\n!");
        Level level = useOnContext.getLevel();
        BlockPlaceContext blockPlaceContext = new BlockPlaceContext(useOnContext);
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        ItemStack itemInHand = useOnContext.getItemInHand();
        Vec3 vec3 = Vec3.atBottomCenterOf(blockPos);
        AABB aabb = EntityType.ARMOR_STAND.getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
        if (level.noCollision((Entity) null, aabb) && level.getEntities((Entity) null, aabb).isEmpty()) {
            return super.useOn(useOnContext);
        }
        return InteractionResult.FAIL;
    }
}