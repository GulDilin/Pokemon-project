package com.PokemonProject;
import ru.ifmo.se.pokemon.*;

public class Battleground {

    public static void main(String[] args) {
        Battle b = new Battle();
        b.addFoe(new Nidoqueen("Tata"));
        b.addAlly(new Registeel("Gcosic"));
        b.addAlly(new Nidorina("Lola"));
        b.addAlly(new Carracosta("Korka"));
        b.addFoe(new NidoranF("Fufel"));
        b.addFoe(new Tirtouga("Dilin"));
        b.go();
    }
}
