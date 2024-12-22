package Enums;

public enum Faculty {
    SITE, BS, ISE, SAM;
    public String getFullName() {
        return switch (this) {
            case SITE -> "School of Information Technologies and Engineering";
            case BS -> "Business School";
            case ISE -> "International School of Economics";
            case SAM -> "School of Applied Mathematics";
        };
    }
}