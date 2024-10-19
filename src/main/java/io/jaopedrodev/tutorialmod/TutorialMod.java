package io.jaopedrodev.tutorialmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jaopedrodev.tutorialmod.item.ModItemGroups;
import io.jaopedrodev.tutorialmod.item.ModItems;
import io.jaopedrodev.tutorialmod.block.ModBlocks;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
    ModItemGroups.registerItemGroups();
    ModItems.registerModItems();
    ModBlocks.registerModBlocks();
	}
}
