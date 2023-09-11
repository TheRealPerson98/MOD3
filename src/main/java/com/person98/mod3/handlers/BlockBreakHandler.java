package com.person98.mod3.handlers;

import com.person98.mod3.Mod3;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;

public class BlockBreakHandler {

    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            handleBlockBreak(player, pos);
        });
    }

    private static void handleBlockBreak(PlayerEntity player, BlockPos pos) {
        Mod3.LOGGER.info("Player " + player.getName().getString() + " broke a block at " + pos.toShortString());
        player.playSound(Mod3.PLAYER_BREAK_BLOCK_SOUND_EVENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}
