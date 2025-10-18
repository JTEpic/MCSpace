package com.jtepic.mcspace;

import com.jtepic.mcspace.datagen.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

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
    }
}
