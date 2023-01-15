package net.greyeminence.towerdefense.changed;

import net.greyeminence.towerdefense.Game;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.greyeminence.towerdefense.entity.custom.TradeMaster;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class OnePerBlockSpawnEggItem extends ForgeSpawnEggItem {

    private final RegistryObject type;

    public OnePerBlockSpawnEggItem(Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor, Properties props)
    {
        super(type, backgroundColor, highlightColor, props);
        this.type = (RegistryObject) type;
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext)
    {
        Level level = useOnContext.getLevel();
        BlockPlaceContext blockPlaceContext = new BlockPlaceContext(useOnContext);
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        ItemStack itemInHand = useOnContext.getItemInHand();
        Vec3 vec3 = Vec3.atBottomCenterOf(blockPos);
        AABB aabb = EntityType.ARMOR_STAND.getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
        if (level.noCollision((Entity) null, aabb) && level.getEntities((Entity) null, aabb).isEmpty())
        {
            if (!(level instanceof ServerLevel))
            {
                 return InteractionResult.SUCCESS;
             }
            else {
                ItemStack itemstack = useOnContext.getItemInHand();
                BlockPos blockpos = useOnContext.getClickedPos();
                Direction direction = useOnContext.getClickedFace();
                BlockState blockstate = level.getBlockState(blockpos);
                if (blockstate.is(Blocks.SPAWNER)) {
                    BlockEntity blockentity = level.getBlockEntity(blockpos);
                    if (blockentity instanceof SpawnerBlockEntity) {
                        BaseSpawner basespawner = ((SpawnerBlockEntity)blockentity).getSpawner();
                        EntityType<?> entitytype1 = this.getType(itemstack.getTag());
                        basespawner.setEntityId(entitytype1);
                        blockentity.setChanged();
                        level.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                        level.gameEvent(useOnContext.getPlayer(), GameEvent.BLOCK_CHANGE, blockpos);
                        itemstack.shrink(1);
                        return InteractionResult.CONSUME;
                    }
                }

                BlockPos blockpos1;
                if (blockstate.getCollisionShape(level, blockpos).isEmpty())
                {
                    blockpos1 = blockpos;
                }
                else
                {
                blockpos1 = blockpos.relative(direction);
                }

                EntityType<?> entitytype = this.getType(itemstack.getTag());
                Entity entity = entitytype.spawn((ServerLevel)level, itemstack, useOnContext.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP);
                if (entity != null)
                {
                    itemstack.shrink(1);
                    level.gameEvent(useOnContext.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
                }

                if (entity instanceof Teacher)
                {
                    Game.teachers[Game.teacherAmount] = (Teacher) entity;
                    Game.teacherAmount++;
                }

                else if (entity instanceof TradeMaster)
                {
                    Game.tradeMaster = (TradeMaster) entity;
                }

                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.FAIL;
    }
    @Override
    public Optional<Mob> spawnOffspringFromSpawnEgg(Player player, Mob mob, EntityType<? extends Mob> entityType, ServerLevel serverLevel, Vec3 vec3, ItemStack itemStack)
    {
        return Optional.empty();
    }
}