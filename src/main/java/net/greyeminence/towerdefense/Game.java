package net.greyeminence.towerdefense;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    public Player player;
    public static int health = 100;
    public static int new_health = 100;

    public Game(Player player) {
        this.player = player;
    }

    public void run() {
        ServerPlayer test = (ServerPlayer) player;
        test.setGameMode(GameType.SURVIVAL);

        player.getInventory().clearContent();
        player.getInventory().add(Items.STONE_SWORD.getDefaultInstance());

        player.setHealth(20);
        player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 2147483647, 255));
        ((ServerPlayer) player).setExperienceLevels(health);

        Vec3 startingPosition = new Vec3(0, 80, 0);
        ((ServerPlayer) player).setRespawnPosition(((ServerPlayer) player).getRespawnDimension(),
        new BlockPos(startingPosition), 0, true, false);
        player.teleportTo(0, 80, 0);

        while (true) {
            if (new_health < health) {
                health = new_health;
                ((ServerPlayer) player).setExperienceLevels(health);
            }
            if (health == 0) {
                player.sendSystemMessage(Component.literal("You lose!"));
                break;
            }
        }

    }
}
/*         try {
            TimeUnit.SECONDS.sleep(30);
        }
        catch (java.lang.InterruptedException exception) {
            System.out.println("Something went wrong");
        }*/
