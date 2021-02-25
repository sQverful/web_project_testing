package epam.testing_app.database.entity;

import java.io.Serializable;

/**
 * Root of all entities which have identifier field.
 * @author V.Dorosh
 */
public class Entity implements Serializable {

    private static final long serialVersionUID = -413998151009549596L;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
