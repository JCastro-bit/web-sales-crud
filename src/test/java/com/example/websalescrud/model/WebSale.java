package com.example.websalescrud.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class WebSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String websiteUrl;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate saleDate;

    private String description;
}
