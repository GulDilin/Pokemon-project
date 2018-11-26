package com.PokemonProject;

import ru.ifmo.se.pokemon.*;

public class NidoranF extends Pokemon {
    public NidoranF(String name){
       super(name, 9); //need lvl 9
       setStats(55, 47, 52, 40, 40, 41);
       setType(Type.POISON );

       Move moves[] = new Move[2];
       moves[0] = new DoubleKick();
       moves[1] = new IceBeam();

       setMove(moves);
    }
}

class DoubleKick extends PhysicalMove{
    public DoubleKick(){
        /*
    Double Kick deals damage and will strike twice (with 30 base power each time).
    Each strike of Double Kick is treated like a separate attack:
         */
        super(Type.FIGHTING, 30, 100, 0, 2);
    }

    protected String describe(){
        return "применяет способность Double Kick";
    }
}

class IceBeam extends SpecialMove{
    private Effect effect;

    public IceBeam(){
        /*
        Ice Beam deals damage and has a 10% chance of freezing the target.
         */
        super(Type.ICE, 90, 100);
        effect = new Effect().chance(0.1D);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (effect.success()) {
            Effect.freeze(p);
        }
    }

    protected String describe(){
        return "применяет способность Ice Beam";
    }
}
