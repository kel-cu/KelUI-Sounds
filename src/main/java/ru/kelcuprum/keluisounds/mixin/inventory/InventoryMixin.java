package ru.kelcuprum.keluisounds.mixin.inventory;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.kelcuprum.keluisounds.KelUISounds;

@Mixin(value = Inventory.class)
public abstract class InventoryMixin {
    @Inject(method = "swapPaint", at=@At("HEAD"))
    public void swapPaint(double direction, CallbackInfo ci){
        if(!KelUISounds.config.getBoolean("INVENTORY.SWAP_PAINT", true)) return;
        KelUISounds.playSound(SoundEvents.NOTE_BLOCK_HAT.value(), KelUISounds.config.getNumber("INVENTORY.SWAP_PAINT.PITCH", 2.0F).floatValue(), KelUISounds.config.getNumber("INVENTORY.SWAP_PAINT.VOLUME", 0.35F).floatValue());
    }

    @Inject(method = "removeItem(II)Lnet/minecraft/world/item/ItemStack;", at=@At("HEAD"))
    public void removeFromSelected(int slot, int amount, CallbackInfoReturnable<ItemStack> cir){
        if(!KelUISounds.config.getBoolean("INVENTORY.DROP", true)) return;
        KelUISounds.playSound(SoundEvents.ARMOR_EQUIP_ELYTRA.value(), KelUISounds.config.getNumber("INVENTORY.DROP.PITCH", 2.0F).floatValue(), KelUISounds.config.getNumber("INVENTORY.DROP.VOLUME", 0.4F).floatValue());
    }
}
