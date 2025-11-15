package com.dev;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class ValidationUtilTest {

    @Test
    public void testValidEmployeeNeeds() {
        EmployeeNeeds e = new EmployeeNeeds(
                1234,
                Arrays.asList("Asthma", "Diabetes"),
                Arrays.asList("DrSmith"),
                Arrays.asList("Ibuprofen"),
                "Premium"
        );

        assertTrue(ValidationUtil.validateEmployeeNeeds(e));
    }

    @Test
    public void testInvalidNeedsID() {
        EmployeeNeeds e = new EmployeeNeeds(
                50,
                Arrays.asList("Asthma"),
                Arrays.asList("DrJones"),
                Arrays.asList("Tylenol"),
                "Standard"
        );

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateEmployeeNeeds(e);
        });
        assertEquals("Invalid needsID.", ex.getMessage());
    }

    @Test
    public void testNullList() {
        EmployeeNeeds e = new EmployeeNeeds(
                1500,
                null,
                Arrays.asList("DrJones"),
                Arrays.asList("Tylenol"),
                "Basic"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateEmployeeNeeds(e);
        });
    }

    @Test
    public void testListWithNonString() {
        EmployeeNeeds e = new EmployeeNeeds(
                2300,
                Arrays.asList("Diabetes", (String) null),
                Arrays.asList("DrSmith"),
                Arrays.asList("Ibuprofen"),
                "Gold"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateEmployeeNeeds(e);
        });
    }

    @Test
    public void testBadCoveragePreference() {
        EmployeeNeeds e = new EmployeeNeeds(
                4444,
                Arrays.asList("Hypertension"),
                Arrays.asList("DrBrown"),
                Arrays.asList("Aspirin"),
                "12345"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtil.validateEmployeeNeeds(e);
        });
    }
}
