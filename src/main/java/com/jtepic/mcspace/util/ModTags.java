package com.jtepic.mcspace.util;

import com.jtepic.mcspace.MCSpace;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MCSpace.MOD_ID, name));
        }
    }

    public static class Items {
        // Custom Tag holds in datagen or data/xyz/tags if not generating
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MCSpace.MOD_ID, name));
        }
    }
}
