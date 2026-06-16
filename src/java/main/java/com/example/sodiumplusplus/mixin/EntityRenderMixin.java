package com.example.sodiumplusplus.mixin;

import com.example.sodiumplusplus.SodiumPlusPlusMod;
import com.example.sodiumplusplus.config.ModConfig;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.passive.WaterAnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void onRender(Entity entity, double x, double y, double z, float yaw, float tickDelta, CallbackInfo ci) {
        ModConfig config = SodiumPlusPlusMod.CONFIG;
        if (!config.enabled) return;

        // Фильтрация
        if (!config.renderPlayers && entity instanceof PlayerEntity) {
            ci.cancel();
            return;
        }
        if (!config.renderPassiveMobs && (entity instanceof PassiveEntity || entity instanceof AnimalEntity)) {
            ci.cancel();
            return;
        }
        if (!config.renderHostileMobs && entity instanceof HostileEntity) {
            ci.cancel();
            return;
        }
        if (!config.renderAnimals && (entity instanceof AnimalEntity || entity instanceof WaterAnimalEntity)) {
            ci.cancel();
            return;
        }
        if (!config.renderVillagers && entity instanceof VillagerEntity) {
            ci.cancel();
            return;
        }
        if (!config.renderArmorStands && entity instanceof ArmorStandEntity) {
            ci.cancel();
            return;
        }
        // Чёрный список по имени
        String blacklist = config.customBlacklist;
        if (!blacklist.isEmpty()) {
            String[] names = blacklist.split(",");
            for (String name : names) {
                if (entity.getType().getName().getString().equalsIgnoreCase(name.trim())) {
                    ci.cancel();
                    return;
                }
            }
        }
    }
}