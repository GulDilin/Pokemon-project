package com.PokemonProject;

import ru.ifmo.se.pokemon.*;

public class Carracosta extends Tirtouga {
    public Carracosta(String name){
        super(name);
        //((Pokemon)Pokemon(name, 60));
        setStats(74,108, 133, 83, 65, 32);

        Move move = new FocusBlast();

        this.addMove(move);
    }
}

class FocusBlast extends SpecialMove {
    /*
    Focus Blast deals damage and has a
    10% chance of lowering the target's Special Defense by one stage.
     */
    private  Effect effect;

    FocusBlast(){
        super(Type.FIGHTING, 120, 70);
        effect = new Effect().chance(0.1D);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (effect.success()){
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
            System.out.println("Специальная защита уменьшена на пункт");
        }
    }

    protected String describe(){
        return "применяет способность Focus Blast";
    }
}