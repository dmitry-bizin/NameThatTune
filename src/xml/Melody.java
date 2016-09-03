package xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Dmitriy on 03.09.2016.
 */
@XmlRootElement
public class Melody implements Serializable {
    private String title;
    private String author;

    public Melody() {
    }

    public Melody(String title, String author) {
        this.setTitle(title);
        this.setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
