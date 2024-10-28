package io.jaopedrodev.tutorialmod.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import io.jaopedrodev.tutorialmod.TutorialMod;
import io.jaopedrodev.tutorialmod.block.ModBlocks;
import io.jaopedrodev.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.item.Items;

public class ModRecipeProvider extends FabricRecipeProvider {

  public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  public void generate(RecipeExporter exporter) {
    List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
        ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

    offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100,
        "pink_garnet");
    offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200,
        "pink_garnet");

    offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET,
        RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
        .pattern("RRR")
        .pattern("RRR")
        .pattern("RRR")
        .input('R', ModItems.RAW_PINK_GARNET)
        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
        .offerTo(exporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CHISEL)
        .pattern(" PP")
        .pattern(" SP")
        .pattern("S  ")
        .input('P', ModItems.PINK_GARNET)
        .input('S', Items.STICK)
        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
        .offerTo(exporter);

    ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
        .offerTo(exporter);

    ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
        .input(ModBlocks.MAGIC_BLOCK)
        .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
        .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet_from_magic_block"));

    createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModItems.PINK_GARNET))
      .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
      .offerTo(exporter);

    createSlabRecipe(RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_SLAB, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
      .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
      .offerTo(exporter);
   
    createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
      .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
      .offerTo(exporter);

    createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
      .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
      .offerTo(exporter);

    createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
      .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
      .offerTo(exporter);

    createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModItems.PINK_GARNET))
      .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
      .offerTo(exporter);

    createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
      .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
      .offerTo(exporter);

    getWallRecipe(RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_WALLS, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
      .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
      .offerTo(exporter);

    // Button recipe
    createTransmutationRecipe(ModBlocks.PINK_GARNET_BUTTON, Ingredient.ofItems(ModItems.PINK_GARNET))
      .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
      .offerTo(exporter);
  }
}
