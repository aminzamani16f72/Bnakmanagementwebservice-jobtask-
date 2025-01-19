package ir.mohaymen.javadevelopertask.DTO;

import lombok.Getter;

@Getter
public class TransferRequest {
    // Getters and Setters
    private Long fromAccountId;
    private Long toAccountId;
    private long amount;

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

