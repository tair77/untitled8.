package kg.geektech.game.players;

public abstract class Hero extends GameEntity implements HavingSuperAbility{
    private superAbility superAbility;

    public Hero(int health, int damage,  superAbility superAbility) {
        super(health, damage);
        this.superAbility = superAbility;
    }
}