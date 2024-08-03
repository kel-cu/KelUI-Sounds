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

public class ChatConfigs {
    public static Screen build(Screen parent){
        ConfigScreenBuilder builder = new ConfigScreenBuilder(parent, Component.translatable("kelui-sounds"));

        builder.addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.main"), (s) -> AlinLib.MINECRAFT.setScreen(MainConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.components"), (s) -> AlinLib.MINECRAFT.setScreen(ComponentsConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.chat"), (s) -> AlinLib.MINECRAFT.setScreen(ChatConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.inventory"), (s) -> AlinLib.MINECRAFT.setScreen(InventoryConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.ui"), (s) -> AlinLib.MINECRAFT.setScreen(UIConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.about"), (s) -> AlinLib.MINECRAFT.setScreen(AboutProject.build(parent))).build());

        builder.addWidget(new TextBox(Component.translatable("kelui-sounds.chat"), true));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.chat.typing_sound"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.chat.typing_sound"), true).setConfig(KelUISounds.config, "CHAT.TYPING_SOUND").build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(2.0F).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, "CHAT.TYPING_SOUND.PITCH").build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(1.6F).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, "CHAT.TYPING_SOUND.VOLUME").build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.chat.messages"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.chat.messages"), false).setConfig(KelUISounds.config, "CHAT.MESSAGES").build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("chat.messages").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("chat.messages").getConfigPitch()).build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("chat.messages").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("chat.messages").getConfigVolume()).build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.chat.init"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.chat.init"), true).setConfig(KelUISounds.config, "CHAT.INIT").build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("inventory.init").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("chat.init").getConfigPitch()).build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("inventory.init").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("chat.init").getConfigVolume()).build()));

        builder.addWidget(new CategoryBox(Component.translatable("kelui-sounds.config.category.chat.on_close"))
                .addValue(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.ui.chat.on_close"), true).setConfig(KelUISounds.config, "CHAT.ON_CLOSE").build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.pitch")).setDefaultValue(SoundStorage.getSound("chat.on_close").defaultPitch).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("chat.on_close").getConfigPitch()).build())
                .addValue(new SliderBuilder(Component.translatable("kelui-sounds.config.volume")).setDefaultValue(SoundStorage.getSound("chat.on_close").defaultVolume).setMin(0.1F).setMax(2.0F).setConfig(KelUISounds.config, SoundStorage.getSound("chat.on_close").getConfigVolume()).build()));
        return builder.build();
    }
}
