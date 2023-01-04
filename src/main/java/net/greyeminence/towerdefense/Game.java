package net.greyeminence.towerdefense;

import net.greyeminence.towerdefense.block.custom.StartBlock;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    public Player player;
    public static int health = 100;
    public static int new_health = 100;
    private Entity[] entities = new Entity[50];

    private ItemStack studentItemStack = ModItems.STUDENT_SPAWN_EGG.get().getDefaultInstance();


    public Game(Player player) {
        this.player = player;
    }

    private void waitASecond()
    {
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (java.lang.InterruptedException exception) {
            System.out.println("Something went wrong");
        }
    }

    private int spawn(int roundNumber)
    {
        switch (roundNumber) {
            case 1 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 1;
            }
            case 2 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 2;
            }
            case 3 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 3;
            }
            case 4 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 4;
            }
            case 5 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 5;
            }
            case 6 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 6;
            }
            case 7 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[6] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 7;
            }
            case 8 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[6] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[7] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 8;
            }
            case 9 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[6] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[7] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[8] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 9;
            }
            case 10 -> {
                entities[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[6] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[7] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[8] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                entities[9] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 10;
            }
            default -> {
                System.out.println("This round number isn't defined!");
                return -1;
            }
        }
    }

    public void run()
    {
        ServerPlayer test = (ServerPlayer) player;
        test.setGameMode(GameType.SURVIVAL);

        player.getInventory().clearContent();
        player.getInventory().add(Items.STONE_SWORD.getDefaultInstance());

        player.setHealth(20);
        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2147483647, 255));
        ((ServerPlayer) player).setExperienceLevels(health);

        //tps the player and sets his spawnpoints
        Vec3 startingPosition = new Vec3(0, 80, 0);
        ((ServerPlayer) player).setRespawnPosition(((ServerPlayer) player).getRespawnDimension(),
        new BlockPos(startingPosition), 0, true, false);
        player.teleportTo(0, 80, 0);

        //Spawn the zombies
        loops:
        for (int i = 1; i <= 10; i++)
        {
            player.sendSystemMessage(Component.literal("Round " + i + " starts in"));
            waitASecond();
            player.sendSystemMessage(Component.literal("3"));
            waitASecond();
            player.sendSystemMessage(Component.literal("2"));
            waitASecond();
            player.sendSystemMessage(Component.literal("1"));
            waitASecond();
            player.sendSystemMessage(Component.literal("GO!"));

            int entityAmount = spawn(i);

            boolean monstersAlive;
            do
            {
                if (health == 0) {
                    break loops;
                }

                monstersAlive = false;
                for (int j = 0; j < entityAmount; j++) {
                    if (entities[j].isAlive()) {
                        monstersAlive = true;
                        break;
                    }
                }
                waitASecond();
                health = new_health;
                ((ServerPlayer) player).setExperienceLevels(health);
            } while (monstersAlive);
        };

        if (health == 0)
        {
            player.sendSystemMessage(Component.literal("You lose!"));
        }
        else
        {
            player.sendSystemMessage(Component.literal("You win"));
        }
    }
}



