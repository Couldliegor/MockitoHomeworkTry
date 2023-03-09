package Model;

import java.time.LocalDate;

public class User {
    private final String name;
    private final int year;
    private final int yearOfBirth;

    public User(String name, int year) {
        this.name = name;
        this.year = year;
        this.yearOfBirth = getYearOfBitrh(year);
    }

    private int getYearOfBitrh(int year) {
        return LocalDate.now().getYear() - year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
