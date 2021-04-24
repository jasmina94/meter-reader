package com.interview.meter.reader.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Meter")
public class MeterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "bigint", unique = true, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "RefClient", columnDefinition = "bigint", nullable = false)
    private ClientEntity clientEntity;

    @Column(name = "Name", nullable = false)
    private String name;
}
