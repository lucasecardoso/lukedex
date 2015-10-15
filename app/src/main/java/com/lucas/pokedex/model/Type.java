package com.lucas.pokedex.model;

/**
 * Created by Lucas on 5/10/2015.
 */
public class Type {

    private int id;
    private String typeName;

    public Type(int id) {
        this.id = id;
        this.typeName = processId();
    }

    public String getTypeName() {
        return typeName;
    }

    private String processId() {

        switch (id) {
            case 0:
                return "Grass";
            case 1:
                return "Water";
            case 2:
                return "Fire";
            case 3:
                return "Normal";
            case 4:
                return "Lightning";
            case 5:
                return "Flying";
            case 6:
                return "Ground";
            case 7:
                return "Psychic";
            case 8:
                return "Ghost";
            case 9:
                return "Fighting";
            case 10:
                return "Poison";
            case 11:
                return "Bug";
            case 12:
                return "Ice";
            case 13:
                return "Dragon";
            case 14:
                return "Dark";
            case 15:
                return "Steel";
            case 16:
                return "Fairy";
            case 17:
                return "Rock";
        }

        return "No type";
    }

}
