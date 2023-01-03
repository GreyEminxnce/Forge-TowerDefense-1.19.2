package net.greyeminence.towerdefense;

import com.mojang.logging.LogUtils;
import net.greyeminence.towerdefense.block.ModBlocks;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TowerDefense.MOD_ID)
public class TowerDefense
{
    public static final String MOD_ID = "towerdefense";
    private static final Logger LOGGER = LogUtils.getLogger();
   
    public TowerDefense()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntityTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}

//Methode, die das Spiel steuert
//Setup
//Alle Spieler in Gamemode 0 - keine Lösung gefunden - :) doch, Casting regelt
//Alle Spieler müssen an einen Ort teleportiert werden - done
//Alle Spieler brauchen ein leeres Inventar - done
//Alle Spieler bekommen etwas ins Inv - done
//Alle Spieler werden gefullhealt - done
//Kein Hunger - done
//Leben werden aufgefüllt - done
//Runden
//Schleife für die Runden
//Mobs werden gespawnt - done :D
//Mobs folgen der Strecke
//Lebenscheck/-update - done
//Check, ob alle Monster tot sind
//Ende der Runde
//nächste Runde startet in x Sekunden

//Spielende
//Gewonnen, wenn alle Runden überlebt
//sonst Verloren
//Alle Monster killen
//Alle Tower entfernen