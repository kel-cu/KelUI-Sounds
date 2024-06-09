package ru.kelcuprum.keluisounds.mixin.chat;

import net.minecraft.client.GuiMessageTag;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MessageSignature;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kelcuprum.keluisounds.KelUISounds;

@Mixin(ChatComponent.class)
public class ChatComponentMixin {
    @Inject(method = "addMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/chat/MessageSignature;Lnet/minecraft/client/GuiMessageTag;)V", at = @At("HEAD"))
    public void addMessage(Component chatComponent, MessageSignature headerSignature, GuiMessageTag tag, CallbackInfo ci) {
        if (KelUISounds.config.getBoolean("CHAT.MESSAGES", false))
            KelUISounds.playSound(SoundEvents.NOTE_BLOCK_HAT.value(), KelUISounds.config.getNumber("CHAT.MESSAGES.PITCH", 1.5F).floatValue(), KelUISounds.config.getNumber("CHAT.MESSAGES.VOLUME", 0.8F).floatValue());
    }

}
