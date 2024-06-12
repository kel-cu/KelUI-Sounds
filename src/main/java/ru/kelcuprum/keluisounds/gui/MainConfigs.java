package ru.kelcuprum.keluisounds.gui;

import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import ru.kelcuprum.alinlib.AlinLib;
import ru.kelcuprum.alinlib.gui.components.builder.button.ButtonBooleanBuilder;
import ru.kelcuprum.alinlib.gui.components.builder.button.ButtonBuilder;
import ru.kelcuprum.alinlib.gui.components.text.MessageBox;
import ru.kelcuprum.alinlib.gui.components.text.TextBox;
import ru.kelcuprum.alinlib.gui.screens.ConfigScreenBuilder;
import ru.kelcuprum.keluisounds.KelUISounds;

public class MainConfigs {
    public static boolean useOneShotSounds = KelUISounds.isOneShot();
    public static Screen build(Screen parent){
        ConfigScreenBuilder builder = new ConfigScreenBuilder(parent, Component.translatable("kelui-sounds"));

        builder.addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.main"), (s) -> AlinLib.MINECRAFT.setScreen(MainConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.components"), (s) -> AlinLib.MINECRAFT.setScreen(ComponentsConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.chat"), (s) -> AlinLib.MINECRAFT.setScreen(ChatConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.inventory"), (s) -> AlinLib.MINECRAFT.setScreen(InventoryConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.ui"), (s) -> AlinLib.MINECRAFT.setScreen(UIConfigs.build(parent))).build())
                .addPanelWidget(new ButtonBuilder(Component.translatable("kelui-sounds.about"), (s) -> AlinLib.MINECRAFT.setScreen(AboutProject.build(parent))).build());

        builder.addWidget(new TextBox(Component.translatable("kelui-sounds.main"), true));

        builder.addWidget(new ButtonBooleanBuilder(Component.translatable("kelui-sounds.config.oneshot_sounds"), false).setConfig(KelUISounds.config, "ONESHOT_SOUNDS").build())
                .setOnTick((s) -> {
                    if(useOneShotSounds != KelUISounds.isOneShot()){
                        useOneShotSounds = KelUISounds.isOneShot();
                        KelUISounds.menuMusic = useOneShotSounds ? KelUISounds.music : KelUISounds.music$OneShot;
                    }
                });
        return builder.build();
    }
}
