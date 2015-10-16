package com.lucas.pokedex.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lucas on 5/10/2015.
 */
public class Pokemon implements Serializable {

    private int id;
    private int gen;
    private int nationalDexNumber;
    private String name;
    private Type type1;
    private Type type2;
    private String pokedexText;
    private int height;
    private int weight;

    public Pokemon() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public int getNationalDexNumber() {
        return nationalDexNumber;
    }

    public void setNationalDexNumber(int nationalDexNumber) {
        this.nationalDexNumber = nationalDexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public String getPokedexText() {
        return pokedexText;
    }

    public void setPokedexText(String pokedexText) {
        this.pokedexText = pokedexText;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
