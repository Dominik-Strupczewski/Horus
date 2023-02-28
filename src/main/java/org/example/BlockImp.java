package org.example;

public class BlockImp implements Block{
    String color ;
    String material ;

    public BlockImp(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color ;

    }

    @Override
    public String getMaterial() {
        return material ;
    }
}
