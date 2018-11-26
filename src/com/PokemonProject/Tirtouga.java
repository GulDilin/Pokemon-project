package com.PokemonProject;

import ru.ifmo.se.pokemon.*;

public class Tirtouga extends Pokemon {
    public Tirtouga(String name) {
        super(name, 50);
        setStats(54, 78, 103, 53, 45, 22);
        setType(Type.WATER, Type.ROCK);

        Move moves[] = new Move[3];
        moves[0] = new RockSlide();
        moves[1] = new Blizzard();
        moves[2] = new HydroPump();

        setMove(moves);
    }
}

class Blizzard extends SpecialMove{
    /*
    Blizzard deals damage and has a 10% chance of freezing the target.
    It will hit both opponents in a double battle or adjacent opponents in a triple battle.
     */
    private Effect effect;

    Blizzard() {
        super(Type.ICE, 110, 70);
        effect = new Effect().chance(0.1D);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (effect.success()) {
            Effect.freeze(p);
            System.out.println("Покемон заморожен");
        }
    }

    protected String describe() {
        return "применяет способность Blizzard";
    }
}

class HydroPump extends SpecialMove {
    /*
    Hydro Pump deals damage with no additional effect.
     */
    HydroPump(){
        super(Type.WATER, 110, 80);
    }

    @Override
    protected  String describe() {
        return "применяет способность Hydro Pump";
    }
}
