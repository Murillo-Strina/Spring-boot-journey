package io.github.murillo_strina.libraryapi.model;

public enum BookGenre {
    FICTION("Fiction"), 
    NON_FICTION("Non-Fiction"), 
    FANTASY("Fantasy"), 
    SCIENCE_FICTION("Science Fiction"), 
    ROMANCE("Romance"), 
    MYSTERY("Mystery"), 
    THRILLER("Thriller"), 
    HORROR("Horror"), 
    HISTORY("History"), 
    BIOGRAPHY("Biography"), 
    SELF_HELP("Self-Help"), 
    CHILDREN("Children"), 
    DRAMA("Drama"), 
    POETRY("Poetry"), 
    ADVENTURE("Adventure");

    private final String displayName;

    BookGenre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
