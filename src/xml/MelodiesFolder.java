package xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Dmitriy on 22.01.2017.
 */
@XmlRootElement
public class MelodiesFolder implements Serializable {
    private String folder;

    public MelodiesFolder() {

    }

    public MelodiesFolder(String folder) {

        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
