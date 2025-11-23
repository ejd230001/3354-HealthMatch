package com.dev;
import java.util.List;

public class ValidationUtil {

    public static boolean validateEmployeeNeeds(EmployeeNeeds n) {
        if (n == null)
            throw new IllegalArgumentException("EmployeeNeeds object cannot be null.");

        // Validate ID (must be in range 1000–9999)
        if (n.needsID < 1000 || n.needsID > 9999)
            throw new IllegalArgumentException("Invalid needsID.");

        // Validate lists are made up of strings
        validateStringList(n.chronicConditions, "chronicConditions");
        validateStringList(n.preferredDoctors, "preferredDoctors");
        validateStringList(n.medicationNeeds, "medicationNeeds");

        // Validate coverage preferences are strings, not null, and only contain letters
        if (n.coveragePreferences == null || n.coveragePreferences.isEmpty())
            throw new IllegalArgumentException("coveragePreferences cannot be empty.");

        if (!n.coveragePreferences.matches("[A-Za-z]+"))
            throw new IllegalArgumentException("coveragePreferences must contain only letters.");

        return true;
    }

    private static void validateStringList(List<String> list, String field) {
        if (list == null)
            throw new IllegalArgumentException(field + " list cannot be null.");

        for (Object item : list) {
            if (!(item instanceof String))
                throw new IllegalArgumentException(field + " must contain only strings.");
        }
    }
}
