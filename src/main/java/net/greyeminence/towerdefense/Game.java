package net.greyeminence.towerdefense;

import net.greyeminence.towerdefense.block.custom.StartBlock;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.greyeminence.towerdefense.entity.custom.TradeMaster;
import net.greyeminence.towerdefense.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    private static final int MAX_STUDENT_AMOUNT = 50;
    private static final int MAX_TEACHER_AMOUNT = 100;
    private static final int MAX_HEALTH = 100;
    public static Player player;
    public static Level level;
    public static int health = MAX_HEALTH;
    public static int new_health = MAX_HEALTH;
    private static Student[] students = new Student[MAX_STUDENT_AMOUNT];
    public static Teacher[] teachers = new Teacher[MAX_TEACHER_AMOUNT];
    public static TradeMaster tradeMaster;
    public static int teacherAmount = 0;
    public static LinkedList<BlockPos> teacherPositions = new LinkedList<BlockPos>();

    private ItemStack studentItemStack = ModItems.STUDENT_ELEMENTARY_SPAWN_EGG.get().getDefaultInstance();


    public Game(Player newPlayer, Level newLevel) {
        player = newPlayer;
        level = newLevel;
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
                students[0] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 1;
            }
            case 2 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 2;
            }
            case 3 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 3;
            }
            case 4 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 4;
            }
            case 5 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 5;
            }
            case 6 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 6;
            }
            case 7 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[6] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 7;
            }
            case 8 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = (Student) ModEntityTypes.STUDENT_ELEMENTARY.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[6] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[7] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 8;
            }
            case 9 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = (Student) ModEntityTypes.STUDENT_INTERMEDIATE.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[6] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[7] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[8] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 9;
            }
            case 10 -> {
                students[0] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[1] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[2] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[3] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[4] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[5] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[6] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[7] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[8] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                students[9] = (Student) ModEntityTypes.STUDENT_SENIOR.get().spawn((ServerLevel) StartBlock.serverlevel,
                        studentItemStack, player, new BlockPos(60.5, -36, -41.5),
                        MobSpawnType.SPAWN_EGG, false, false);
                return 10;
            }
            default -> {
                System.out.println("This round number isn't defined!");
                return -1;
            }
        }
    }

    private void cashOut(int roundNumber) {
        switch (roundNumber) {
            case 1:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 10));
                break;
            case 2:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 20));
                break;
            case 3:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 30));
                break;
            case 4:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 40));
                break;
            case 5:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 50));
                break;
            case 6:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 60));
                break;
            case 7:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 70));
                break;
            case 8:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 80));
                break;
            case 9:
                player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 90));
                break;
            case 10:
                break;
            default:
                System.out.println("This round number isn't defined!");
                break;
        }
    }

    public void run()
    {
        ServerPlayer test = (ServerPlayer) player;
        test.setGameMode(GameType.SURVIVAL);

        player.skipDropExperience();
        player.getInventory().clearContent();
        player.getInventory().add(Items.WOODEN_SWORD.getDefaultInstance());
        player.getInventory().add(ModItems.REMOVER.get().getDefaultInstance());
        player.getInventory().add(ModItems.TRADE_MASTER_SPAWN_EGG.get().getDefaultInstance());
        player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, 10));
        
        player.setHealth(20);
        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2147483647, 255));
        ((ServerPlayer) player).setExperienceLevels(health);

        //tps the player and sets his spawnpoints
        Vec3 startingPosition = new Vec3(152.5, -60, 4.5);
        ((ServerPlayer) player).setRespawnPosition(((ServerPlayer) player).getRespawnDimension(),
        new BlockPos(startingPosition), 0, true, false);
        player.teleportTo(76.5, -52, -33.5);

        //Spawn the zombies
        ((ServerPlayer) player).sendSystemMessage(Component.literal("The first round starts in 30 seconds"));
        try {
            TimeUnit.SECONDS.sleep(20);
        }
        catch (java.lang.InterruptedException exception) {
            System.out.println("Something went wrong");
        }        
        loops:
        for (int i = 1; i <= 10; i++)
        {
            player.sendSystemMessage(Component.literal("Round " + i + " starts in"));
            waitASecond();
            player.sendSystemMessage(Component.literal("10"));
            waitASecond();
            player.sendSystemMessage(Component.literal("9"));
            waitASecond();
            player.sendSystemMessage(Component.literal("8"));
            waitASecond();
            player.sendSystemMessage(Component.literal("7"));
            waitASecond();
            player.sendSystemMessage(Component.literal("6"));
            waitASecond();
            player.sendSystemMessage(Component.literal("5"));
            waitASecond();
            player.sendSystemMessage(Component.literal("4"));
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
                if (health <= 0 || !player.isAlive())
                {
                    break loops;
                }

                monstersAlive = false;
                for (int j = 0; j < entityAmount; j++) {
                    if (students[j].isAlive())
                    {
                        monstersAlive = true;
                    }
                    else if (!students[j].getHasDropped())
                    {
                        player.getInventory().add(new ItemStack(Items.GOLD_NUGGET, students[j].getCashDropAmount()));
                        students[j].setHasDropped(true);
                    }
                }
                waitASecond();
                health = new_health;
                ((ServerPlayer) player).setExperienceLevels(health);
            } while (monstersAlive);
            cashOut(i);
        };
        for (int j = 0; j < MAX_STUDENT_AMOUNT; j++)
        {
            if(students[j] != null && students[j].isAlive())
            students[j].kill();
        }
        for (int j = 0; j < teacherAmount; j++)
        {
            if (teachers[j] != null && teachers[j].isAlive())
            {
                teachers[j].kill();
            }
        }
        if (tradeMaster != null && tradeMaster.isAlive())
        {
            tradeMaster.kill();
        }
                    
        if (health == 0 || !player.isAlive())
        {
            player.sendSystemMessage(Component.literal("You lose!"));
        }
        else
        {
            player.sendSystemMessage(Component.literal("You win"));
        }
        player.teleportTo(152.5, -60, 4.5);

    int health = MAX_HEALTH;
    int new_health = MAX_HEALTH;
    Student[] students = new Student[MAX_STUDENT_AMOUNT];
    Teacher[] teachers = new Teacher[MAX_TEACHER_AMOUNT];
    TradeMaster tradeMaster;
    teacherAmount = 0;
    }
}

