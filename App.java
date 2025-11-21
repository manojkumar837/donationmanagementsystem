package com.example.donation;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DonorDAO donorDAO = new DonorDAO();
        DonationDAO donationDAO = new DonationDAO();

        Donor donor1 = new Donor("John Doe", "john@example.com");
        Donor donor2 = new Donor("Jane Smith", "jane@example.com");

        donorDAO.save(donor1);
        donorDAO.save(donor2);

        Donation donation1 = new Donation(100.0, LocalDate.now());
        Donation donation2 = new Donation(250.0, LocalDate.now());

        donor1.addDonation(donation1);
        donor2.addDonation(donation2);

        donationDAO.save(donation1);
        donationDAO.save(donation2);

        System.out.println("Donors and their donations:");
        List<Donor> donors = donorDAO.getAll();
        for (Donor donor : donors) {
            System.out.println("Donor: " + donor.getName() + ", Email: " + donor.getEmail());
            for (Donation donation : donor.getDonations()) {
                System.out.println("  Donation: " + donation.getAmount() + ", Date: " + donation.getDate());
            }
        }

        HibernateUtil.shutdown();
    }
}
