package ru.dannik.powercraft;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import ru.dannik.powercraft.BlocksL.BlockList;

public class WorldModGenerator implements IWorldGenerator{

	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
            IChunkProvider chunkProvider)
    {
            switch(world.provider.dimensionId)
            {
                    //case -1: generateNether(world, random, chunkX * 16, chunkZ * 16); break;
                    case 0: generateOverworld(world, random, chunkX * 16, chunkZ * 16); break;
                    //case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16); break;
            }
    }

    //private void generateEnd(World world, Random random, int x, int z) 
    //{
	//    int Xcoord = x + random.nextInt(16);
	//    int Ycoord = 10 + random.nextInt(128);
	 //   int Zcoord = z + random.nextInt(16);
   // 
	//    (new WorldGenMinable(BaseMyBestMod.bestblockever, 1, 15, Blocks.end_stone)).generate(world, random, Xcoord, Ycoord, Zcoord);
   // }

    private void generateOverworld(World world, Random random, int x, int z) 
    {
            this.addOreSpawn(BlockList.cyancrystal, world, random, x, z, 16, 16, 4, 2, 5, 40);
            this.addOreSpawn(BlockList.darkbluecrystal, world, random, x, z, 16, 16, 4, 2, 5, 40);
            this.addOreSpawn(BlockList.greencrystal, world, random, x, z, 16, 16, 4, 2, 5, 40);
            this.addOreSpawn(BlockList.lightbluecrystal, world, random, x, z, 16, 16, 4, 2, 5, 40);
            this.addOreSpawn(BlockList.orangecrystal, world, random, x, z, 16, 16, 4, 2, 5, 40);
            this.addOreSpawn(BlockList.purplecrystal, world, random, x, z, 16, 16, 4, 2, 5, 40);
            this.addOreSpawn(BlockList.redcrystal, world, random, x, z, 16, 16, 4, 2, 5, 40);
            this.addOreSpawn(BlockList.yellowcrystal, world, random, x, z, 16, 16, 4, 2, 5, 40);
    
    }

    //private void generateNether(World world, Random random, int x, int z)
    //{
    //int Xcoord = x + random.nextInt(16);

    //int Ycoord = 10 + random.nextInt(128);

    //int Zcoord = z + random.nextInt(16);

    //(new WorldGenMinable(BaseMyBestMod.bestblockever, 1, 15, Blocks.netherrack)).generate(world, random, Xcoord, Ycoord, Zcoord);
    //}
    
/**
 * Добавляет генерацию руды в Minecraft. Просто воспользуйтесь этим методом для регистрации генерируемых руд.

 * @param block Блок, который хотите генерировать

 * @param world Мир (не измерение), в котором этот блок должен генерироваться

 * @param random Случайное число для получения координат генерации блока

 * @param blockXPos Число для того, чтобы было пустое место по координатам X для метода генерации (использует кварцевая руда)

 * @param blockZPos Число для того, чтобы было пустое место по координатам Z для метода генерации (использует кварцевая руда)

 * @param maxX Число, которое настроит максимальную X координату для генерации руды на оси X на чанк

 * @param maxZ Число, которое настроит максимальную Z координату для генерации руды на оси Z на чанк

 * @param maxVeinSize Максимальное число блоков руды в одной жиле

 * @param chancesToSpawn Шанс генерации блоков на чанк

 * @param minY Минимальная координата Y на которой руда может сгенерироваться

 * @param maxY Максимальная координата Y на которой руда может сгенерироваться
 */
    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ,
            int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
            int maxPossY = minY + (maxY - 1);
            assert maxY > minY : "Максимальная Y должна быть больше минимальной";
            assert maxX > 0 && maxX <= 16 : "addOreSpawn: Максимальная X должна быть больше 0 и меньше 16";
            assert minY > 0 : "addOreSpawn: Минимальная Y должна быть больше 0";
            assert maxY < 256 && maxY > 0 : "addOreSpawn: Максимальная Y должна быть меньше 256 и больше 0";
            assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: Максимальная Z должна быть больше 0 и меньше 16";

            int diffBtwnMinMaxY = maxY - minY;
            for (int x = 0; x < chancesToSpawn; x++)
            {
                    int posX = blockXPos + random.nextInt(maxX);
                    int posY = minY + random.nextInt(diffBtwnMinMaxY);
                    int posZ = blockZPos + random.nextInt(maxZ);
                    (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
            }
    }

}
