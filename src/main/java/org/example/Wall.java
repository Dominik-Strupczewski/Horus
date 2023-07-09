package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (blocks != null) {
            List<Block> allblocks = listOfAllStructureBlocks(blocks);
            Block findBlock = allblocks.stream()
                    .filter((block -> !(block instanceof CompositeBlock)))
                    .filter(block -> block.getColor().equals(color))
                    .findFirst().get();
            return Optional.of(findBlock);
        }
    return Optional.empty();
    }




    @Override
    public List<Block> findBlocksByMaterial(String material){
        if(blocks != null) {
            List<Block> allblocks = listOfAllStructureBlocks(blocks);
            return allblocks.stream()
                    .filter((block -> !(block instanceof CompositeBlock)))
                    .filter(block -> block.getMaterial().equals(material))
                    .collect(Collectors.toList());

        }
        return new ArrayList<>();
    }


    @Override
    public int count() {
        if(blocks != null) {
            return listOfAllStructureBlocks(blocks).size();
        }
        return 0 ;

    }


    public List<Block> listOfAllStructureBlocks(List<Block> blocks) {
        return blocks.stream()
                .flatMap(block -> {
                    if (block instanceof CompositeBlock) {
                        List<Block> subBlocks = listOfAllStructureBlocks(((CompositeBlock) block).getBlocks());
                        subBlocks.add(block); //dodaje blok kompozytowy, zeby również został uwzględniony w liście bloków struktury
                        return subBlocks.stream();
                    } else {
                        return Stream.of(block);
                    }
                })
                .collect(Collectors.toList());
    }





    }
