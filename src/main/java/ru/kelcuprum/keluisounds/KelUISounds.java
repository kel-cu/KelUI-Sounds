package ru.kelcuprum.keluisounds;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import org.apache.logging.log4j.Level;
import ru.kelcuprum.alinlib.AlinLib;
import ru.kelcuprum.alinlib.config.Config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KelUISounds implements ClientModInitializer {

    public static final Logger LOG = LogManager.getLogger("Action Bar Info");
    public static void log(String message) { log(message, Level.INFO);}
    public static void log(String message, Level level) { LOG.log(level, "[" + LOG.getName() + "] " + message); }

    public static Config config = new Config("config/kelui-sounds.json");

    @Override
    public void onInitializeClient() {
        log("Hello, world!");
        SoundStorage.registerSounds();
    }

    public static void playSound(SoundEvent sound, float pitch, float volume){
        AlinLib.MINECRAFT.getSoundManager().play(SimpleSoundInstance.forUI(sound, pitch, volume));
    }
}
