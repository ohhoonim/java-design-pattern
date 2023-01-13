package design.pattern.adaptor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Member {
    private String id;
    private String password;
    private String level;
    private String token;
}
