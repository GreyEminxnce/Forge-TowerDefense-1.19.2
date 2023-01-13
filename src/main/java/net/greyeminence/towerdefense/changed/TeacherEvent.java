package net.greyeminence.towerdefense.changed;

import net.greyeminence.towerdefense.entity.custom.Teacher;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;

public class TeacherEvent extends LivingEvent {
    private final Teacher teacher;

    public TeacherEvent(Teacher teacher) {
        super(teacher);
        this.teacher = teacher;
    }

    public Teacher getEntity() {
        return this.teacher;
    }

    public static class TeacherChangedDimensionEvent extends TeacherEvent {
        private final ResourceKey<Level> fromDim;
        private final ResourceKey<Level> toDim;

        public TeacherChangedDimensionEvent(Teacher teacher, ResourceKey<Level> fromDim, ResourceKey<Level> toDim) {
            super(teacher);
            this.fromDim = fromDim;
            this.toDim = toDim;
        }

        public ResourceKey<Level> getFrom() {
            return this.fromDim;
        }

        public ResourceKey<Level> getTo() {
            return this.toDim;
        }
    }
}
