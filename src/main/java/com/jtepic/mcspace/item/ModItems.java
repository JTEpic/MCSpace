package com.jtepic.mcspace.item;

import com.jtepic.mcspace.MCSpace;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item PARACHUTE = registerItem("parachute", Item::new);
    public static final Item GREEN_PARACHUTE = registerItem("green_parachute", Item::new);

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
        });
    }
}
