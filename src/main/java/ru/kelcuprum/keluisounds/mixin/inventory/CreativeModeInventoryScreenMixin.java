package ru.kelcuprum.keluisounds.mixin.inventory;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kelcuprum.keluisounds.KelUISounds;

@Mixin(value = CreativeModeInventoryScreen.class)
public abstract class CreativeModeInventoryScreenMixin {

    @Inject(method = "slotClicked", at =@At("RETURN"))
    public void quickMoveStack(Slot slot, int slotId, int mouseButton, ClickType type, CallbackInfo ci){
        if(!KelUISounds.config.getBoolean("INVENTORY.SLOT_CLICKED", true)) return;
        if(slot != null && slot.isActive() && (type == ClickType.SWAP || type == ClickType.QUICK_MOVE)) KelUISounds.playSound(SoundEvents.ARMOR_EQUIP_ELYTRA.value(), KelUISounds.config.getNumber("INVENTORY.SLOT_CLICKED.PITCH", 2.0F).floatValue(), KelUISounds.config.getNumber("INVENTORY.SLOT_CLICKED.VOLUME", 0.35F).floatValue());
    }
}
