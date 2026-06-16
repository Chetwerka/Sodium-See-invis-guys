package com.example.sodiumplusplus.keybind;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static KeyBinding TOGGLE_MOD;
    public static KeyBinding RELOAD_CONFIG;
    public static KeyBinding TOGGLE_RENDERING;

    public static void register() {
        TOGGLE_MOD = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.sodiumplusplus.toggle_mod",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                "category.sodiumplusplus"
        ));
        RELOAD_CONFIG = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.sodiumplusplus.reload_config",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.sodiumplusplus"
        ));
        TOGGLE_RENDERING = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.sodiumplusplus.toggle_rendering",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "category.sodiumplusplus"
        ));
    }
}