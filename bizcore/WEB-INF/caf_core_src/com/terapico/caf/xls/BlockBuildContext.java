package com.terapico.caf.xls;

/**
 * the current block, we will generate other blocks based on this block.
 */
public class BlockBuildContext {
    private String page;
    private int x;
    private int y;

    public BlockBuildContext(String pPage, int pX, int pY) {
        page = pPage;
        x = pX;
        y = pY;
    }

    public BlockBuildContext(String pPage){
        page = pPage;
    }

    public BlockBuildContext next() {
        return new BlockBuildContext(this.page, this.x + 1, this.y);
    }

    public BlockBuildContext newLine() {
        return new BlockBuildContext(this.page, 0, this.y + 1);
    }


    public String getPage() {
        return page;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Block toBlock(Object value) {
        return new Block(this, value);
    }
}
