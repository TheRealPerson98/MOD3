package com.person98.mod3.handlers;

import com.person98.mod3.Mod3;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class BlockPlaceHandler {

    public static void register() {
        UseBlockCallback.EVENT.register(BlockPlaceHandler::handleBlockPlace);
    }

    private static ActionResult handleBlockPlace(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if (!world.isClient) {
            player.playSound(Mod3.PLAYER_PLACE_BLOCK_SOUND_EVENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return ActionResult.PASS;
    }
}
