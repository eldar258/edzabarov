package ru.job4j.bomberman;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class ru.job4j.bomberman.
 *
 * @author edzabarov
 * @since 02.06.2018
 */
public class Game {
    private  ReentrantLock[][] board;
    private int height;
    private int width;
    public static final Game INSTANCE = new Game();

    private Game() {

    }

    public ReentrantLock[][] getBoard() {
        return board;
    }

    public void createBoard(int height, int width) {
        this.height = height;
        this.width = width;
        board = new ReentrantLock[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    public void go() {
        getRandomCells(5).forEach(el -> board[el.getPosH()][el.getPosW()].lock()); //5 blocks where can not walk

        Thread hero = new Thread(new Hero(getRandomCells(1).get(0)));
        Thread[] enemy = new Thread[3];
        for (int i = 0; i < enemy.length; i++) {
            enemy[i] = new Thread(new Enemy(getRandomCells(1).get(0)));
        }
        hero.start();
        for (Thread el : enemy) {
            el.start();
        }

        try {
            Thread.sleep(120000);
            hero.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean move(Cell source, Cell dist, int timeMc) {
        boolean result = false;
        try {
            result = board[dist.getPosH()][dist.getPosW()].tryLock(timeMc, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Checks whether cells are free or exist and returns free ones.
     * @param cells - All possible cells
     * @return return free ones
     */
    private List<Cell> checkCells(List<Cell> cells) {
        List<Cell> result = new ArrayList<>();
        for (Cell el : cells) {
            int i = el.getPosH();
            int j = el.getPosW();
            boolean next = i < 0 || i >= height || j < 0 || j >= width;
            if (!next && !board[i][j].isLocked()) {
                result.add(el);
            }
        }
        return result;
    }

    private boolean checkCell(Cell cell) {
        int i = cell.getPosH();
        int j = cell.getPosW();
        boolean next = i < 0 || i >= height || j < 0 || j >= width;
        return !next && !board[i][j].isLocked();
    }

    public Cell GetRandomCell(Cell cell, int step) {
        Cell result = null;
        List<Cell> cells = new ArrayList<>();
        int[] options = new int[2];
        options[0] = -1;
        options[1] = 1;

        for (int el : options) {
            cells.add(new Cell(cell.getPosH() + step * el, cell.getPosW()));
            cells.add(new Cell(cell.getPosH(), cell.getPosW() + step * el));
        }
        cells = checkCells(cells);

        if (!cells.isEmpty()) {
            result = cells.get((int) (Math.random() * cells.size()));
        }
        return result;
    }

    private List<Cell> getRandomCells(int count) {
        List<Cell> notLockedCells = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; i++) {
                if (!board[i][j].isLocked()) {
                    notLockedCells.add(new Cell(i, j));
                }
            }
        }
        List<Cell> result = new ArrayList<>();
        for (int i = 0; i < count && !notLockedCells.isEmpty(); i++) {
            int index = (int) (Math.random() * notLockedCells.size());
            result.add(notLockedCells.get(index));
            notLockedCells.remove(index);
        }
        return result;
    }

    private class Hero implements Runnable{
        private Cell posHero;
        private HeroMove[] moving;
        private int moveInto = -1;
        private final Object lock  = new Object();

        public Hero(Cell pos) {
            this.posHero = pos;
            board[posHero.getPosH()][posHero.getPosW()].lock();

            moving = new HeroMove[4];

            moving[0] = new HeroMove(new Cell(-1, 0));
            moving[1] = new HeroMove(new Cell(1, 0));
            moving[2] = new HeroMove(new Cell(0, -1));
            moving[3] = new HeroMove(new Cell(0, 1)); // up, down, left, right
        }

        public void setMoveInto(int moveInto) {
            this.moveInto = moveInto;
            lock.notifyAll();
        }

        @Override
        public void run() {
            while (true) {
                if (moveInto == -1) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            //System.out.println("GAME OVER");
                            return;
                        }
                    }
                } else {
                    moving[moveInto].moveHero(posHero, 1);
                    moveInto = -1;
                }
            }
        }
    }

    private class HeroMove {
        private Cell vector;

        public HeroMove(Cell vector) {
            this.vector = vector;
        }

        private boolean moveHero(Cell source, int step) {
            Cell dist = new Cell(source.getPosH() + vector.getPosH() * step, source.getPosW() + vector.getPosW() * step);
            return checkCell(dist) && move(source, dist, 0);
        }
    }
}
