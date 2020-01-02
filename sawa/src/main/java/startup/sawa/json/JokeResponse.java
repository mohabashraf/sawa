package startup.sawa.json;

import lombok.Data;

@Data
public class JokeResponse {
    private String status;
    private Value value;
}
