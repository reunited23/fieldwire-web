package enams;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradeType {
    CONCRETE("Concrete"),
    EARTHWORK("Earthwork"),
    ELECTRICAL("Electrical");

    public String name;
}
