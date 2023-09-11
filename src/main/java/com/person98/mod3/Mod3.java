package com.person98.mod3;


import com.person98.mod3.handlers.*;
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
	public static final Identifier PLAYER_IS_JUMPING_SOUND_ID = new Identifier("mod3:player_is_jumping");
	public static final Identifier PLAYER_BREAK_BLOCK_SOUND_ID = new Identifier("mod3:player_broke_block");
	public static final Identifier PLAYER_PLACE_BLOCK_SOUND_ID = new Identifier("mod3:player_placed_block");
	public static final Identifier ITEM_CRAFT_SOUND_ID = new Identifier("mod3:item_craft");
	public static final Identifier PLAYER_KILL_ENTITY_SOUND_ID = new Identifier("mod3:player_kill_entity");
	public static final Identifier PLAYER_HIT_ENTITY_SOUND_ID = new Identifier("mod3:player_hit_entity");
	public static final Identifier PLAYER_DEATH_SOUND_ID = new Identifier("mod3:player_death");
	public static final Identifier PLAYER_FARTED_EWW_SOUND_ID = new Identifier("mod3:player_farted_eww");
	public static final Identifier PLAYER_IS_SUS_SOUND_ID = new Identifier("mod3:player_is_sus");
	public static final Identifier PLAYER_IS_CUTE_SOUND_ID = new Identifier("mod3:player_is_cute");
	public static final Identifier SUBSCRIBE_TO_COREYTONGE_SOUND_ID = new Identifier("mod3:subscribe_to_coreytonge");
	public static final Identifier FITNESSGRAM_PACER_TEST_SOUND_ID = new Identifier("mod3:fitnessgram_pacer_test");


	public static SoundEvent PLAYER_IS_SNEAKING_SOUND_EVENT = SoundEvent.of(PLAYER_IS_SNEAKING_SOUND_ID);
	public static SoundEvent PLAYER_IS_JUMPING_SOUND_EVENT = SoundEvent.of(PLAYER_IS_JUMPING_SOUND_ID);
	public static SoundEvent PLAYER_BREAK_BLOCK_SOUND_EVENT = SoundEvent.of(PLAYER_BREAK_BLOCK_SOUND_ID);
	public static SoundEvent PLAYER_PLACE_BLOCK_SOUND_EVENT = SoundEvent.of(PLAYER_PLACE_BLOCK_SOUND_ID);
	public static SoundEvent ITEM_CRAFT_SOUND_EVENT = SoundEvent.of(ITEM_CRAFT_SOUND_ID);
	public static SoundEvent PLAYER_KILL_ENTITY_SOUND_EVENT = SoundEvent.of(PLAYER_KILL_ENTITY_SOUND_ID);
	public static SoundEvent PLAYER_HIT_ENTITY_SOUND_EVENT = SoundEvent.of(PLAYER_HIT_ENTITY_SOUND_ID);
	public static SoundEvent PLAYER_DEATH_SOUND_EVENT = SoundEvent.of(PLAYER_DEATH_SOUND_ID);
	public static SoundEvent PLAYER_FARTED_EWW_SOUND_EVENT = SoundEvent.of(PLAYER_FARTED_EWW_SOUND_ID);
	public static SoundEvent PLAYER_IS_SUS_SOUND_EVENT = SoundEvent.of(PLAYER_IS_SUS_SOUND_ID);
	public static SoundEvent PLAYER_IS_CUTE_SOUND_EVENT = SoundEvent.of(PLAYER_IS_CUTE_SOUND_ID);
	public static SoundEvent SUBSCRIBE_TO_COREYTONGE_SOUND_EVENT = SoundEvent.of(SUBSCRIBE_TO_COREYTONGE_SOUND_ID);
	public static SoundEvent FITNESSGRAM_PACER_TEST_SOUND_EVENT = SoundEvent.of(FITNESSGRAM_PACER_TEST_SOUND_ID);


	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		// Register your sound event
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_IS_SNEAKING_SOUND_ID, PLAYER_IS_SNEAKING_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_IS_JUMPING_SOUND_ID, PLAYER_IS_JUMPING_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_BREAK_BLOCK_SOUND_ID, PLAYER_BREAK_BLOCK_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_PLACE_BLOCK_SOUND_ID, PLAYER_PLACE_BLOCK_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.ITEM_CRAFT_SOUND_ID, ITEM_CRAFT_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_KILL_ENTITY_SOUND_ID, PLAYER_KILL_ENTITY_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_HIT_ENTITY_SOUND_ID, PLAYER_HIT_ENTITY_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_DEATH_SOUND_ID, PLAYER_DEATH_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_FARTED_EWW_SOUND_ID, PLAYER_FARTED_EWW_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_IS_SUS_SOUND_ID, PLAYER_IS_SUS_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.PLAYER_IS_CUTE_SOUND_ID, PLAYER_IS_CUTE_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.SUBSCRIBE_TO_COREYTONGE_SOUND_ID, SUBSCRIBE_TO_COREYTONGE_SOUND_EVENT);
		Registry.register(Registries.SOUND_EVENT, Mod3.FITNESSGRAM_PACER_TEST_SOUND_ID, FITNESSGRAM_PACER_TEST_SOUND_EVENT);

		PlayerActionSoundHandler.register();
		BlockBreakHandler.register();
		BlockPlaceHandler.register();
		PlayerSoundHandler.register();

		LOGGER.info("PlayerActionSoundHandler registered!");

		// Other initialization logic can go here
	}
}
