package com.interview.meter.reader.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "Address")
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "bigint", unique = true, nullable = false)
    private Long id;

    @Column(name = "Street", nullable = false)
    private String street;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "Zip", nullable = false)
    private String zipCode;

    @Column(name = "Land", nullable = false)
    private String land;

    @Column(name = "AdditionalAddress")
    private String additionalAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(land, that.land) &&
                Objects.equals(additionalAddress, that.additionalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, zipCode, land, additionalAddress);
    }
}
