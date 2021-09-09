package com.doublechaintech.retailscm.utils;

public class CreationScene {
    protected String name;

    private CreationScene(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CreationScene of(String name){
        CreationScene cs = new CreationScene();
        cs.setName(name);
        return cs;
    }
}




















