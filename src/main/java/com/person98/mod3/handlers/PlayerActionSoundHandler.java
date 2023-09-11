package com.person98.mod3.handlers;

import com.person98.mod3.Mod3;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.SoundCategory;

import java.util.HashMap;
import java.util.UUID;

public class PlayerActionSoundHandler {

    private static final int SOUND_COOLDOWN_TICKS = 30;

    private final HashMap<UUID, Integer> lastSoundPlayTickMap = new HashMap<>();

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(PlayerActionSoundHandler::handleServerTick);
    }

    public boolean isSoundPlaying(PlayerEntity player, int currentTick) {
        int lastTickPlayed = lastSoundPlayTickMap.getOrDefault(player.getUuid(), -SOUND_COOLDOWN_TICKS);
        return (currentTick - lastTickPlayed) < SOUND_COOLDOWN_TICKS;
    }

    public void setSoundPlaying(PlayerEntity player, int currentTick) {
        lastSoundPlayTickMap.put(player.getUuid(), currentTick);
    }

    private static void handleServerTick(MinecraftServer server) {
        Mod3.LOGGER.info("Server tick!");

        PlayerActionSoundHandler handler = new PlayerActionSoundHandler();
        int currentTick = (int) server.getTicks();

        for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {

            if (!handler.isSoundPlaying(player, currentTick)) {

                if (player.isSneaking()) {
                    Mod3.LOGGER.info("Player is sneaking!");
                    player.playSound(Mod3.PLAYER_IS_SNEAKING_SOUND_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    handler.setSoundPlaying(player, currentTick);
                }

                else if (isWalking(player)) {
                    Mod3.LOGGER.info("Player is walking!");
                    player.playSound(Mod3.PLAYER_IS_WALKING_SOUND_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    handler.setSoundPlaying(player, currentTick);
                }

                else if (isRunning(player)) {
                    Mod3.LOGGER.info("Player is running!");
                    player.playSound(Mod3.PLAYER_IS_RUNNING_SOUND_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    handler.setSoundPlaying(player, currentTick);
                }

                else if (isJumping(player)) {
                    Mod3.LOGGER.info("Player is jumping!");
                    player.playSound(Mod3.PLAYER_IS_JUMPING_SOUND_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    handler.setSoundPlaying(player, currentTick);
                }
            }
        }
    }

    private static boolean isWalking(PlayerEntity player) {
        double velocitySquared = player.getVelocity().x * player.getVelocity().x + player.getVelocity().z * player.getVelocity().z;
        return velocitySquared > 0.1 && player.isOnGround() && !player.isSneaking();
    }

    private static boolean isRunning(PlayerEntity player) {
        double velocitySquared = player.getVelocity().x * player.getVelocity().x + player.getVelocity().z * player.getVelocity().z;
        return velocitySquared > 0.2 && player.isOnGround() && !player.isSneaking();
    }

    private static boolean isJumping(PlayerEntity player) {
        return player.getVelocity().y > 0 && !player.isOnGround();
    }
}
