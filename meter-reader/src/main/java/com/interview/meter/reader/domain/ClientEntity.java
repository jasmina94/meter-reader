package com.interview.meter.reader.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Client")
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "bigint", unique = true, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "RefAddress", columnDefinition = "bigint", nullable = false)
    private AddressEntity addressEntity;

    @Column(name = "Firstname", nullable = false, length = 100)
    private String firstName;

    @Column(name = "Lastname", nullable = false, length = 100)
    private String lastName;
}
