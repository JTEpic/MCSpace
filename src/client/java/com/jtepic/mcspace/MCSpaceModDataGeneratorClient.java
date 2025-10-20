package com.jtepic.mcspace;

import com.jtepic.mcspace.datagen.*;
import com.jtepic.mcspace.trim.ModTrimMaterials;
import com.jtepic.mcspace.trim.ModTrimPatterns;
import com.jtepic.mcspace.world.ModConfiguredFeatures;
import com.jtepic.mcspace.world.ModPlacedFeatures;
import com.jtepic.mcspace.world.dimension.ModDimensions;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MCSpaceModDataGeneratorClient implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        // Adding a provider example:
        // For versions below 1.19:
        // generator.addProvider(AdvancementsProvider::new);
        // For versions since 1.19:
        // FabricDataGenerator.Pack pack = generator.createPack();

        // pack.addProvider(AdvancementsProvider::new);

        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ModModelProvider::new);

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModRegistryDataGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        // Trims
        registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.TRIM_PATTERN, ModTrimPatterns::bootstrap);

        // World Gen
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

        // Dimension
        registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
    }
}