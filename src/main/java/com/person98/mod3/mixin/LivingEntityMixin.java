package com.person98.mod3.mixin;

import com.person98.mod3.Mod3;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onEntityDeath(DamageSource source, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.getWorld().isClient && source.getAttacker() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) source.getAttacker();
            player.playSound(Mod3.PLAYER_KILL_ENTITY_SOUND_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
        }
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void onEntityDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.getWorld().isClient && source.getAttacker() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) source.getAttacker();
            player.playSound(Mod3.PLAYER_HIT_ENTITY_SOUND_EVENT, SoundCategory.PLAYERS, 1.0F, 1.0F);
        }
    }
}
