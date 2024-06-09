package ru.kelcuprum.keluisounds.mixin.components;

import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import ru.kelcuprum.keluisounds.KelUISounds;

@Mixin(AbstractButton.class)
public abstract class AbstractButtonMixin extends AbstractWidget {

    public AbstractButtonMixin(int x, int y, int width, int height, Component message) {
        super(x, y, width, height, message);
    }

    @Unique boolean lastHovered = isHovered;
    @Unique boolean lastFocused = isFocused();

    public boolean isHovered(){
        if(lastHovered != isHovered && KelUISounds.config.getBoolean("BUTTON.HOVERED", false)){
            lastHovered = isHovered;
            if(isHovered && isActive()) KelUISounds.playSound(SoundEvents.WOODEN_BUTTON_CLICK_OFF, KelUISounds.config.getNumber("BUTTON.HOVERED.PITCH", 2.0F).floatValue(), KelUISounds.config.getNumber("BUTTON.HOVERED.VOLUME", 1.6F).floatValue());
        }
        return isHovered;
    }

    public void setFocused(boolean focused){
        if(lastFocused != focused && KelUISounds.config.getBoolean("BUTTON.FOCUSED", false)){
            lastFocused = focused;
            if(focused && isActive()) KelUISounds.playSound(SoundEvents.WOODEN_BUTTON_CLICK_OFF, KelUISounds.config.getNumber("BUTTON.FOCUSED.PITCH", 2.0F).floatValue(), KelUISounds.config.getNumber("BUTTON.FOCUSED.VOLUME", 1.6F).floatValue());
        }
        super.setFocused(focused);
    }
}
