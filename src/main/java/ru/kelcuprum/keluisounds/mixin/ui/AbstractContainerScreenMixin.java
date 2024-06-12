package ru.kelcuprum.keluisounds.mixin.ui;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

@Mixin(AbstractContainerScreen.class)
public class AbstractContainerScreenMixin {
    @Unique boolean isPlayedInitSound = false;
    @Inject(method = "init", at=@At("RETURN"))
    public void added(CallbackInfo ci){
        if (!KelUISounds.config.getBoolean("INVENTORY.INIT", true)) return;
        if(!isPlayedInitSound){
            isPlayedInitSound = true;
            KelUISounds.playSound(SoundStorage.getSound("inventory.init").getSound(), SoundStorage.getSound("inventory.init").getPitch(), SoundStorage.getSound("inventory.init").getVolume());
        }
    }

    @Inject(method = "onClose", at = @At("RETURN"))
    public void onClose(CallbackInfo ci){
        if (!KelUISounds.config.getBoolean("INVENTORY.ON_CLOSE", true)) return;
        KelUISounds.playSound(SoundStorage.getSound("inventory.on_close").getSound(), SoundStorage.getSound("inventory.on_close").getPitch(), SoundStorage.getSound("inventory.on_close").getVolume());

    }

}
