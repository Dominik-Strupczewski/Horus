package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if(blocks != null){
            List<Block> allBlocks = new ArrayList<>() ;
            allBlocks = ListOfAllStructureBlocks(blocks);
            for(Block block : allBlocks)
            {
                if(block.getColor().equals(color))
                { return Optional.of(block) ;
                }
            }

        }
        return Optional.empty();
    }


    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> foundblocks = new ArrayList<>();
        if (blocks != null) {

            foundblocks = findBlocksByMaterialRecursive(blocks, material);
        }
        return foundblocks;
    }


    @Override
    public int count() {
        if(blocks != null) {
            return ListOfAllStructureBlocks(blocks).size();
        }
        return 0 ;

    }

    public List<Block> ListOfAllStructureBlocks(List<Block> blocks) {
        List<Block> ListOfBlocks = new ArrayList<>() ;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                    ListOfBlocks.addAll(ListOfAllStructureBlocks(((CompositeBlock) block).getBlocks())) ;
            } else ListOfBlocks.add(block);


        }
        return ListOfBlocks;
    }



    public List<Block> findBlocksByMaterialRecursive(List<Block> blocks, String material) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                result.addAll(findBlocksByMaterialRecursive(((CompositeBlock) block).getBlocks(), material));
            } else {
                if (block.getMaterial().equals(material)) {
                    result.add(block);
                }
            }
        }return result;

    }
}