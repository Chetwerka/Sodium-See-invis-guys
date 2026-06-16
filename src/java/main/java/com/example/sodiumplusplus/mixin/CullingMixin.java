package com.example.sodiumplusplus.mixin;

import com.example.sodiumplusplus.SodiumPlusPlusMod;
import net.minecraft.client.render.Frustum;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Frustum.class)
public class CullingMixin {
    @Inject(method = "isVisible(Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private void onIsVisible(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (!SodiumPlusPlusMod.CONFIG.enabled) return;
        if (SodiumPlusPlusMod.CONFIG.frustumCulling) {
            // По умолчанию оставляем как есть, но можно отключить culling для некоторых сущностей
            // Например, всегда показывать игроков, если нужно
        }
    }
}