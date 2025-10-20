package MemberPackage;

public enum MemberType {
    STANDARD("Standard"),
    GULD("Guld"),
    PLATINA("Platina");

    public String getDescription() {
        return description;
    }

    private final String description;
    MemberType(String description) {
        this.description = description;
    }
}
