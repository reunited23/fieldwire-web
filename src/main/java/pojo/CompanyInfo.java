package pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CompanyInfo {

    private String name;

    private String type;

    private String tradeType;

    private String size;

    private String phoneCountry;

    private String phoneNumber;
}
