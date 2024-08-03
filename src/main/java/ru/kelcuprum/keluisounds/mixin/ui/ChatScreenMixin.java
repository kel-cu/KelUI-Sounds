package ru.kelcuprum.keluisounds.mixin.ui;

import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

@Mixin(ChatScreen.class)
public class ChatScreenMixin extends Screen {

    protected ChatScreenMixin(Component title) {
        super(title);
    }

    @Unique
    boolean isPlayedInitSound = false;
    @Inject(method = "init", at = @At("RETURN"))
    public void added(CallbackInfo ci){
        if (!KelUISounds.config.getBoolean("CHAT.INIT", true)) return;
        if(!isPlayedInitSound){
            isPlayedInitSound = true;
            KelUISounds.playSound(SoundStorage.getSound("chat.init").getSound(), SoundStorage.getSound("chat.init").getPitch(), SoundStorage.getSound("chat.init").getVolume());
        }
    }
    @Unique
    public void onClose() {
        if (KelUISounds.config.getBoolean("CHAT.ON_CLOSE", true))
            KelUISounds.playSound(SoundStorage.getSound("chat.on_close").getSound(), SoundStorage.getSound("chat.on_close").getPitch(), SoundStorage.getSound("chat.on_close").getVolume());
        super.onClose();
    }
}
