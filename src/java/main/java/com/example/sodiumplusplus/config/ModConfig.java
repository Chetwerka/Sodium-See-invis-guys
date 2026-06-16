package com.example.sodiumplusplus.config;

import com.example.sodiumplusplus.SodiumPlusPlusMod;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = SodiumPlusPlusMod.MOD_ID)
public class ModConfig implements ConfigData {
    // Основные
    @ConfigEntry.Gui.Tooltip
    public boolean enabled = true;

    // Rendering
    @ConfigEntry.Gui.Tooltip
    public int transparency = 50; // 0-100

    @ConfigEntry.Gui.Tooltip
    public float entityOpacity = 1.0f;

    @ConfigEntry.Gui.Tooltip
    public String customGlowColor = "#FFAA00";

    @ConfigEntry.Gui.Tooltip
    public int renderDistance = 12;

    @ConfigEntry.Gui.Tooltip
    public boolean throughWallsOutline = false;

    @ConfigEntry.Gui.Tooltip
    public boolean dynamicAlpha = true;

    // Entity Filters
    public boolean renderPlayers = true;
    public boolean renderPassiveMobs = true;
    public boolean renderHostileMobs = true;
    public boolean renderAnimals = true;
    public boolean renderVillagers = true;
    public boolean renderArmorStands = true;

    @ConfigEntry.Gui.Tooltip
    public String customBlacklist = "";

    // Performance
    public boolean distanceCulling = true;
    public boolean frustumCulling = true;
    public boolean cachedEntityLists = true;
    public boolean tickOptimization = true;
    public boolean renderOptimization = true;

    // Preset (сохраняется как строка)
    public String currentPreset = "Custom";
}