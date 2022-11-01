package pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProjectInfo {

    private String name;

    private String code;

    private String categoryName;

    private String fileName;
}
