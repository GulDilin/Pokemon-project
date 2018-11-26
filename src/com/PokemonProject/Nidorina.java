package com.PokemonProject;

import  ru.ifmo.se.pokemon.*;

public class Nidorina extends NidoranF{
    public Nidorina(String name){
        super(name); // need lvl 23
        setStats(70, 62, 67, 55, 55, 56);

        Move move = new Bite();

        this.addMove(move);
    }
}

class Bite extends PhysicalMove{
    /*
    Bite deals damage and has a 30% chance of causing the target to flinch (if the target has not yet moved).
     */
    private Effect effect;

    public Bite(){
        super(Type.DARK, 60, 100);
        effect = new Effect().chance(0.3D);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
       if (effect.success()){
           Effect.flinch(p);
           System.out.println("Покемон в страхе");
       }
    }

    protected String describe(){
        return "применяет способность Bite";
    }
}
