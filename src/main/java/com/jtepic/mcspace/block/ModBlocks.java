package com.jtepic.mcspace.block;

import com.jtepic.mcspace.MCSpace;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block MOON_BLOCK = registerBlock("moon_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.BONE)));
    public static final Block BLACK_HOLE_BLOCK = registerBlock("black_hole_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.GLASS)));

    // Register Block
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MCSpace.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MCSpace.MOD_ID, name), toRegister);
    }

    // Register BlockItem
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MCSpace.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MCSpace.MOD_ID, name)))));
    }
    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(MCSpace.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MCSpace.MOD_ID, name)))));
    }

    public static void registerModBlocks(){
        MCSpace.LOGGER.info("Registering Mod Blocks for " + MCSpace.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.MOON_BLOCK);
            entries.add(ModBlocks.BLACK_HOLE_BLOCK);
        });
    }
}
