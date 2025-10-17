public enum MemberType {
    STANDARD("Standard"),
    GOLD("Gold"),
    PLATINA("Platina");

    public String getDescription() {
        return description;
    }

    private final String description;
    MemberType(String description) {
        this.description = description;
    }
}
