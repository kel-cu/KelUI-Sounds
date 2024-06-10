package ru.kelcuprum.keluisounds.api;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import ru.kelcuprum.keluisounds.KelUISounds;

public class SoundSettings {
    public String configType;
    public ResourceLocation soundByRL;

    public SoundEvent soundEvent;
    public Holder<SoundEvent> holderSoundEvent;
    public float defaultPitch;
    public float defaultVolume;

    public SoundSettings(SoundEvent soundEvent, float defaultPitch, float defaultVolume, String configType){
        this.soundEvent = soundEvent;
        this.defaultPitch = defaultPitch;
        this.defaultVolume = defaultVolume;
        this.configType = configType;
    }

    public SoundSettings(ResourceLocation soundByRL, float defaultPitch, float defaultVolume, String configType){
        this.soundByRL = soundByRL;
        this.defaultPitch = defaultPitch;
        this.defaultVolume = defaultVolume;
        this.configType = configType;
    }

    public SoundSettings( Holder<SoundEvent> holderSoundEvent, float defaultPitch, float defaultVolume, String configType){
        this.holderSoundEvent = holderSoundEvent;
        this.defaultPitch = defaultPitch;
        this.defaultVolume = defaultVolume;
        this.configType = configType;
    }

    public float getPitch(){
        return KelUISounds.config.getNumber(configType+".PITCH", defaultPitch).floatValue();
    }
    public float getVolume(){
        return KelUISounds.config.getNumber(configType+".VOLUME", defaultVolume).floatValue();
    }

    public SoundEvent getSound(){
        return soundByRL != null ? SoundEvent.createVariableRangeEvent(soundByRL) : soundEvent != null ? soundEvent : holderSoundEvent != null ? holderSoundEvent.value() : SoundEvents.PLAYER_DEATH;
    }
}
