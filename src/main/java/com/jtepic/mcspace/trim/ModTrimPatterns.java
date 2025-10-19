package com.jtepic.mcspace.trim;

import com.jtepic.mcspace.MCSpace;
import com.jtepic.mcspace.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    // Armor Pattern Trim Customization
    public static final RegistryKey<ArmorTrimPattern> KAUPEN = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(MCSpace.MOD_ID, "kaupen"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.SMITHING_TEMPLATE, KAUPEN);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }
}