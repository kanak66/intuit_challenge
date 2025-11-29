INTUIT BUILD CHALLENGE – JAVA SOLUTION

This project contains the complete Java implementation for the Intuit Build Challenge, including multithreading, synchronization, functional programming with Java Streams, CSV data processing, and JUnit test coverage. Both assignments are implemented in a clean, modular structure following best practices.

ASSIGNMENT 1 – PRODUCER-CONSUMER PATTERN
This assignment implements the classic Producer–Consumer concurrency model using Java threads and synchronization.

Key Features:
Bounded shared buffer implemented with synchronized methods
wait() and notifyAll() used for thread coordination
Producer thread generates items and adds them to the buffer
Consumer thread removes and processes the items
Program terminates cleanly using a sentinel value (-1)
Demonstrates correct use of concurrency, blocking, and synchronization

ASSIGNMENT 2 – CSV DATA ANALYSIS USING JAVA STREAMS
This assignment reads employee records from a CSV file and performs analytical operations using Java Streams and lambda expressions.

Features:
Parse CSV file using BufferedReader
Filter employees with salary above a threshold
Group employees by department
Compute average salary
Find the highest-paid employee

SETUP AND RUN INSTRUCTIONS:

Prerequisites

Java 17 installed
Check using: java -version

Maven 3.8+ installed
Check using: mvn -version

Git installed (optional for cloning)
Check using: git --version

Clone the Repository
git clone https://github.com/
<your-username>/intuit_challenge.git
cd intuit_challenge/build-challenge-java

Build the Project
mvn clean install

Run Assignment 1 (Producer–Consumer)
mvn exec:java -Dexec.mainClass="com.intuit.challenge.assignment1.ProducerConsumerApp"

Run Assignment 2 (CSV Analysis)
mvn exec:java -Dexec.mainClass="com.intuit.challenge.assignment2.EmployeeAnalysis"

Ensure CSV file exists at:
src/main/resources/employees.csv

Run Unit Tests
mvn test

Print complete analysis results to the console
Includes JUnit 5 unit tests for all analysis methods


