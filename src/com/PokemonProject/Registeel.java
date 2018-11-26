package com.PokemonProject;
import ru.ifmo.se.pokemon.*;

public class Registeel extends Pokemon{
    public Registeel(String name){
        super(name, 37);
        this.setStats(80, 75, 150, 75, 150, 50);
        setType(Type.STEEL);

        Move moves[] = new Move[4];
        moves[0] = new RockSlide();
        moves[1] = new Stomp();
        moves[2] = new ShadowClaw();
        moves[3] = new IronDefense();

        setMove(moves);
    }

}

class RockSlide extends PhysicalMove {
    /*
    Rock Slide deals damage and has a 30% chance of causing the target to flinch (if the target has not yet moved).
     */
    private Effect effect;

    public RockSlide() {
        super(Type.STEEL, 75, 90);
        effect = new Effect().chance(0.3D);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (effect.success()) {
            Effect.flinch(p);
            System.out.println("Покемон в страхе");
        }
    }

    protected String describe() {
        return "применяет способность Rock Slide";
    }
}

class Stomp extends PhysicalMove{
    /*
    Stomp deals damage and has a 30% chance of causing the target to flinch (if the target has not yet moved).
     */
    private Effect effect;

    public Stomp(){
        super(Type.NORMAL, 65, 100);
        effect = new Effect().chance(0.3D);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (effect.success()) {
            Effect.flinch(p);
            System.out.println("Покемон в страхе");
        }
    }

    protected String describe() {
        return "применяет способность Stomp";
    }
}

class ShadowClaw extends PhysicalMove {
    /*
    Shadow Claw deals damage and has an increased critical hit ratio (1⁄8 instead of 1⁄16).
     */
    public ShadowClaw() {
        super(Type.GHOST, 70, 100);
    }

    @Override
    protected double calcCriticalHit(Pokemon p, Pokemon p1) {
        if ((p.getStat(Stat.SPEED)/256.0D) > Math.random()){
            System.out.println("Критический удар!");
            return 2.0D;
        } else {
            return 1.0D;
        }
    }

    protected String describe(){
        return "применяет способность ShadowClaw (Шанс критического удара увеличен вдвое)";
    }
}

class IronDefense extends StatusMove{
    /*
    Iron Defense raises the user's Defense by two stages.

Stats can be raised to a maximum of +6 stages each.
     */
    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.DEFENSE, 2);
    }

     protected String describe() {
         return "применяет способность Iron Defense";
     }
}