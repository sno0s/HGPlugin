package br.dev.sno0s.hgplugin.structures;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CustomGenerator extends ChunkGenerator {

    @NotNull
    @Override
    public ChunkData generateChunkData(@NotNull World world,
                                       @NotNull Random random,
                                       int chunkX, int chunkZ,
                                       @NotNull BiomeGrid biome) {
        ChunkData chunkData = createChunkData(world);

        // gera chão plano de pedra + grama
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 60; y++) {
                    chunkData.setBlock(x, y, z, Material.STONE);
                }
                chunkData.setBlock(x, 60, z, Material.DIRT);
                chunkData.setBlock(x, 61, z, Material.GRASS_BLOCK);
            }
        }

        return chunkData;
    }

    @Override
    public @NotNull List<BlockPopulator> getDefaultPopulators(@NotNull World world) {
        // garante que o populator de cogumelos vai rodar
        return Collections.singletonList(new MushroomPopulator());
    }
}
