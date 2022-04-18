public class Zombie extends Character implements Actions {
    public Zombie(int x) {
        this.dalnost = 5;
        this.zashita = 5;
        this.uron = (int) (2 + Math.random() * 3);
        this.zdovovie = 8;
        this.skorost = 4;
        this.spetsVozmoznost = false;
        this.enemy = null;
        this.coordinata = x;
    }

    @Override
    public void nanositUron() {
        if (Math.abs(coordinata - enemy.coordinata) <= dalnost) {
            System.out.println("Зомби наносит " + uron + " ед. урона.");
            enemy.zashishatsya(uron);
        } else {
            System.out.println("Зомби не может нанести удар. Противник далеко");
        }
    }

    @Override
    public void zashishatsya(int uron) {
        if (zashita - uron > 0) {
            zashita -= uron;
            System.out.println("У зомби защита уменьшилась на " + uron + " ед.");
        } else {
            int x = uron - zashita;
            zashita = 0;
            zdovovie -= x;
            System.out.println("У зобмби защита = 0" + " кол-во жизней уменьшено на " + x + " ед.");

        }
    }

    public int getScorost(){
        return skorost;
    }

    @Override
    public void peredvizenie(boolean direction, int x) {
        if (direction) {
            if (coordinata + x > 10) {
                System.out.println("Зомби походил на " + x + "кл. вправо");
                System.out.println("Зомби выходит за правую границу поля. Действие выполнено ограничено");
                coordinata = 10;
            } else {
                if (x > skorost) {
                    System.out.println("Зомби походил на " + x + "кл. вправо");
                    System.out.println("Зомби не может так ходить. Действие выполнено ограничено");
                    coordinata += skorost;
                } else {
                    System.out.println("Зомби походил на " + x + "кл. вправо");
                    coordinata += x;
                }
            }
            if (coordinata==enemy.coordinata){
                System.out.println("Зомби пришел на клетку противника, так нельзя, он встал рядом");
                coordinata-=1;
            }
        } else {
            if (coordinata - x < 0) {
                System.out.println("Зомби походил на " + x + "кл. влево");
                System.out.println("Зомби выходит за левую границу поля. Действие выполнено ограничено");
                coordinata = 1;
            } else {
                if (x > skorost) {
                    System.out.println("Зомби походил на " + x + "кл. влево");
                    System.out.println("Зомби не может так ходить. Действие выполнено ограничено");
                    coordinata -= skorost;
                } else {
                    System.out.println("Зомби походил на " + x + "кл. влево");
                    coordinata -= x;
                }
            }
            if (coordinata==enemy.coordinata){
                System.out.println("Зомби пришел на клетку противника, так нельзя, он встал рядом");
                coordinata+=1;
            }
        }
    }

    @Override
    public void opredelitVraga(Character enemy) {
        this.enemy = enemy;
        System.out.println("Зомби определил врага");
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

    @Override
    public boolean umirat() {
        info();
        if (zdovovie <= 0) {
            System.out.println("Зомби умирает. Противник выиграл");
            return true;
        }
        return false;
    }

    @Override
    public void superSposobnost() {
        zdovovie += 1;
        System.out.println("Суперспособность активирована. Защита у Зомби +1");
    }

    @Override
    public void info() {
        System.out.println();
        System.out.println("Информация о Зомби:");
//        System.out.println("Кол-во атаки - " + uron);
//        System.out.println("Дальность атаки - " + dalnost);
//        System.out.println("Защита - " + zashita);
//        System.out.println("Скорость - " + skorost);
        System.out.println("Здоровье - " + zdovovie);
        System.out.println("Координата - " + coordinata);
        if (enemy == null) {
            System.out.println("Враг - нет");
        }
    }
}
