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

public class UIConfigs {
    public static Screen build(Screen parent){
        ConfigScreenBuilder builder = new ConfigScreenBuilder(parent, Component.translatable("kelui-sounds"));

        builder.addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.main"), (s) -> AlinLib.MINECRAFT.setScreen(MainConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.components"), (s) -> AlinLib.MINECRAFT.setScreen(ComponentsConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.chat"), (s) -> AlinLib.MINECRAFT.setScreen(ChatConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.inventory"), (s) -> AlinLib.MINECRAFT.setScreen(InventoryConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.ui"), (s) -> AlinLib.MINECRAFT.setScreen(UIConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.about"), (s) -> AlinLib.MINECRAFT.setScreen(AboutProject.build(parent))).build());

        builder.addWidget(new TextBox(Component.translatable("kelui-sounds.ui"), true))
                .addWidget(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.menu.music"), false).setConfig(KelUISounds.config, "MENU.MUSIC").build());

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.inventory.init"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.inventory.init"), true).setConfig(KelUISounds.config, "INVENTORY.INIT").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("inventory.init").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("inventory.init").getConfigPitch()).build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("inventory.init").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("inventory.init").getConfigVolume()).build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.inventory.on_close"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.inventory.on_close"), true).setConfig(KelUISounds.config, "INVENTORY.ON_CLOSE").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("inventory.on_close").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("inventory.on_close").getConfigPitch()).build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("inventory.on_close").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("inventory.on_close").getConfigVolume()).build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.pause.init"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.pause.init"), true).setConfig(KelUISounds.config, "PAUSE.INIT").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("pause.init").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("pause.init").getConfigPitch()).build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("pause.init").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("pause.init").getConfigVolume()).build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.pause.on_close"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.pause.on_close"), true).setConfig(KelUISounds.config, "PAUSE.ON_CLOSE").build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("pause.on_close").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("pause.on_close").getConfigPitch()).build())
                .addValue(new SliderFloatBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("pause.on_close").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("pause.on_close").getConfigVolume()).build()));
        return builder.build();
    }
}
