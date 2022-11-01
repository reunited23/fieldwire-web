package enams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompanySize {
    VERY_SMALL("1 - 10"),
    SMALL("10 - 50"),
    MIDDLE("50 - 250"),
    LARGE("250 - 1000"),
    VERY_LARGE("1000+");

    public String name;
}
