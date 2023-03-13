package by.teachmeskills.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private String accountName;
    private String type;
    private String industry;
    private String phone;
}
