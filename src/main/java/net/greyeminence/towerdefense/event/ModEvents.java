package net.greyeminence.towerdefense.event;

import net.greyeminence.towerdefense.TowerDefense;
import net.greyeminence.towerdefense.entity.ModEntityTypes;
import net.greyeminence.towerdefense.entity.custom.Student;
import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents
{

    @Mod.EventBusSubscriber(modid = TowerDefense.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents
    {
        @SubscribeEvent
        public static void entityAttributeEventStudent(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.STUDENT.get(), Student.setAttributes());
        }
        @SubscribeEvent
        public static void entityAttributeEventTeacher(EntityAttributeCreationEvent event)
        {
            event.put(ModEntityTypes.TEACHER.get(), Teacher.setAttributes());
        }
    }

}
