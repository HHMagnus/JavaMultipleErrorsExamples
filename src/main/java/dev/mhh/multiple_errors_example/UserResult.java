package dev.mhh.multiple_errors_example;

import dev.mhh.result.Result;

import java.time.LocalDate;
import java.util.List;

// This is an example of constructing a user with multiple errors using result
public class UserResult {
    public String name;
    public LocalDate dateOfBirth;
    public String email;

    private UserResult(String name, LocalDate dateOfBirth, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public static Result<UserResult, List<String>> of(String name, LocalDate dateOfBirth, String email) {
        return CombineResult.combine(
                UserResult::new,
                validatedName(name),
                validatedDateOfBirth(dateOfBirth),
                validatedEmail(email)
        );
    }

    private static Result<String, String> validatedName(String name) {
        if (name == null) {
            return Result.err("Name cannot be null");
        }

        final var trimmedName = name.trim();
        if (trimmedName.isBlank()) {
            return Result.err("Name cannot be blank");
        }

        return Result.ok(trimmedName);
    }

    private static Result<LocalDate, String> validatedDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return Result.err("Date of birth cannot be null");
        }

        if (dateOfBirth.isBefore(LocalDate.of(1900, 1, 1))) {
            return Result.err("Date of birth cannot be before 1900-01-01");
        }

        if (dateOfBirth.isAfter(LocalDate.now().minusYears(18))) {
            return Result.err("User must be at least 18 years old");
        }

        return Result.ok(dateOfBirth);
    }

    private static Result<String, String> validatedEmail(String email) {
        if (email == null) {
            return Result.err("Email cannot be null");
        }

        final var trimmedEmail = email.trim();
        if (trimmedEmail.isBlank()) {
            return Result.err("Email cannot be blank");
        }

        if (!trimmedEmail.contains("@")) {
            return Result.err("Email must contain an '@' character");
        }

        return Result.ok(trimmedEmail);
    }
}
