package com.example.sodiumplusplus.mixin;

import com.example.sodiumplusplus.SodiumPlusPlusMod;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @ModifyArg(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/render/WorldRenderer;setupTerrain(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/Frustum;IZ)V"
        ),
        index = 2
    )
    private int modifyRenderDistance(int original) {
        return SodiumPlusPlusMod.CONFIG.renderDistance;
    }

    // Можно добавить модификацию прозрачности через @ModifyArg для вызова setAlpha или подобного,
    // но проще реализовать через другой миксин, если нужно.
}