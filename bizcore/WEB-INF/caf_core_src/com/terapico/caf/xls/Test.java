package com.terapico.caf.xls;


public class Test {
    public static void main(String[] args) throws Exception {

        Block bl = new Block();

        bl.setPage("first1");
        bl.setTop(7);
        bl.setBottom(88);
        bl.setLeft(1);
        bl.setRight(1);
        bl.setValue("中文");
        bl.withRedBgColor();

        try (XlsWriter tXlsWriter = new XlsWriter(System.out) ){
            tXlsWriter.write(bl);
        }
    }
}
