package it_academy.links;

public enum Links {
    HOMEPAGE("https://www.onliner.by/"),
    CATALOG("https://catalog.onliner.by/");

    private final String link;

    Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}