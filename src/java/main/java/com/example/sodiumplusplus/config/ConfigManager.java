package com.example.sodiumplusplus.config;

import com.example.sodiumplusplus.SodiumPlusPlusMod;
import me.shedaniel.autoconfig.AutoConfig;

public class ConfigManager {
    public static ModConfig loadConfig() {
        return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    public static void saveConfig(ModConfig config) {
        AutoConfig.getConfigHolder(ModConfig.class).setConfig(config);
        AutoConfig.getConfigHolder(ModConfig.class).save();
    }

    public static void resetConfig() {
        ModConfig defaultConfig = new ModConfig();
        saveConfig(defaultConfig);
    }
}