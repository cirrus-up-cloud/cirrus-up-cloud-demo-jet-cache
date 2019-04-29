package cloud.cirrusup.model;

import java.io.Serializable;

public class Book implements Serializable{

    /**
     *  This is the Serializable class
     */
    private static final long serialVersionUID = 4759133328093041L;


    private final String id;
    private final String title;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
