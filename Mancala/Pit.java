public class Pit {
    private int rocks;
    private boolean isStorage;

    public Pit( boolean isStorage) {
        this.rocks = rocks;
        this.isStorage = isStorage;
    }

    public int getRocks() {
        return rocks;
    }
    public void addRocks(int rocks) {
        this.rocks += rocks;
    }
    public void removeRocks(int rocks) {
        this.rocks -= rocks;
    }
}
