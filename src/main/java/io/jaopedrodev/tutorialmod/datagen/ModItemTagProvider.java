package io.jaopedrodev.tutorialmod.datagen;

import java.util.concurrent.CompletableFuture;


import io.jaopedrodev.tutorialmod.item.ModItems;
import io.jaopedrodev.tutorialmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.item.Items;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{

  public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }
  @Override
  protected void configure(WrapperLookup wrapperLookup) {
    getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
      .add(ModItems.PINK_GARNET)
      .add(ModItems.RAW_PINK_GARNET)
      .add(Items.COAL)
      .add(Items.STICK)
      .add(Items.APPLE);
  }
}
