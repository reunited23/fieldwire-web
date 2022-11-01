package enams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompanyType {
    OTHER("Other"),
    SPECIALTY_CONTRACTOR("Specialty Contractor"),
    GENERAL_CONTRACTOR("General Contractor"),
    ARCHITECT_ENGINEER("Architect/Engineer"),
    OWNER_DEVELOPER("Owner/Developer");

    public String name;
}
