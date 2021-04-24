package com.interview.meter.reader.domain;

import com.interview.meter.reader.enums.Month;
import com.interview.meter.reader.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Reading")
public class ReadingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "bigint", unique = true, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "RefMeter", columnDefinition = "bigint", nullable = false)
    private MeterEntity meter;

    @Column(name = "Month", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Month month;

    @Column(name = "Year", columnDefinition = "smallint", nullable = false)
    private int year;

    @Column(name = "Status", nullable = false,length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "Level", nullable = false)
    private double level;

    @Column(name = "DateCreatedOn", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "DateUpdatedOn")
    private LocalDateTime updatedOn;
}
