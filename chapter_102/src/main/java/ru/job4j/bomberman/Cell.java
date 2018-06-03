package ru.job4j.bomberman;

/**
 * Class ru.job4j.bomberman.
 *
 * @author edzabarov
 * @since 03.06.2018
 */
public class Cell {
    private int posH;
    private int posW;

    public Cell(int posH, int posW) {
        this.posH = posH;
        this.posW = posW;
    }

    public int getPosH() {
        return posH;
    }

    public int getPosW() {
        return posW;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (posH != cell.posH) return false;
        return posW == cell.posW;

    }

    @Override
    public int hashCode() {
        int result = posH;
        result = 31 * result + posW;
        return result;
    }
}

