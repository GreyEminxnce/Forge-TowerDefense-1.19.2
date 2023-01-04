package net.greyeminence.towerdefense;

import net.greyeminence.towerdefense.block.custom.StartBlock;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.greyeminence.towerdefense.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    private static final int MAX_STUDENT_AMOUNT = 50;
    private static final int MAX_TEACHER_AMOUNT = 50;
    private static final int MAX_HEALTH = 100;
    public static Player player;
    public static int health = MAX_HEALTH;
    public static int new_health = MAX_HEALTH;
    private static Entity[] students = new Entity[MAX_STUDENT_AMOUNT];
    public static LinkedList<BlockPos> teacherPositions = new LinkedList<BlockPos>();

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
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 1;
            }
            case 2 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 2;
            }
            case 3 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 3;
            }
            case 4 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 4;
            }
            case 5 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 5;
            }
            case 6 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 6;
            }
            case 7 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[6] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 7;
            }
            case 8 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[6] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[7] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 8;
            }
            case 9 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[6] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[7] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[8] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 9;
            }
            case 10 -> {
                students[0] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[6] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[7] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[8] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(0, 80, 0),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[9] = ModEntityTypes.STUDENT.get().spawn((ServerLevel) StartBlock.serverlevel,
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
                    for (int j = 0; j < entityAmount; j++)
                    {
                        students[j].kill();
                    }
                    break loops;
                }

                monstersAlive = false;
                for (int j = 0; j < entityAmount; j++) {
                    if (students[j].isAlive()) {
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



