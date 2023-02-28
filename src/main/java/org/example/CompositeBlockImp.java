package org.example;

import java.util.List;

public class CompositeBlockImp implements CompositeBlock {
    List<Block> blocks;

    public CompositeBlockImp(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }
}
