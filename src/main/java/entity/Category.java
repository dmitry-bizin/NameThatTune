package entity;

import java.util.Objects;

public class Category implements Identifiable {

    private int id;
    private String title;
    private int roundId;

    public Category(int id, String title, int roundId) {
        this.id = id;
        this.title = title;
        this.roundId = roundId;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRoundId() {
        return roundId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", roundId=" + roundId +
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
        Category category = (Category) o;
        return id == category.id &&
                roundId == category.roundId &&
                title.equals(category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, roundId);
    }

}
