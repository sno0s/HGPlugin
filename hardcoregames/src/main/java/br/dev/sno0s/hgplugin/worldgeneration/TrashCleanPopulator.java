package br.dev.sno0s.hgplugin.structures;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import java.util.*;

public class TrashCleanPopulator extends BlockPopulator {

    private static final Set<Material> CLEAR_BLOCKS = new HashSet<>(Arrays.asList(
            Material.LILAC,
            Material.ROSE_BUSH,
            Material.LILY_OF_THE_VALLEY,
            Material.SHORT_GRASS,
            Material.TALL_GRASS,
            Material.FERN,
            Material.LARGE_FERN,
            Material.PEONY
            // pode adicionar mais se precisar
    ));

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        int chunkX = chunk.getX() << 4;
        int chunkZ = chunk.getZ() << 4;

        // só olha a superfície de cada coluna
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int worldX = chunkX + x;
                int worldZ = chunkZ + z;

                int y = world.getHighestBlockYAt(worldX, worldZ) - 1;
                if (y < world.getMinHeight()) continue;

                // bloco da superfície
                Block surface = world.getBlockAt(worldX, y, worldZ);
                // bloco acima (onde normalmente ficam flores e grama)
                Block above = surface.getRelative(0, 1, 0);

                if (CLEAR_BLOCKS.contains(above.getType())) {
                    above.setType(Material.AIR, false);
                }
            }
        }
    }
}
