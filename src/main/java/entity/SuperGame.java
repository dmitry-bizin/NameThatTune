package entity;

import java.util.Objects;

public class SuperGame implements Identifiable {

    private int id;
    private String title;
    private String author;

    public SuperGame(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "SuperGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SuperGame superGame = (SuperGame) o;
        return id == superGame.id &&
                title.equals(superGame.title) &&
                author.equals(superGame.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }

}
