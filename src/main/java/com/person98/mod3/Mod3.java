package com.person98.mod3;


import com.person98.mod3.handlers.PlayerActionSoundHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod3 implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("mod3");

	// Identifier and SoundEvent for your sound
	public static final Identifier PLAYER_IS_SNEAKING_SOUND_ID = new Identifier("mod3:player_is_sneaking");
	public static final Identifier PLAYER_IS_WALKING_SOUND_ID = new Identifier("mod3:player_is_walking");
	public static final Identifier PLAYER_IS_RUNNING_SOUND_ID = new Identifier("mod3:player_is_running");
	public static final Identifier PLAYER_IS_JUMPING_SOUND_ID = new Identifier("mod3:player_is_jumping");



	public static SoundEvent PLAYER_IS_SNEAKING_SOUND_EVENT = SoundEvent.of(PLAYER_IS_SNEAKING_SOUND_ID);
	public static SoundEvent PLAYER_IS_WALKING_SOUND_EVENT = SoundEvent.of(PLAYER_IS_WALKING_SOUND_ID);
	public static SoundEvent PLAYER_IS_RUNNING_SOUND_EVENT = SoundEvent.of(PLAYER_IS_RUNNING_SOUND_ID);
	public static SoundEvent PLAYER_IS_JUMPING_SOUND_EVENT = SoundEvent.of(PLAYER_IS_JUMPING_SOUND_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		// Register your sound event
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_IS_SNEAKING_SOUND_ID, PLAYER_IS_SNEAKING_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_IS_WALKING_SOUND_ID, PLAYER_IS_WALKING_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_IS_RUNNING_SOUND_ID, PLAYER_IS_RUNNING_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_IS_JUMPING_SOUND_ID, PLAYER_IS_JUMPING_SOUND_EVENT);

		PlayerActionSoundHandler.register();
		LOGGER.info("PlayerActionSoundHandler registered!");

		// Other initialization logic can go here
	}
}
