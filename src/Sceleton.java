import java.util.ArrayList;
import java.util.List;

public class Sceleton extends Character {
    public Sceleton(int x) {
        this.dalnost = 5;
        this.zashita = 4;
        this.uron = (int) (1 + Math.random() * 3);
        this.zdovovie = 6;
        this.skorost = 4;
        // может быть меньшн
        this.spetsVozmoznost = false;
        this.enemy = null;
        this.coordinata = x;
    }

    @Override
    public void nanositUron() {
        if (Math.abs(coordinata - enemy.coordinata) <= dalnost) {
            System.out.println("Скелет наносит " + uron + " ед. урона.");
            enemy.zashishatsya(uron);
        } else {
            System.out.println("Скелет не может нанести удар. Противник далеко");
        }
    }

    @Override
    public void zashishatsya(int uron) {
        if (zashita - uron > 0) {
            zashita -= uron;
            System.out.println("У скелета защита уменьшилась на " + uron + " ед.");
        } else {
            int x = uron - zashita;
            zashita = 0;
            zdovovie -= x;
            System.out.println("У скелета защита = 0" + " кол-во жизней уменьшено на " + x + " ед.");
        }

    }

    public int getScorost(){
        return skorost;
    }

    @Override
    public void peredvizenie(boolean direction, int x) {
        if (direction) {
            if (coordinata + x > 10) {
                System.out.println("Скелет походил на " + x + "кл. вправо");
                System.out.println("Скелет выходит за правую границу поля. Действие выполнено ограничено");
                coordinata = 10;
            } else {
                if (x > skorost) {
                    System.out.println("Скелет походил на " + x + "кл. вправо");
                    System.out.println("Скелет не может так ходить. Действие выполнено ограничено");
                    coordinata += skorost;
                } else {
                    System.out.println("Скелет походил на " + x + "кл. вправо");
                    coordinata += x;
                }
            }
            if (coordinata==enemy.coordinata){
                System.out.println("Скелет пришел на клетку противника, так нельзя, он встал рядом");
                coordinata-=1;
            }
        } else {
            if (coordinata - x < 0) {
                System.out.println("Скелет походил на " + x + "кл. влево");
                System.out.println("Скелет выходит за левую границу поля. Действие выполнено ограничено");
                coordinata = 1;
            } else {
                if (x > skorost) {
                    System.out.println("Скелет походил на " + x + "кл. влево");
                    System.out.println("Скелет не может так ходить. Действие выполнено ограничено");
                    coordinata -= skorost;
                } else {
                    System.out.println("Скелет походил на " + x + "кл. влево");
                    coordinata -= x;
                }
            }
            if (coordinata==enemy.coordinata){
                System.out.println("Скелет пришел на клетку противника, так нельзя, он встал рядом");
                coordinata+=1;
            }
        }
    }

    @Override
    public void opredelitVraga(Character enemy) {
        this.enemy = enemy;
        System.out.println("Скелет определил врага");
    }

    @Override
    public boolean mestoPolozenieVraga(){
        if (Math.abs(coordinata - enemy.coordinata)<=dalnost){
            return true;
        }
        else return false;
    }

    @Override
    public int getCoordinata() {
        return coordinata;
    }

    @Override
    public int getEnemyCoordinata() {
        return enemy.coordinata;
    }


    //   @Override
//    public Character opredelitVraga(BattleField field) {
//        int nearest = 100;
//        Character vrag = null;
//        for (List<Character> characterArrayList: field.charactersList) {
//            for (Character character:characterArrayList){
//                if (Math.abs(coordinata- character.coordinata)<nearest){
//                    nearest=Math.abs(coordinata- character.coordinata);
//                    vrag= character;
//                }
//            }
//        }
//        return vrag;
//
//    }

    @Override
    public boolean umirat() {
        info();
        if (zdovovie <= 0) {
            System.out.println("Скелет умирает. Противник выиграл");
            return true;
        }
        return false;
    }

    @Override
    public void superSposobnost() {
        zdovovie += 1;
        System.out.println("Суперспособность активирована. Здоровье у Скелета +1");
    }

    @Override
    public void info(){
        System.out.println();
        System.out.println("Информация о скелете:");
//        System.out.println("Кол-во атаки - " + uron);
//        System.out.println("Дальность атаки - " + dalnost);
//        System.out.println("Скорость - " + skorost);
//        System.out.println("Защита - " + zashita);
        System.out.println("Здоровье - " + zdovovie);
        System.out.println("Координата - " + coordinata);
        if (enemy == null){
            System.out.println("Враг - нет");
        }
        else {
            System.out.println("Враг определен");
        }
        System.out.println();
    }

}
