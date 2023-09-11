package com.person98.mod3.handlers;

import com.person98.mod3.Mod3;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.SoundCategory;

import java.util.HashMap;
import java.util.UUID;

public class PlayerActionSoundHandler {

    private static final int SOUND_COOLDOWN_TICKS = 25;  // Adjusted as per your requirement

    private static final HashMap<UUID, Integer> lastSoundPlayTickMap = new HashMap<>();  // Made this static

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
        PlayerActionSoundHandler handler = new PlayerActionSoundHandler();
        int currentTick = (int) server.getTicks();

        for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if (!handler.isSoundPlaying(player, currentTick)) {

                if (player.isSneaking()) {
                    player.playSound(Mod3.PLAYER_IS_SNEAKING_SOUND_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    handler.setSoundPlaying(player, currentTick);
                }


                else if (isJumping(player)) {
                    player.playSound(Mod3.PLAYER_IS_JUMPING_SOUND_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    handler.setSoundPlaying(player, currentTick);
                }
            }
        }
    }



    private static boolean isJumping(PlayerEntity player) {
        return player.getVelocity().y > 0 && !player.isOnGround();
    }
}
