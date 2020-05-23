package GameOfLife;

public class Cell {

    private boolean alive;
    private boolean nextLife;

    public Cell() {

    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alives) {
        this.alive = alives;
    }

    public boolean nextLife() {
        return nextLife;
    }

    public void setNextLife(boolean nextLifes) {
        this.nextLife = nextLifes;
    }

    public void update() {
        this.alive = this.nextLife;
    }

}
