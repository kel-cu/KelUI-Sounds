package ru.kelcuprum.keluisounds.mixin.ui.sound;

import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractSoundInstance.class)
public interface SoundInstanceAccessor {
    @Accessor("looping")
    void setLooping(boolean looping);
}
