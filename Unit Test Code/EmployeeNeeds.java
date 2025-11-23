package com.dev;
import java.util.List;

public class EmployeeNeeds {
    int needsID;
    List<String> chronicConditions;
    List<String> preferredDoctors;
    List<String> medicationNeeds;
    String coveragePreferences;

    public EmployeeNeeds(int needsID, List<String> chronicConditions,
                         List<String> preferredDoctors, List<String> medicationNeeds,
                         String coveragePreferences) {
        this.needsID = needsID;
        this.chronicConditions = chronicConditions;
        this.preferredDoctors = preferredDoctors;
        this.medicationNeeds = medicationNeeds;
        this.coveragePreferences = coveragePreferences;
    }
}
