public class Pit {
    private int rocks;
    private boolean isStorage;

    public Pit(int rocks, boolean isStorage) {
        this.rocks = rocks;
        this.isStorage = isStorage;
    }

    public int getRocks() {
        return rocks;
    }
    public void addRock(int rocks) {
        this.rocks += rocks;
    }
    public void removeRocks(int rocks) {
        this.rocks -= rocks;
    }

    public void clearPit() {
        this.rocks = 0;
    }

    public void setRocks(int rocks){
        this.rocks=rocks;
    }

    public boolean isStorage() {
        return isStorage;
    }
}