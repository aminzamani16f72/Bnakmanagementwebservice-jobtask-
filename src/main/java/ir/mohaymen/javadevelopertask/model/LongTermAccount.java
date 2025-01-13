package ir.mohaymen.javadevelopertask.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@DiscriminatorValue("LongTerm")
@Entity
public class LongTermAccount extends BankAccount{
    private final double interestRate=1.8;

    @Override
    protected void addInterest() {
        setBalance((long) (getBalance()*interestRate));
    }
}
