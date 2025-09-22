package br.dev.sno0s.hgplugin.structures;

import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HGWorldProvider extends BiomeProvider {

    private static final List<Biome> ALLOWED = List.of(
            Biome.PLAINS
    );

    @NotNull
    @Override
    public Biome getBiome(@NotNull WorldInfo worldInfo, int x, int y, int z) {
        Random rand = new Random((x * 341873128712L + z * 132897987541L) ^ worldInfo.getSeed());
        return ALLOWED.get(rand.nextInt(ALLOWED.size()));
    }

    @NotNull
    @Override
    public List<Biome> getBiomes(@NotNull WorldInfo worldInfo) {
        return ALLOWED;
    }
}
