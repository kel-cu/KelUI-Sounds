package ru.kelcuprum.keluisounds.mixin.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow
    @Nullable
    public Screen screen;

    @Inject(method = "pauseGame", at = @At("TAIL"))
    public void pauseGame(boolean pauseOnly, CallbackInfo ci) {
        if (this.screen instanceof PauseScreen && !pauseOnly && KelUISounds.config.getBoolean("PAUSE.INIT", true))
            KelUISounds.playSound(SoundStorage.getSound("pause.init").getSound(), SoundStorage.getSound("pause.init").getPitch(), SoundStorage.getSound("pause.init").getVolume());
    }
}
