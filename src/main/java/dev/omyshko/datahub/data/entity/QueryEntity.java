package dev.omyshko.datahub.data.entity;

import jakarta.persistence.*;
import lombok.Data;

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
