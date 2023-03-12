package Model;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return year == user.year && yearOfBirth == user.yearOfBirth && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, yearOfBirth);
    }
}
