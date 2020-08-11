package com.ITIL.GestaoDeIncidentesServico.entity.enuns;

public enum Level {

    LEVELONE(1,"LEVELONE"),
    LEVELTWO(2,"LEVELTWO"),
    LEVELTHREE(3,"LEVELTHREE"),
    NONE(3,"NONE");

    private int id;
    private String description;

    Level(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }



    public String getDescription() {
        return description;
    }

    public static Level toEnum(Integer id){

        if(id == null) return null;

        for(Level x : Level.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw  new IllegalArgumentException("id inválido" + id);
    }

}

