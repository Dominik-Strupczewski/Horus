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
            List<Block> allBlocks ;
            allBlocks = listOfAllStructureBlocks(blocks);
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
        List<Block> allblocks ;
        allblocks = listOfAllStructureBlocks(blocks);
        if (blocks != null) {
                for(Block block : allblocks)
                {
                    if(block.getMaterial().equals(material)){
                        foundblocks.add(block) ;
                    }
                }

        }
        return foundblocks;
    }


    @Override
    public int count() {
        if(blocks != null) {
            return listOfAllStructureBlocks(blocks).size();
        }
        return 0 ;

    }

    public List<Block> listOfAllStructureBlocks(List<Block> blocks) {
        List<Block> ListOfBlocks = new ArrayList<>() ;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                    ListOfBlocks.addAll(listOfAllStructureBlocks(((CompositeBlock) block).getBlocks())) ;
            } else ListOfBlocks.add(block);


        }
        return ListOfBlocks;
    }





    }
