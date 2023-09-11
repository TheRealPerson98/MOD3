package com.person98.mod3.handlers;

import net.minecraft.entity.player.PlayerEntity;

public interface ISoundHandler {
    boolean isSoundPlaying(PlayerEntity player);
    void setSoundPlaying(PlayerEntity player, boolean playing);
}
