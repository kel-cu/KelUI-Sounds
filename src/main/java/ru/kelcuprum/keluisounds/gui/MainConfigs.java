package ru.kelcuprum.keluisounds.gui;

import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import ru.kelcuprum.alinlib.AlinLib;
import ru.kelcuprum.alinlib.gui.components.builder.button.ButtonBuilder;
import ru.kelcuprum.alinlib.gui.components.text.MessageBox;
import ru.kelcuprum.alinlib.gui.components.text.TextBox;
import ru.kelcuprum.alinlib.gui.screens.ConfigScreenBuilder;

public class MainConfigs {
    public static Screen build(Screen parent){
        ConfigScreenBuilder builder = new ConfigScreenBuilder(parent, Component.translatable("kelui-sounds"));

        builder.addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.main"), (s) -> AlinLib.MINECRAFT.setScreen(MainConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.components"), (s) -> AlinLib.MINECRAFT.setScreen(ComponentsConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.chat"), (s) -> AlinLib.MINECRAFT.setScreen(ChatConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.inventory"), (s) -> AlinLib.MINECRAFT.setScreen(InventoryConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.ui"), (s) -> AlinLib.MINECRAFT.setScreen(UIConfigs.build(parent))).build());

        builder.addWidget(new TextBox(Component.translatable("kelui-sounds.main"), true));

        builder.addWidget(new MessageBox(Component.translatable("kelui-sounds.description")));

        builder.addWidget(new MessageBox(Component.translatable("kelui-sounds.author"), (s) -> Util.getPlatform().openUri("https://kelcu.ru/git")));
        builder.addWidget(new MessageBox(Component.translatable("kelui-sounds.modrinth"), (s) -> Util.getPlatform().openUri("https://modrinth.com/mod/kelui-sounds")));
        builder.addWidget(new MessageBox(Component.translatable("kelui-sounds.source"), (s) -> Util.getPlatform().openUri("https://github.com/kel-cu/kelui-sounds")));
        return builder.build();
    }
}
