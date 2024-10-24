package io.jaopedrodev.tutorialmod.block.custom;

import java.util.List;

import io.jaopedrodev.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block {
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
    if (entity instanceof ItemEntity itemEntity) {
      if (isValid(itemEntity.getStack())) {
        itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
      }
    }
  }

  private boolean isValid(ItemStack stack) {
    return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
  }

  @Override
  public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
    world.playSound(null, pos, SoundEvents.ENTITY_CHICKEN_HURT, SoundCategory.BLOCKS, 1f, 1f);
  }

  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
    tooltip.add(Text.translatable("tooltip.tutorialmod.magic_block"));
    super.appendTooltip(stack, context, tooltip, options);
  }
}
