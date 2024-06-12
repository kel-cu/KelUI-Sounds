package ru.kelcuprum.keluisounds;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.apache.logging.log4j.Level;
import ru.kelcuprum.alinlib.AlinLib;
import ru.kelcuprum.alinlib.api.events.client.ClientTickEvents;
import ru.kelcuprum.alinlib.config.Config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.kelcuprum.keluisounds.mixin.ui.sound.SoundInstanceAccessor;

public class KelUISounds implements ClientModInitializer {

    public static final Logger LOG = LogManager.getLogger("Action Bar Info");

    public static void log(String message) {
        log(message, Level.INFO);
    }

    public static void log(String message, Level level) {
        LOG.log(level, "[" + LOG.getName() + "] " + message);
    }

    public static Config config = new Config("config/kelui-sounds.json");

    public static SoundInstance menuMusic = SimpleSoundInstance.forMusic(SoundEvent.createVariableRangeEvent(SoundInstance.EMPTY_SOUND));
    public static SoundInstance music;

    @Override
    public void onInitializeClient() {
        log("Hello, world!");
        ResourceLocation musicID = new ResourceLocation("kelui-sounds", "music");
        SoundEvent musicEvent = SoundEvent.createVariableRangeEvent(musicID);
        Registry.register(BuiltInRegistries.SOUND_EVENT, musicID, musicEvent);

        music = SimpleSoundInstance.forMusic(musicEvent);
        ((SoundInstanceAccessor) music).setLooping(true);

        ClientTickEvents.END_CLIENT_TICK.register((s) -> {
            if (!KelUISounds.config.getBoolean("MENU.MUSIC", false)) {
                if (AlinLib.MINECRAFT.getSoundManager().isActive(music))
                    AlinLib.MINECRAFT.getSoundManager().stop(music);
                return;
            }
            if (!(AlinLib.MINECRAFT.screen instanceof TitleScreen)) return;
            AlinLib.MINECRAFT.getSoundManager().stop(menuMusic);

            if (AlinLib.MINECRAFT.getSoundManager().isActive(music)) return;
            AlinLib.MINECRAFT.getSoundManager().play(music);
        });

        SoundStorage.registerSounds();
    }

    public static void playSound(SoundEvent sound, float pitch, float volume) {
        AlinLib.MINECRAFT.getSoundManager().play(SimpleSoundInstance.forUI(sound, pitch, volume));
    }
}
