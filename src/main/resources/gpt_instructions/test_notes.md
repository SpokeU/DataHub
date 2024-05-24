"""
ConnectionEntity.java
package com.example.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "connections")
@Data
public class ConnectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "type")
    private String type;

    @Type(type = "jsonb")
    @Column(name = "details", columnDefinition = "jsonb")
    private Map<String, Object> details;

    // Assuming a one-to-many relationship with Queries
    @OneToMany(mappedBy = "connection", fetch = FetchType.LAZY)
    private List<QueryEntity> queries;
}
"""

QueryEntity.java
"""
package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "queries")
@Data
public class QueryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "query_string")
    private String queryString;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "connection_id")
    private ConnectionEntity connection;
}
"""