package com.jtepic.mcspace.item;

import com.jtepic.mcspace.MCSpace;
import com.jtepic.mcspace.trim.ModTrimMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    // Items with certain settings
    public static final Item PARACHUTE = registerItem("parachute",
            setting -> new Item(setting
            .trimMaterial(ModTrimMaterials.PARACHUTE)));
    public static final Item GREEN_PARACHUTE = registerItem("green_parachute", Item::new);

    // Armor Trim Template Item
    //public static final Item SMITHING_TEMPLATE = registerItem("armor_trim_smithing_template",
            //SmithingTemplateItem.of(new Identifier("mcspace", "smithing_template")));
    public static final Item SMITHING_TEMPLATE = registerItem("armor_trim_smithing_template", SmithingTemplateItem::of);
            //settings -> new SmithingTemplateItem.of(new Identifier("mcspace", "smithing_template"),
            //        settings.trimPattern(ModTrims.SOME_PATTERN_KEY)));
            /*SmithingTemplateItem.of(new Item.Settings()
                    .trimMaterial(ModTrimMaterials.PARACHUTE)
                    .requires(FeatureFlags.VANILLA)
                    //.registryKey(getItemRegistryKey("armor_trim_smithing_template"))));
                    .registryKey(RegistryKey.of())));*/
            //(Function<Item.Settings, Item>) new Item(new Item.Settings()
                    //.trimMaterial(ModTrimMaterials.PARACHUTE)
                    //.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MCSpace.MOD_ID,"parachute")))));

    // Register Item
    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MCSpace.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MCSpace.MOD_ID, name)))));
    }

    public static void registerModItems() {
        MCSpace.LOGGER.info("Registering Mod Items for " + MCSpace.MOD_ID);

        // Add to creative mode selection in certain ItemGroups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PARACHUTE);
            entries.add(GREEN_PARACHUTE);

            entries.add(SMITHING_TEMPLATE);
        });
    }
}