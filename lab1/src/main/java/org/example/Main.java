package org.example;

import java.util.Objects;
import java.util.Arrays;

class Passenger {
    private String name;
    private String passportNumber;

    public Passenger(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(name, passenger.name) && Objects.equals(passportNumber, passenger.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportNumber);
    }
}

class Airplane {
    private String model;
    private int capacity;

    public Airplane(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }



    @Override
    public String toString() {
        return "Airplane{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return capacity == airplane.capacity && Objects.equals(model, airplane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, capacity);
    }

    static class AirplaneBuilder {
        private String model;
        private int capacity;

        public AirplaneBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public AirplaneBuilder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Airplane build() {
            return new Airplane(model, capacity);
        }
    }
}


class Airport {
    private String name;
    private String code;
    private Airplane airplane;
    private Passenger[] passengers;

    public Airport(String name, String code, Airplane airplane, Passenger[] passengers) {
        this.name = name;
        this.code = code;
        this.airplane = airplane;
        this.passengers = passengers;
    }



    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", airplane=" + airplane +
                ", passengers=" + Arrays.toString(passengers) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name) && Objects.equals(code, airport.code) &&
                Objects.equals(airplane, airport.airplane) && Arrays.equals(passengers, airport.passengers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, code, airplane);
        result = 31 * result + Arrays.hashCode(passengers);
        return result;
    }
    static class AirportBuilder {
        private String name;
        private String code;
        private Airplane airplane;
        private Passenger[] passengers;

        public AirportBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public AirportBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public AirportBuilder setAirplane(Airplane airplane) {
            this.airplane = airplane;
            return this;
        }

        public AirportBuilder setPassengers(Passenger[] passengers) {
            this.passengers = passengers;
            return this;
        }

        public Airport build() {
            return new Airport(name, code, airplane, passengers);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("John Doe", "AB123456");
        Passenger passenger2 = new Passenger("Alice", "CD789012");

        System.out.println("Passenger 1 equals Passenger 2: " + passenger1.equals(passenger2));

        Airplane airplane = new Airplane.AirplaneBuilder()
                .setModel("Boeing 747")
                .setCapacity(500)
                .build();

        Passenger[] passengers = {
                new Passenger("Alice", "CD789012"),
                new Passenger("Bob", "EF345678")
        };

        Airport airport1 = new Airport.AirportBuilder()
                .setName("International Airport")
                .setCode("ABC")
                .setAirplane(airplane)
                .setPassengers(passengers)
                .build();

        Airport airport2 = new Airport.AirportBuilder()
                .setName("International Airport")
                .setCode("ABC")
                .setAirplane(airplane)
                .setPassengers(passengers)
                .build();

        System.out.println("Airport 1 equals Airport 2: " + airport1.equals(airport2));

        System.out.println("Hash code for Passenger 1: " + passenger1.hashCode());
        System.out.println("Hash code for Airport 1: " + airport1.hashCode());

        System.out.println("Airport 1: " + airport1.toString());
        System.out.println("Airport 2: " + airport2.toString());

    }
}


