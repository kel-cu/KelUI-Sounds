package ru.kelcuprum.keluisounds.mixin.ui;

import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

@Mixin(PauseScreen.class)
public class PauseScreenMixin extends Screen {

    protected PauseScreenMixin(Component title) {
        super(title);
    }

    @Unique
    public void onClose() {
        if (KelUISounds.config.getBoolean("PAUSE.ON_CLOSE", true))
            KelUISounds.playSound(SoundStorage.getSound("pause.on_close").getSound(), SoundStorage.getSound("pause.on_close").getPitch(), SoundStorage.getSound("pause.on_close").getVolume());
        super.onClose();
    }
}
