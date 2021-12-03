package kg.geektech.game.players;
import java.util.Random;
public class RPG_game {



    public static void startGame() {
        Random random = new Random();
        Boss boss = new Boss(750, 50);
        Warrior warrior = new Warrior(270, 30,superAbility.CRITICALDAMAGE);
        Magic magic = new Magic(250, 20, 5);
        kg.geektech.game.players.Berserk berserk = new kg.geektech.game.players.Berserk (240, 20, 5);
        Hero[] heroes;
        heroes = new Hero[]{warrior, magic, berserk};
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);

        }
    }


    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesSuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0)
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());

        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++)
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());


                }

            }
    }

    private static void heroesSuperAbilities(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }

        }
    }





    private static boolean isGameFinished (Boss boss, Hero[]heroes){
        if (boss.getDamage() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;

            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }


    private static void printStatistics (Boss boss, Hero[]heroes){
        System.out.println("-----------------");
        System.out.println("Boss Health:" + boss.getHealth() + " (" + boss.getDamage() + ")");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " Health:" + heroes[i].getHealth() + " (" + heroes[i].getDamage() + ")");
        }
        System.out.println("-----------------");

    }

}

