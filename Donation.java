package com.example.donation;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor_id")
    private Donor donor;

    public Donation() {}

    public Donation(Double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Long getId() { return id; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Donor getDonor() { return donor; }
    public void setDonor(Donor donor) { this.donor = donor; }
}
