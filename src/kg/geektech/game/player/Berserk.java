package kg.geektech.game.players;


public class Berserk extends Hero {
    private int damageAbsorbed;
    public Berserk(int health, int damage, int damageAbsorbed) {
        super(health, damage, superAbility.BUMERANG);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length ; i++) {
            if(this.getHealth() > 0 ) {
                damageAbsorbed = boss.getDamage() * 3/5;
                boss.setHealth(boss.getHealth() - this.getDamage() - damageAbsorbed);
                System.out.println("Berserk absorbed following damage and reflected it: " + damageAbsorbed);
                break;





            }

        }


    }


}