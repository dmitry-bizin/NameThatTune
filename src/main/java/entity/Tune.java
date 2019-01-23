package entity;

import java.util.Objects;

public class Tune implements Identifiable {

    private int id;
    private String title;
    private String author;
    private int score;
    private int categoryId;

    public Tune(int id, String title, String author, int score, int categoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.score = score;
        this.categoryId = categoryId;
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

    public int getScore() {
        return score;
    }

    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "Tune{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", score=" + score +
                ", categoryId=" + categoryId +
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
        Tune tune = (Tune) o;
        return id == tune.id &&
                score == tune.score &&
                categoryId == tune.categoryId &&
                title.equals(tune.title) &&
                author.equals(tune.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, score, categoryId);
    }

}
