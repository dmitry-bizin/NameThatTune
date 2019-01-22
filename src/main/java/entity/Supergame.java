package entity;

import java.util.Objects;

public class Supergame implements Identifiable {

    private int id;
    private String title;
    private String author;

    public Supergame(int id, String title, String author) {
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
        return "Supergame{" +
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
        Supergame supergame = (Supergame) o;
        return id == supergame.id &&
                title.equals(supergame.title) &&
                author.equals(supergame.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }

}
