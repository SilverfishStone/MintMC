package net.silverfishstone.mintmc.resource.items.tool;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public interface MintToolMaterial {
   ToolMaterial STEEL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, ItemTags.IRON_TOOL_MATERIALS);
}
