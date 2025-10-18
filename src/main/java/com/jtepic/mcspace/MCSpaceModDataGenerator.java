package com.jtepic.mcspace;

import com.jtepic.mcspace.datagen.ModBlockTagProvider;
import com.jtepic.mcspace.datagen.ModItemTagProvider;
import com.jtepic.mcspace.datagen.ModLootTableProvider;
import com.jtepic.mcspace.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MCSpaceModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        // Adding a provider example:
        // For versions below 1.19:
        // generator.addProvider(AdvancementsProvider::new);
        // For versions since 1.19:
        // FabricDataGenerator.Pack pack = generator.createPack();

        // pack.addProvider(AdvancementsProvider::new);

        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
    }
}
