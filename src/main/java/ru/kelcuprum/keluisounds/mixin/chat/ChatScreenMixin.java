package ru.kelcuprum.keluisounds.mixin.chat;

import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.kelcuprum.keluisounds.KelUISounds;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @Unique
    private static boolean kelSounds$isCorrectKey(int keycode) {
        return switch (keycode) {
            case GLFW.GLFW_KEY_LEFT_SHIFT, GLFW.GLFW_KEY_RIGHT_SHIFT, GLFW.GLFW_KEY_LEFT_CONTROL, GLFW.GLFW_KEY_RIGHT_CONTROL, GLFW.GLFW_KEY_CAPS_LOCK, GLFW.GLFW_KEY_TAB, GLFW.GLFW_KEY_ENTER, GLFW.GLFW_KEY_INSERT, GLFW.GLFW_KEY_DELETE, GLFW.GLFW_KEY_END, GLFW.GLFW_KEY_HOME, GLFW.GLFW_KEY_PAGE_DOWN, GLFW.GLFW_KEY_PAGE_UP, GLFW.GLFW_KEY_PAUSE, GLFW.GLFW_KEY_SCROLL_LOCK, GLFW.GLFW_KEY_PRINT_SCREEN, GLFW.GLFW_KEY_ESCAPE, GLFW.GLFW_KEY_LEFT_ALT, GLFW.GLFW_KEY_RIGHT_ALT, GLFW.GLFW_KEY_NUM_LOCK, GLFW.GLFW_KEY_KP_ENTER, GLFW.GLFW_KEY_F1, GLFW.GLFW_KEY_F2, GLFW.GLFW_KEY_F3, GLFW.GLFW_KEY_F4, GLFW.GLFW_KEY_F5, GLFW.GLFW_KEY_F6, GLFW.GLFW_KEY_F7, GLFW.GLFW_KEY_F8, GLFW.GLFW_KEY_F9, GLFW.GLFW_KEY_F10, GLFW.GLFW_KEY_F11, GLFW.GLFW_KEY_F12 ->
                    false;
            default -> true;
        };
    }

    @Inject(method = "keyPressed", at=@At("HEAD"))
    public void keyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir){
        if(!KelUISounds.config.getBoolean("CHAT.TYPING_SOUND", true)) return;
        SoundEvent sound = Math.random() > 0.33 ? SoundEvents.WOODEN_BUTTON_CLICK_ON :  Math.random() > 0.66 ? SoundEvents.WOODEN_BUTTON_CLICK_OFF : SoundEvents.WOOD_PLACE;
        if(kelSounds$isCorrectKey(keyCode)) {
            KelUISounds.playSound(sound, KelUISounds.config.getNumber("CHAT.TYPING_SOUND.PITCH", 2.0F).floatValue(), KelUISounds.config.getNumber("CHAT.TYPING_SOUND.VOLUME", 1.6F).floatValue());
        }
    }
}
