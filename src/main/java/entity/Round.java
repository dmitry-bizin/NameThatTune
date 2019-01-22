package entity;

import java.util.Objects;

public class Round implements Identifiable {

    private int id;
    private String title;

    public Round(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", title='" + title + '\'' +
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
        Round round = (Round) o;
        return id == round.id &&
                title.equals(round.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

}
