package ru.kelcuprum.keluisounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import ru.kelcuprum.alinlib.gui.GuiUtils;
import ru.kelcuprum.keluisounds.api.SoundSettings;

import java.util.HashMap;
import java.util.Map;

public class SoundStorage {
    public static Map<String, SoundSettings> defaultSounds = new HashMap<>();
    public static Map<String, SoundSettings> oneShotSounds = new HashMap<>();
    public static SoundSettings safeSoundSettings = new SoundSettings(SoundEvents.PLAYER_DEATH, 1.0F, 1.0F, "PLAYER_DEATH");

    public static void registerSounds(){
        registerSounds$default();
        registerSounds$oneShot();
    }
    public static void registerSounds$default(){
        //
        defaultSounds.put("button.hovered", new SoundSettings(SoundEvents.WOODEN_BUTTON_CLICK_OFF, 2.0F, 1.6F, "BUTTON.HOVERED"));
        defaultSounds.put("button.focused", new SoundSettings(SoundEvents.WOODEN_BUTTON_CLICK_OFF, 2.0F, 1.6F, "BUTTON.FOCUSED"));
        //
        defaultSounds.put("chat.messages", new SoundSettings(SoundEvents.NOTE_BLOCK_HAT, 1.5F, 0.8F, "CHAT.MESSAGES"));
        //
        defaultSounds.put("inventory.slot_clicked", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 2.0F, 0.35F, "INVENTORY.SLOT_CLICKED"));
        defaultSounds.put("inventory.swap_paint", new SoundSettings(SoundEvents.NOTE_BLOCK_HAT, 2.0F, 0.35F, "INVENTORY_SWAP_PAINT"));
        defaultSounds.put("inventory.drop", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 2.0F, 0.4F, "INVENTORY.DROP"));
        //
        defaultSounds.put("inventory.init", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 2.0F, 0.4F, "INVENTORY.INIT"));
        defaultSounds.put("inventory.on_close", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 0.5F, 0.4F, "INVENTORY.ON_CLOSE"));
        //
        defaultSounds.put("pause.init", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 2.0F, 0.4F, "PAUSE.INIT"));
        defaultSounds.put("pause.on_close", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 0.5F, 0.4F, "PAUSE.ON_CLOSE"));
        //
        defaultSounds.put("chat.init", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 2.0F, 0.4F, "CHAT.INIT"));
        defaultSounds.put("chat.on_close", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 0.5F, 0.4F, "CHAT.ON_CLOSE"));
    }
    public static void registerSounds$oneShot(){
        ResourceLocation onClose = GuiUtils.getResourceLocation("kelui-sounds", "oneshot_menu_cancel");
        ResourceLocation init = GuiUtils.getResourceLocation("kelui-sounds", "oneshot_menu_decision");
        ResourceLocation hovered = GuiUtils.getResourceLocation("kelui-sounds", KelUISounds.isAprilFool() ? "oneshot_nikomeow" : "oneshot_menu_cursor");
        ResourceLocation focused = GuiUtils.getResourceLocation("kelui-sounds", KelUISounds.isAprilFool() ? "oneshot_cat_1" : "oneshot_title_cursor");
        oneShotSounds.put("button.hovered", new SoundSettings(hovered, 1.0F, 0.25F, "ONESHOT.BUTTON.HOVERED"));
        oneShotSounds.put("button.focused", new SoundSettings(focused, 1.0F, 0.25F, "ONESHOT.BUTTON.FOCUSED"));
        //
//
        //
        if(KelUISounds.isAprilFool()) {
            oneShotSounds.put("chat.messages", new SoundSettings(hovered, 1.5F, 0.8F, "ONESHOT.CHAT.MESSAGES"));
            oneShotSounds.put("inventory.slot_clicked", new SoundSettings(GuiUtils.getResourceLocation("kelui-sounds", "oneshot_cat_3"), 2.0F, 0.35F, "ONESHOT.INVENTORY.SLOT_CLICKED"));
            oneShotSounds.put("inventory.swap_paint", new SoundSettings(hovered, 2.0F, 0.35F, "ONESHOT.INVENTORY_SWAP_PAINT"));
//        oneShotSounds.put("inventory.drop", new SoundSettings(SoundEvents.ARMOR_EQUIP_ELYTRA, 2.0F, 0.4F, "ONESHOT.INVENTORY.DROP"));
        }
        //
        oneShotSounds.put("inventory.init", new SoundSettings(init, 1.0F, 0.4F, "ONESHOT.INVENTORY.INIT"));
        oneShotSounds.put("inventory.on_close", new SoundSettings(onClose, 1.0F, 0.4F, "ONESHOT.INVENTORY.ON_CLOSE"));
        //
        oneShotSounds.put("pause.init", new SoundSettings(init, 1.0F, 0.4F, "ONESHOT.PAUSE.INIT"));
        oneShotSounds.put("pause.on_close", new SoundSettings(onClose, 1.0F, 0.4F, "ONESHOT.PAUSE.ON_CLOSE"));
//        KelUISounds.log("OneShot soon...");
        oneShotSounds.put("chat.init", new SoundSettings(init, 2.0F, 0.4F, "ONESHOT.CHAT.INIT"));
        oneShotSounds.put("chat.on_close", new SoundSettings(onClose, 0.5F, 0.4F, "ONESHOT.CHAT.ON_CLOSE"));
    }

    public static SoundSettings getSound(String id){
        if(KelUISounds.isOneShot()) return oneShotSounds.getOrDefault(id, defaultSounds.getOrDefault(id, safeSoundSettings));
        else return defaultSounds.getOrDefault(id, safeSoundSettings);
    }
}
