package ru.job4j.bomberman;

/**
 * Class ru.job4j.bomberman.
 *
 * @author edzabarov
 * @since 12.06.2018
 */
public class Enemy implements Runnable {
    private Cell pos;

    public Enemy(Cell position) {
        pos = position;
        Game.INSTANCE.getBoard()[pos.getPosH()][pos.getPosW()].lock();
    }

    @Override
    public void run() {
        Game  game = Game.INSTANCE;
        while (true) {
            Cell dist;
            do {
                dist = game.GetRandomCell(pos, 1);
            } while (game.move(pos, dist, 5000));
            game.getBoard()[pos.getPosH()][pos.getPosW()].unlock();
            pos = dist;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //System.out.println("GAME OVER");
                return;
            }
        }
    }
}
