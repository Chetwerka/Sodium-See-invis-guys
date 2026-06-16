package com.example.sodiumplusplus.hud;

import com.example.sodiumplusplus.SodiumPlusPlusMod;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class HUDOverlay implements HudRenderCallback {
    private int fpsCounter = 0;
    private long lastUpdate = 0;

    @Override
    public void render(DrawContext context, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options.hudHidden) return;
        TextRenderer textRenderer = client.textRenderer;

        // Индикатор включения
        String status = SodiumPlusPlusMod.CONFIG.enabled ? "§aON" : "§cOFF";
        context.drawText(textRenderer, "Sodium++: " + status, 5, 5, 0xFFFFFF, true);

        // FPS (опционально)
        if (SodiumPlusPlusMod.CONFIG.enabled) {
            long now = System.currentTimeMillis();
            if (now - lastUpdate >= 1000) {
                fpsCounter = MinecraftClient.getInstance().getCurrentFps();
                lastUpdate = now;
            }
            context.drawText(textRenderer, "FPS: " + fpsCounter, 5, 15, 0xFFFFFF, true);
        }
    }
}