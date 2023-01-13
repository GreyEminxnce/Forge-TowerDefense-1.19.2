package net.greyeminence.towerdefense.changed;

import net.greyeminence.towerdefense.entity.custom.Student;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;

public class StudentEvent extends LivingEvent {
    private final Student student;

    public StudentEvent(Student student) {
        super(student);
        this.student = student;
    }

    public Student getEntity() {
        return this.student;
    }

    public static class StudentChangedDimensionEvent extends StudentEvent {
        private final ResourceKey<Level> fromDim;
        private final ResourceKey<Level> toDim;

        public StudentChangedDimensionEvent(Student student, ResourceKey<Level> fromDim, ResourceKey<Level> toDim) {
            super(student);
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
