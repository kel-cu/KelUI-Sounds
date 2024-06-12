package ru.kelcuprum.keluisounds.mixin.ui.sound;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kelcuprum.keluisounds.KelUISounds;

import static net.minecraft.sounds.SoundEvents.MUSIC_MENU;

@Mixin(SoundManager.class)
public class SoundManagerMixin {
    @Inject(at = @At("HEAD"), method = "play", cancellable = true)
    private void injectPlayDirect(SoundInstance sound, CallbackInfo ci) {
        if(KelUISounds.music != sound && sound.getLocation().equals(MUSIC_MENU.value().getLocation())) KelUISounds.menuMusic = sound;
        if(!KelUISounds.config.getBoolean("MENU.MUSIC", false)) return;
        if (sound.getLocation().equals(MUSIC_MENU.value().getLocation())) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "playDelayed", cancellable = true)
    private void injectPlayDelayed(SoundInstance sound, int delay, CallbackInfo ci) {
        if(KelUISounds.music != sound && sound.getLocation().equals(MUSIC_MENU.value().getLocation())) KelUISounds.menuMusic = sound;
        if(!KelUISounds.config.getBoolean("MENU.MUSIC", false)) return;
        if (sound.getLocation().equals(MUSIC_MENU.value().getLocation())) ci.cancel();
    }
}
