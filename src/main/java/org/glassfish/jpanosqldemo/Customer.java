package org.glassfish.jpanosqldemo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 * Customer, stored as a root JSON object.
 */
@Entity
@NoSql(dataFormat = DataFormatType.MAPPED)
public class Customer implements Serializable {

    @Id // The id uses the generated OID (UUID) from Mongo.
    @GeneratedValue
    @Field(name = "_id")
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}