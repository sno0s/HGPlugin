package br.dev.sno0s.hgplugin.structures;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class MushroomPopulator extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        // número de tentativas por chunk (ajuste conforme a densidade que você quiser)
        int tries = 20 + random.nextInt(11); // 20 a 30 tentativas

        for (int i = 0; i < tries; i++) {
            int x = (chunk.getX() << 4) + random.nextInt(16);
            int z = (chunk.getZ() << 4) + random.nextInt(16);
            int y = world.getHighestBlockYAt(x, z);

            // bloco acima da superfície
            Block above = world.getBlockAt(x, y+1, z);

            // escolhe cogumelo aleatório
            Material mushroom = random.nextBoolean()
                    ? Material.BROWN_MUSHROOM
                    : Material.RED_MUSHROOM;

            // define o bloco ignorando física/luz
            above.setType(mushroom, false);
        }
    }
}
