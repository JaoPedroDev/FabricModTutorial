package io.jaopedrodev.tutorialmod.block.custom;

import io.jaopedrodev.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block{
  public MagicBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
    world.playSound(player, pos, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 1f, 1f);
    return ActionResult.SUCCESS;
  }

  @Override
  public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
    if(entity instanceof ItemEntity itemEntity) {
      if(itemEntity.getStack().getItem() == ModItems.RAW_PINK_GARNET){
        itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
      }
    }
  }

  @Override
  public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
    world.playSound(null, pos, SoundEvents.ENTITY_CHICKEN_AMBIENT, SoundCategory.BLOCKS, 1f, 1f);
  }
}