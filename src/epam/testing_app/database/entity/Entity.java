package epam.testing_app.database.entity;

import java.io.Serializable;

/**
 * Root of all entities which have identifier field.
 *
 */
public class Entity implements Serializable {

    private static final long serialVersionUID = -413998151009549596L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
