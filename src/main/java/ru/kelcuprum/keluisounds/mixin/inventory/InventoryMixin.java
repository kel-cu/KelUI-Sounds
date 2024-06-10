package ru.kelcuprum.keluisounds.mixin.inventory;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

@Mixin(value = Inventory.class)
public abstract class InventoryMixin {
    @Inject(method = "swapPaint", at = @At("HEAD"))
    public void swapPaint(double direction, CallbackInfo ci) {
        if (!KelUISounds.config.getBoolean("INVENTORY.SWAP_PAINT", true)) return;
        KelUISounds.playSound(SoundStorage.getSound("inventory.swap_paint").getSound(), SoundStorage.getSound("inventory.swap_paint").getPitch(), SoundStorage.getSound("inventory.swap_paint").getVolume());
    }

    @Inject(method = "removeItem(II)Lnet/minecraft/world/item/ItemStack;", at = @At("HEAD"))
    public void removeFromSelected(int slot, int amount, CallbackInfoReturnable<ItemStack> cir) {
        if (!KelUISounds.config.getBoolean("INVENTORY.DROP", true)) return;
        KelUISounds.playSound(SoundStorage.getSound("inventory.drop").getSound(), SoundStorage.getSound("inventory.drop").getPitch(), SoundStorage.getSound("inventory.drop").getVolume());
    }
}
