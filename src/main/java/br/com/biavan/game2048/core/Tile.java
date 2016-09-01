package br.com.biavan.game2048.core;

public class Tile {
	private int value;

    public Tile(){
        this(0);
    }

    public Tile(int value){
        this.value = value;
    }


    public void setValue(int value){    
        this.value = value; 
    }

    public int getValue(){
        return value;
    }

    public boolean equals(Tile tile){
        return tile.getValue() == this.getValue();  
    }

    public void merge(Tile tile){
        this.setValue(value + tile.getValue());
    }

    public void clear(){
        this.setValue(0);
    }

    public String toString(){
        return (Integer.toString(this.getValue()));
    }
}
