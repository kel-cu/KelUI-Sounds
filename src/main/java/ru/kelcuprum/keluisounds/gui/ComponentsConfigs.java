package ru.kelcuprum.keluisounds.gui;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import ru.kelcuprum.alinlib.AlinLib;
import ru.kelcuprum.alinlib.gui.components.builder.button.ButtonBooleanBuilder;
import ru.kelcuprum.alinlib.gui.components.builder.button.ButtonBuilder;
import ru.kelcuprum.alinlib.gui.components.builder.slider.SliderBuilder;
import ru.kelcuprum.alinlib.gui.components.text.CategoryBox;
import ru.kelcuprum.alinlib.gui.components.text.TextBox;
import ru.kelcuprum.alinlib.gui.screens.ConfigScreenBuilder;
import ru.kelcuprum.keluisounds.KelUISounds;
import ru.kelcuprum.keluisounds.SoundStorage;

public class ComponentsConfigs {
    public static Screen build(Screen parent) {
        ConfigScreenBuilder builder = new ConfigScreenBuilder(parent, Component.translatable("kelui-sounds"));

        builder.addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.main"), (s) -> AlinLib.MINECRAFT.setScreen(MainConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.components"), (s) -> AlinLib.MINECRAFT.setScreen(ComponentsConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.chat"), (s) -> AlinLib.MINECRAFT.setScreen(ChatConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.inventory"), (s) -> AlinLib.MINECRAFT.setScreen(InventoryConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.ui"), (s) -> AlinLib.MINECRAFT.setScreen(UIConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.about"), (s) -> AlinLib.MINECRAFT.setScreen(AboutProject.build(parent))).build());

        builder.addWidget(new TextBox(Component.translatable("kelui-sounds.components"), true));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.button.hovered"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.button.hovered"), false).setConfig(KelUISounds.config, "BUTTON.HOVERED").build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("button.hovered").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("button.hovered").getConfigPitch()).build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("button.hovered").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("button.hovered").getConfigVolume()).build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.button.focused"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.button.focused"), false).setConfig(KelUISounds.config, "BUTTON.FOCUSED").build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("button.focused").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("button.focused").getConfigPitch()).build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("button.focused").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("button.focused").getConfigVolume()).build()));
        return builder.build();
    }
}
