package com.jtepic.mcspace.datagen;

import com.jtepic.mcspace.block.ModBlocks;
import com.jtepic.mcspace.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Block and Item datagen
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACK_HOLE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Item datagen
        itemModelGenerator.register(ModItems.PARACHUTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_PARACHUTE, Models.GENERATED);

        // Trim
        itemModelGenerator.register(ModItems.SMITHING_TEMPLATE, Models.GENERATED);
    }
}
