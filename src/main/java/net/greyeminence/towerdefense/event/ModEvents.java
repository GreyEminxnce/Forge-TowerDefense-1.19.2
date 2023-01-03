package net.greyeminence.towerdefense.event;

import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents
{

    @Mod.EventBusSubscriber(modid = TowerDefense.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents
    {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.STUDENT.get(), Student.setAttributes());
        }
    }

}
