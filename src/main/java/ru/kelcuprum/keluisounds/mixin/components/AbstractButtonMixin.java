package ru.kelcuprum.keluisounds.mixin.components;

import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

@Mixin(AbstractButton.class)
public abstract class AbstractButtonMixin extends AbstractWidget {

    public AbstractButtonMixin(int x, int y, int width, int height, Component message) {
        super(x, y, width, height, message);
    }

    @Unique
    boolean lastHovered = isHovered;
    @Unique
    boolean lastFocused = isFocused();

    public boolean isHovered() {
        if (lastHovered != isHovered && KelUISounds.config.getBoolean("BUTTON.HOVERED", false)) {
            lastHovered = isHovered;
            if (isHovered && isActive())
                KelUISounds.playSound(SoundStorage.getSound("button.hovered").getSound(), SoundStorage.getSound("button.hovered").getPitch(), SoundStorage.getSound("button.hovered").getVolume());
        }
        return isHovered;
    }

    public void setFocused(boolean focused) {
        if (lastFocused != focused && KelUISounds.config.getBoolean("BUTTON.FOCUSED", false)) {
            lastFocused = focused;
            if (focused && isActive())
                KelUISounds.playSound(SoundStorage.getSound("button.focused").getSound(), SoundStorage.getSound("button.focused").getPitch(), SoundStorage.getSound("button.focused").getVolume());
        }
        super.setFocused(focused);
    }
}
