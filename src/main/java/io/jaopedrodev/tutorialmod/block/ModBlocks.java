package io.jaopedrodev.tutorialmod.block;

import io.jaopedrodev.tutorialmod.TutorialMod;
import io.jaopedrodev.tutorialmod.block.custom.MagicBlock;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;

public class ModBlocks {
  public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
      new Block(AbstractBlock.Settings.create()
          .strength(4f)
          .requiresTool()
          .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
      new Block(AbstractBlock.Settings.create()
          .strength(3f)
          .requiresTool()
          .sounds(BlockSoundGroup.AMETHYST_CLUSTER)));

  public static Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
      new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
          AbstractBlock.Settings.create()
              .strength(3f)
              .requiresTool()
              .sounds(BlockSoundGroup.STONE)));

  public static Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
      new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
          AbstractBlock.Settings.create()
              .strength(4f)
              .requiresTool()
              .sounds(BlockSoundGroup.DEEPSLATE)));

  public static Block MAGIC_BLOCK = registerBlock("magic_block",
      new MagicBlock(AbstractBlock.Settings.create()
          .strength(2f)
          .sounds(BlockSoundGroup.SHROOMLIGHT)));

  public static Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
      new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
          AbstractBlock.Settings.create()
              .strength(4f)
              .requiresTool()
              .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
      new SlabBlock(AbstractBlock.Settings.create()
          .strength(4f)
          .requiresTool()
          .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
      new ButtonBlock(BlockSetType.IRON, 2,
          AbstractBlock.Settings.create()
              .strength(4f)
              .requiresTool()
              .noCollision()
              .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
      new PressurePlateBlock(BlockSetType.IRON,
          AbstractBlock.Settings.create()
              .strength(4f)
              .requiresTool()
              .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
      new FenceBlock(AbstractBlock.Settings.create()
          .strength(4f)
          .requiresTool()
          .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
      new FenceGateBlock(WoodType.ACACIA,
          AbstractBlock.Settings.create()
              .strength(4f)
              .requiresTool()
              .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block PINK_GARNET_WALLS = registerBlock("pink_garnet_walls",
      new WallBlock(AbstractBlock.Settings.create()
          .strength(4f)
          .requiresTool()
          .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
      new DoorBlock(BlockSetType.IRON,
          AbstractBlock.Settings.create()
              .strength(4f)
              .requiresTool()
              .nonOpaque()
              .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  public static Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
      new TrapdoorBlock(BlockSetType.IRON,
          AbstractBlock.Settings.create()
              .strength(4f)
              .requiresTool()
              .nonOpaque()
              .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

  private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
  }

  private static void registerBlockItem(String name, Block block) {
    Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
  }

  public static void registerModBlocks() {
    TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
      entries.add(PINK_GARNET_BLOCK);
      entries.add(RAW_PINK_GARNET_BLOCK);
      entries.add(PINK_GARNET_ORE);
      entries.add(PINK_GARNET_DEEPSLATE_ORE);
    });
  }
}
