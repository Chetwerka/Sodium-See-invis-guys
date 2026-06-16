package com.example.sodiumplusplus;

import com.example.sodiumplusplus.config.ConfigManager;
import com.example.sodiumplusplus.config.ModConfig;
import com.example.sodiumplusplus.hud.HUDOverlay;
import com.example.sodiumplusplus.keybind.KeyBindings;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SodiumPlusPlusMod implements ClientModInitializer {
    public static final String MOD_ID = "sodiumplusplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static ModConfig CONFIG;

    @Override
    public void onInitializeClient() {
        // Регистрация конфигурации
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        // Регистрация клавиш
        KeyBindings.register();

        // Регистрация HUD
        HudRenderCallback.EVENT.register(new HUDOverlay());

        // Обработка нажатий клавиш
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (KeyBindings.TOGGLE_MOD.wasPressed()) {
                CONFIG.enabled = !CONFIG.enabled;
                ConfigManager.saveConfig(CONFIG);
            }
            while (KeyBindings.RELOAD_CONFIG.wasPressed()) {
                CONFIG = ConfigManager.loadConfig();
            }
            while (KeyBindings.TOGGLE_RENDERING.wasPressed()) {
                // Просто пример: можно переключать что-то ещё
                CONFIG.renderOptimization = !CONFIG.renderOptimization;
                ConfigManager.saveConfig(CONFIG);
            }
        });

        LOGGER.info("Sodium++ initialized for 1.21.11!");
    }
}