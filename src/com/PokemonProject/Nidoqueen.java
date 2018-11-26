package com.PokemonProject;

import ru.ifmo.se.pokemon.*;

public class Nidoqueen extends Nidorina{
    public Nidoqueen(String name){
        super(name); //need
        this.addType(Type.GROUND);
        setStats(90,92, 87, 75, 85, 76);

        Move move = new Thunder();

        this.addMove(move);
    }
}

class Thunder extends SpecialMove{
    /*
    Thunder deals damage and has a 30% chance of paralyzing the target.
     */
    private Effect effect;

    Thunder(){
        super(Type.ELECTRIC, 110, 70);
        effect = new Effect().chance(0.3);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (effect.success()){
            Effect.paralyze(p);
            System.out.println("Покемон парализован");
        }
    }

    protected String describe(){
        return "применяет способность Thunder";
    }
}