package dev.mhh.multiple_errors_example;

import java.time.LocalDate;

// This is an example of constructing a user with multiple exceptions
public class UserThrow {
    public String name;
    public LocalDate dateOfBirth;
    public String email;

    public static UserThrow of(String name, LocalDate dateOfBirth, String email) throws CombineThrow.AggregatedException {
        return CombineThrow.exceptionAggregator(
                UserThrow::new,
                () -> validatedName(name),
                () -> validatedDateOfBirth(dateOfBirth),
                () -> validatedEmail(email)
        );
    }

    private UserThrow(String name, LocalDate dateOfBirth, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    private static String validatedName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        final var trimmedName = name.trim();
        if (trimmedName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        return trimmedName;
    }

    private static LocalDate validatedDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }

        if (dateOfBirth.isBefore(LocalDate.of(1900, 1, 1))) {
            throw new IllegalArgumentException("Date of birth cannot be before 1900-01-01");
        }

        if (dateOfBirth.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("User must be at least 18 years old");
        }

        return dateOfBirth;
    }

    private static String validatedEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        final var trimmedEmail = email.trim();
        if (trimmedEmail.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }

        if (!trimmedEmail.contains("@")) {
            throw new IllegalArgumentException("Email must contain an '@' character");
        }

        return trimmedEmail;
    }
}
