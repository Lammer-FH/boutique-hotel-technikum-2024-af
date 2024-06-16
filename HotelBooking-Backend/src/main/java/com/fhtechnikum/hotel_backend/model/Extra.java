package com.fhtechnikum.hotel_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "EXTRA")
@Table(name = "EXTRA")
@Getter
@Setter
@NoArgsConstructor
public class Extra {
    @Id
    @Column(name = "EXTRA_ID")
    private int extraId;

    @Column(name = "EXTRA_NAME")
    private String extraName;
}
