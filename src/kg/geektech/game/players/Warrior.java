package kg.geektech.game.players;



import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage, kg.geektech.game.players.superAbility superAbility) {
        super(health, damage,  superAbility.CRITICALDAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random =  new Random();
        if (boss.getHealth() > 0) {
            int coeff = random.nextInt(4) + 2;
            boss.setHealth(boss.getHealth() - this.getDamage() * coeff);
            System.out.println("WARRIOR ДАЛ АЛЛЯКИ КОДЖИ БОССУ " + this.getDamage() * coeff);
        }

    }
}