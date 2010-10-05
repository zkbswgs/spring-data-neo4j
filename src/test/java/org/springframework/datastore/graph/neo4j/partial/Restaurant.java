package org.springframework.datastore.graph.neo4j.partial;

import org.springframework.datastore.graph.api.GraphEntity;
import org.springframework.datastore.graph.api.GraphEntityProperty;

import javax.persistence.*;

/**
 * @author Michael Hunger
 * @since 27.09.2010
 */
@Entity
@GraphEntity(partial = true)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_gen")
    @TableGenerator(name = "id_gen", table = "SEQUENCE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "SEQ_GEN", allocationSize = 1)
    long id;
    String name;
    String zipCode;

    @GraphEntityProperty
    @Transient
    Cuisine cuisine;

}