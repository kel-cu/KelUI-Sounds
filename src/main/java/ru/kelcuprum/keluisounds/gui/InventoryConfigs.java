package ru.kelcuprum.keluisounds.gui;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import ru.kelcuprum.alinlib.AlinLib;
import ru.kelcuprum.alinlib.gui.components.builder.button.ButtonBooleanBuilder;
import ru.kelcuprum.alinlib.gui.components.builder.button.ButtonBuilder;
import ru.kelcuprum.alinlib.gui.components.builder.slider.SliderFloatBuilder;
import ru.kelcuprum.alinlib.gui.components.text.CategoryBox;
import ru.kelcuprum.alinlib.gui.components.text.TextBox;
import ru.kelcuprum.alinlib.gui.screens.ConfigScreenBuilder;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

public class InventoryConfigs {
    public static Screen build(Screen parent){
        ConfigScreenBuilder builder = new ConfigScreenBuilder(parent, Component.translatable("kelui-sounds"));

        builder.addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.main"), (s) -> AlinLib.MINECRAFT.setScreen(MainConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.components"), (s) -> AlinLib.MINECRAFT.setScreen(ComponentsConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.chat"), (s) -> AlinLib.MINECRAFT.setScreen(ChatConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.inventory"), (s) -> AlinLib.MINECRAFT.setScreen(InventoryConfigs.build(parent))).build());

        builder.addWidget(new TextBox(Component.translatable("kelui-sounds.inventory"), true));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.inventory.slot_clicked"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.inventory.slot_clicked"), true).setConfig(KelUISounds.config, "INVENTORY.SLOT_CLICKED").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("inventory.slot_clicked").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, "INVENTORY.SLOT_CLICKED.PITCH").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("inventory.slot_clicked").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, "INVENTORY.SLOT_CLICKED.VOLUME").build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.inventory.swap_paint"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.inventory.swap_paint"), true).setConfig(KelUISounds.config, "INVENTORY.SWAP_PAINT").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("inventory.swap_paint").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, "INVENTORY.SWAP_PAINT.PITCH").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("inventory.swap_paint").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, "INVENTORY.SWAP_PAINT.VOLUME").build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.inventory.drop"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.inventory.drop"), true).setConfig(KelUISounds.config, "INVENTORY.DROP").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("inventory.drop").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, "INVENTORY.DROP.PITCH").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("inventory.drop").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, "INVENTORY.DROP.VOLUME").build()));
        return builder.build();
    }
}
