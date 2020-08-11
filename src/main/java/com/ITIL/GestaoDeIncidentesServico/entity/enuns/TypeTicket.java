package com.ITIL.GestaoDeIncidentesServico.entity.enuns;

public enum TypeTicket {

    OPEN(1,"OPEN"),
    TRASNFER(2,"TRASNFER"),
    MESSAGE(3,"MESSAGE"),
    CLOSE(3,"CLOSE");

    private int id;
    private String description;

    TypeTicket(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }



    public String getDescription() {
        return description;
    }

    public static TypeTicket toEnum(Integer id){

        if(id == null) return null;

        for(TypeTicket x : TypeTicket.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw  new IllegalArgumentException("id inválido" + id);
    }

}

