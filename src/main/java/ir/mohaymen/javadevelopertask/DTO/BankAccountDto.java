package ir.mohaymen.javadevelopertask.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BankAccountDto {
    private Long accountNumber;
    private String owner;
    private long balance;
    private String accountType;

}
