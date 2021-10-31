package com.westsi.endupdate;

import com.westsi.endupdate.block.ModBlocks;
import com.westsi.endupdate.enchants.EndSlayer;
import com.westsi.endupdate.item.ModItems;
import com.westsi.endupdate.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.TrapezoidHeightProvider;


public class Endupdate implements ModInitializer {

    public static final String MOD_ID = "endupdate";

    private static ConfiguredFeature<?, ?> ORE_ENDERITE_END = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    ModBlocks.ENDERITE_ORE.getDefaultState(),
                    3)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    TrapezoidHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64), 30))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(2); // Number of veins per chunk

    public static Enchantment ENDSLAYER = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("endupdate", "end_slayer"),
            new EndSlayer()
    );


    @Override
    public void onInitialize() {




        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModLootTableModifiers.modifyLootTables();


        RegistryKey<ConfiguredFeature<?, ?>> oreEnderiteEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("endupdate", "ore_enderite_end"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreEnderiteEnd.getValue(), ORE_ENDERITE_END);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, oreEnderiteEnd);

    }
}
