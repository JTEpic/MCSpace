package com.jtepic.mcspace.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRegistryDataGenerator extends FabricDynamicRegistryProvider {
    public ModRegistryDataGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        // Trims
        entries.addAll(wrapperLookup.getOrThrow(RegistryKeys.TRIM_MATERIAL));
        entries.addAll(wrapperLookup.getOrThrow(RegistryKeys.TRIM_PATTERN));

        // World Gen
        //entries.addAll(wrapperLookup.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        //entries.addAll(wrapperLookup.getOrThrow(RegistryKeys.PLACED_FEATURE));

        // Biomes
        entries.addAll(wrapperLookup.getOrThrow(RegistryKeys.BIOME));

        // Dimension
        entries.addAll(wrapperLookup.getOrThrow(RegistryKeys.DIMENSION_TYPE));
    }

    @Override
    public String getName() {
        return "";
    }
}