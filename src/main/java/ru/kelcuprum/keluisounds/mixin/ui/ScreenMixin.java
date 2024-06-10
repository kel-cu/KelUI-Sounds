package ru.kelcuprum.keluisounds.mixin.ui;

import net.minecraft.client.gui.screens.GenericMessageScreen;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

@Mixin(Screen.class)
public class ScreenMixin {
    @Unique boolean isPlayedInitSound = false;
    @Inject(method = "added", at=@At("RETURN"))
    public void added(CallbackInfo ci){
        if (!KelUISounds.config.getBoolean("SCREEN.INIT", true)) return;
        if(!isPlayedInitSound){
            isPlayedInitSound = true;
//            net.minecraft.client.gui.screens.Screen
            KelUISounds.playSound(SoundStorage.getSound("screen.init").getSound(), SoundStorage.getSound("screen.init").getPitch(), SoundStorage.getSound("screen.init").getVolume());
        }
    }

    @Inject(method = "onClose", at = @At("RETURN"))
    public void onClose(CallbackInfo ci){
        if (!KelUISounds.config.getBoolean("SCREEN.ON_CLOSE", true)) return;
        KelUISounds.playSound(SoundStorage.getSound("screen.on_close").getSound(), SoundStorage.getSound("screen.on_close").getPitch(), SoundStorage.getSound("screen.on_close").getVolume());

    }

}
