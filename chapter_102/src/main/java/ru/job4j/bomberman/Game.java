package ru.job4j.bomberman;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
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
    private final ReentrantLock[][] board;
    private int height;
    private int width;

    public Game(int height, int width) {
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
        Thread hero = new Thread(new Hero());
        hero.start();
        try {
            Thread.sleep(120000);
            hero.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean move(Cell source, Cell dist) {
        boolean result = false;
        try {
            result = board[dist.getPosH()][dist.getPosW()].tryLock(500, TimeUnit.MILLISECONDS);
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

    private Cell GetRandomCell(Cell cell, int step) {
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

    private class Hero implements Runnable{
        private Cell posHero;

        @Override
        public void run() {
            posHero = new Cell(0, 0);
            while (true) {
                Cell dist;
                do {
                    dist = GetRandomCell(posHero, 1);
                } while (move(posHero, dist));
                board[posHero.getPosH()][posHero.getPosW()].unlock();
                posHero = dist;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //System.out.println("GAME OVER");
                    return;
                }
            }
        }
    }
}
