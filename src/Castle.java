import java.util.Random;

public class Castle {
    public static void main(String[] args) throws InterruptedException {
        new Castle().action();

    }

    void action() throws InterruptedException {
        Sceleton sceleton = new Sceleton(0);
        Zombie zombie = new Zombie(10);
        sceleton.info();
        zombie.info();

        sceleton.opredelitVraga(zombie);
        zombie.opredelitVraga(sceleton);

        Character player;
        while (true) {
            int y = (int) (1 + Math.random() * 50);
            if (y < 26) {
                player = sceleton;
            } else {
                player = zombie;
            }


            if (player.zdovovie < 3) {
                player.superSposobnost();
            } else if (player.mestoPolozenieVraga()) {
                y = (int) (1 + Math.random() * 2);
                if (y == 1) {
                    player.nanositUron();
                } else {
                    boolean direction;
                    if ((int) (1 + Math.random() * 2) == 1) {
                        direction = true;
                    } else {
                        direction = false;
                    }
                    player.peredvizenie(direction, (int) (1 + Math.random() * (player.getScorost() + 1)));
                }

            }else {
                if (player.getCoordinata() - player.getEnemyCoordinata()<0){
                    player.peredvizenie(true, (int) (1 + Math.random() * (player.getScorost() + 1)));
                }
                else {
                    player.peredvizenie(false, (int) (1 + Math.random() * (player.getScorost() + 1)));
                }
            }

//            y = (int) (1 + Math.random() * 3);
//            if (y == 1) {
//                player.nanositUron();
//            }
//            else if (y==2){
//                player.superSposobnost();
//            }
//            else {
//                boolean direction;
//                if ((int) (1 + Math.random() * 2) == 1) {
//                    direction = true;
//                } else {
//                    direction = false;
//                }
//                player.peredvizenie(direction, (int) (1 + Math.random() * (player.getScorost() + 1)));
//            }


            Thread.sleep(3000);

            if (sceleton.umirat()) {
                break;
            }
            if (zombie.umirat()) {
                break;
            }
        }


    }
}
