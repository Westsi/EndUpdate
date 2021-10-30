package com.westsi.endupdate.worldgen;

import com.westsi.endupdate.block.ModBlocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class OreGenEnd {

        public static final ConfiguredFeature<?, ?> ORE_WOOL_OVERWORLD = Feature.ORE
                .configure(new OreFeatureConfig(
                        OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                        ModBlocks.ENDERITE_ORE.getDefaultState(),
                        2)) // Vein size
                .range(new RangeDecoratorConfig(
                        // You can also use one of the other height providers if you don't want a uniform distribution
                        UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))) // Inclusive min and max height
                .spreadHorizontally()
                .repeat(20); // Number of veins per chunk
}

