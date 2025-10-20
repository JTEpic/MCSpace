package com.jtepic.mcspace.trim;

import com.jtepic.mcspace.MCSpace;
import com.jtepic.mcspace.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    // Armor Color Trim Customization, may need to add to atlases when creating
    public static final RegistryKey<ArmorTrimMaterial> PARACHUTE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(MCSpace.MOD_ID, "parachute"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, PARACHUTE, Registries.ITEM.getEntry(ModItems.PARACHUTE),
                Style.EMPTY.withColor(TextColor.parse("#b03fe0").getOrThrow()));
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style) {
                                                                        //armorTrimKey.getValue().getPath(), float itemModelIndex
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(ArmorTrimAssets.of("parachute"),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}