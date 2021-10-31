package com.westsi.endupdate.block;

import com.westsi.endupdate.Endupdate;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    //new end valuables
    public static final Block ENDERITE_ORE = registerBlock("enderite_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(30f, 1200)
                    .breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));

    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(50f, 1200)
                    .breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));

    //end woods
    public static final Block DEAD_WOOD = registerBlock("dead_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2f, 2)
                    .breakByTool(FabricToolTags.AXES)));

    public static final Block DEAD_WOOD_PLANKS = registerBlock("dead_wood_planks",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(2f, 2)
                    .breakByTool(FabricToolTags.AXES)));

    //new end nature blocks
    public static final Block END_DIRT = registerBlock("end_dirt",
            new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 1)
                    .breakByTool(FabricToolTags.SHOVELS)));

    public static final Block END_GRASS = registerBlock("end_grass",
            new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5f, 1)
                    .breakByTool(FabricToolTags.SHOVELS)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Endupdate.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(Endupdate.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + Endupdate.MOD_ID);
    }
}
