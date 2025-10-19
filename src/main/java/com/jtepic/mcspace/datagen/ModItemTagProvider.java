package com.jtepic.mcspace.datagen;

import com.jtepic.mcspace.item.ModItems;
import com.jtepic.mcspace.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Item Tags datagen
        // Custom Tags
        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.PARACHUTE);

        // Trim Tags
        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.PARACHUTE);
        //TRIM.TEMPLATES
    }
}
