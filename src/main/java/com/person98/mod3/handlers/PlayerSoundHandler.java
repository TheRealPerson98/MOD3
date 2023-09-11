package com.person98.mod3.handlers;

import com.person98.mod3.Mod3;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;

import java.util.Random;

public class PlayerSoundHandler {

    private static int tickCounter = 0;
    private static final int TICK_INTERVAL_MIN = 200;  // 10 seconds
    private static final int TICK_INTERVAL_MAX = 600;  // 30 seconds
    private static final Random RANDOM = new Random();

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(PlayerSoundHandler::handleServerTick);
    }

    private static void handleServerTick(MinecraftServer server) {
        tickCounter++;

        int nextInterval = TICK_INTERVAL_MIN + RANDOM.nextInt(TICK_INTERVAL_MAX - TICK_INTERVAL_MIN);

        if (tickCounter >= nextInterval) {
            tickCounter = 0;  // Reset the counter

            for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (!player.getWorld().isClient) {
                    SoundEvent sound = getRandomSound();
                    player.playSound(sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
    }

    private static SoundEvent getRandomSound() {
        SoundEvent[] sounds = {
                Mod3.PLAYER_FARTED_EWW_SOUND_EVENT,
                Mod3.PLAYER_IS_SUS_SOUND_EVENT,
                Mod3.PLAYER_IS_CUTE_SOUND_EVENT,
                Mod3.SUBSCRIBE_TO_COREYTONGE_SOUND_EVENT,
                Mod3.FITNESSGRAM_PACER_TEST_SOUND_EVENT
        };
        return sounds[RANDOM.nextInt(sounds.length)];
    }
}
