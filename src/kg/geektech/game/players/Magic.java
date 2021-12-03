package kg.geektech.game.players;

public class Magic extends Hero {
    private int boostedDamage;

    public Magic(int health, int damage, int boostedDamage) {
        super(health, damage, superAbility.BOOST);
        this.boostedDamage = boostedDamage;
    }

    public int getBoostedDamage() {
        return boostedDamage;
    }

    public void setBoostedDamage(int boostedDamage) {
        this.boostedDamage = boostedDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int damageBoostedTimes = 0;
        for (int i = 0; i < heroes.length; i++) {

            if (heroes[i].getHealth() > 0 && this != heroes[i]) {
                if (damageBoostedTimes == 2) {
                    heroes[i].setDamage(heroes[i].getDamage() + this.boostedDamage);
                    damageBoostedTimes++;
                } else {
                    heroes[i].setDamage(heroes[i].getDamage());

                }
            }

        }

    }
}
