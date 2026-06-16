package com.example.sodiumplusplus.config;

public enum Presets {
    COMPETITIVE,
    SURVIVAL,
    PVE,
    CREATIVE,
    LOW_END;

    public static void apply(ModConfig config, Presets preset) {
        // Сброс к значениям по умолчанию (сначала очищаем)
        ModConfig defaultConfig = new ModConfig();
        // Копируем поля из defaultConfig, но потом перезаписываем нужные
        config.enabled = defaultConfig.enabled;
        config.transparency = defaultConfig.transparency;
        config.entityOpacity = defaultConfig.entityOpacity;
        config.customGlowColor = defaultConfig.customGlowColor;
        config.renderDistance = defaultConfig.renderDistance;
        config.throughWallsOutline = defaultConfig.throughWallsOutline;
        config.dynamicAlpha = defaultConfig.dynamicAlpha;
        config.renderPlayers = defaultConfig.renderPlayers;
        config.renderPassiveMobs = defaultConfig.renderPassiveMobs;
        config.renderHostileMobs = defaultConfig.renderHostileMobs;
        config.renderAnimals = defaultConfig.renderAnimals;
        config.renderVillagers = defaultConfig.renderVillagers;
        config.renderArmorStands = defaultConfig.renderArmorStands;
        config.customBlacklist = defaultConfig.customBlacklist;
        config.distanceCulling = defaultConfig.distanceCulling;
        config.frustumCulling = defaultConfig.frustumCulling;
        config.cachedEntityLists = defaultConfig.cachedEntityLists;
        config.tickOptimization = defaultConfig.tickOptimization;
        config.renderOptimization = defaultConfig.renderOptimization;

        switch (preset) {
            case COMPETITIVE:
                config.renderPlayers = true;
                config.renderPassiveMobs = false;
                config.renderHostileMobs = false;
                config.renderAnimals = false;
                config.renderVillagers = false;
                config.renderArmorStands = false;
                config.renderDistance = 8;
                config.distanceCulling = true;
                config.frustumCulling = true;
                config.transparency = 30;
                config.currentPreset = "Competitive";
                break;
            case SURVIVAL:
                config.renderPlayers = true;
                config.renderPassiveMobs = true;
                config.renderHostileMobs = true;
                config.renderAnimals = true;
                config.renderVillagers = true;
                config.renderArmorStands = true;
                config.renderDistance = 12;
                config.transparency = 50;
                config.currentPreset = "Survival";
                break;
            case PVE:
                config.renderPlayers = true;
                config.renderPassiveMobs = true;
                config.renderHostileMobs = false;
                config.renderAnimals = true;
                config.renderVillagers = true;
                config.renderArmorStands = false;
                config.renderDistance = 10;
                config.currentPreset = "PvE";
                break;
            case CREATIVE:
                config.renderPlayers = true;
                config.renderPassiveMobs = true;
                config.renderHostileMobs = true;
                config.renderAnimals = true;
                config.renderVillagers = true;
                config.renderArmorStands = true;
                config.renderDistance = 16;
                config.transparency = 100;
                config.currentPreset = "Creative";
                break;
            case LOW_END:
                config.renderPlayers = true;
                config.renderPassiveMobs = false;
                config.renderHostileMobs = true;
                config.renderAnimals = false;
                config.renderVillagers = false;
                config.renderArmorStands = false;
                config.renderDistance = 6;
                config.distanceCulling = true;
                config.frustumCulling = true;
                config.cachedEntityLists = true;
                config.tickOptimization = true;
                config.renderOptimization = true;
                config.transparency = 20;
                config.currentPreset = "Low-End";
                break;
            default:
                config.currentPreset = "Custom";
                break;
        }
    }
}