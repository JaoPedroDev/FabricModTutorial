package io.jaopedrodev.tutorialmod;

import io.jaopedrodev.tutorialmod.datagen.ModBlockTagProvider;
import io.jaopedrodev.tutorialmod.datagen.ModItemTagProvider;
import io.jaopedrodev.tutorialmod.datagen.ModLootTableProvider;
import io.jaopedrodev.tutorialmod.datagen.ModModelProvider;
import io.jaopedrodev.tutorialmod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TutorialModDataGenerator implements DataGeneratorEntrypoint {
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(ModBlockTagProvider::new);
    pack.addProvider(ModItemTagProvider::new);
    pack.addProvider(ModLootTableProvider::new);
    pack.addProvider(ModModelProvider::new);
    pack.addProvider(ModRecipeProvider::new);
  }
}
