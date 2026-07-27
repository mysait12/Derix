package com.mymod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class MainMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.world == null || client.player == null) return;

            // Включаем свечение сущностей вокруг
            for (Entity entity : client.world.getEntities()) {
                if (entity instanceof LivingEntity && entity != client.player) {
                    entity.setGlowing(true);
                }
            }
        });
    }
}
