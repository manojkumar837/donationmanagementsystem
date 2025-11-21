package com.example.donation;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Donation> donations = new HashSet<>();

    public Donor() {}

    public Donor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Set<Donation> getDonations() { return donations; }
    public void addDonation(Donation donation) {
        donations.add(donation);
        donation.setDonor(this);
    }
}
