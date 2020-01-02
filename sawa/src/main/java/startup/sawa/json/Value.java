package startup.sawa.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {

    private int id;
    private String joke;
    private String[] categories;
}
