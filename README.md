Donation Management System
This is a simple beginner-friendly Donation Management System built with Hibernate ORM and H2 in-memory database. It demonstrates basic CRUD operations and entity relationships using Hibernate.

Features
Manage Donors and their Donations
One-to-Many relationship between Donor and Donation
Add new donors and donations
List all donors and their donations
Technologies Used
Java 17
Hibernate ORM 6.x
Jakarta Persistence API
H2 In-Memory Database
Maven for build and dependency management
SLF4J Simple for logging
Project Structure
src/main/java/com/example/donation/
Donor.java - Donor entity
Donation.java - Donation entity
DonorDAO.java - Data Access Object for Donor
DonationDAO.java - Data Access Object for Donation
HibernateUtil.java - Hibernate SessionFactory utility
App.java - Main class demonstrating usage
src/main/resources/hibernate.cfg.xml - Hibernate configuration
pom.xml - Maven build and dependency file
Prerequisites
Java 17 or above installed
Maven installed
How to Build and Run
Clone or download the project zip and unzip it.

Open a terminal and navigate to the project root directory.

Build the project and download dependencies:

mvn clean install
