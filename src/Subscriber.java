public enum Subscriber {
    ACTIVE("Subscription is Active."),
    EXPIRED("Subscription is expired."),
    NONEXISTING("No current or prior subscription found.");

    private final String description;
    Subscriber(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
