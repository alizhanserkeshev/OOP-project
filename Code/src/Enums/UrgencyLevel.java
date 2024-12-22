package Enums;

public enum UrgencyLevel{
    HIGH(3), MEDIUM(2), LOW(1);

    private final int level;

    private UrgencyLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}