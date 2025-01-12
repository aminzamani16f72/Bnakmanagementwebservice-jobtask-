package ir.mohaymen.javadevelopertask.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ShortTerm")
@Data
@Entity
public class ShortTermAccount extends BankAccount{
    private final Double interestRate=1.2;

    @Override
    protected void addInterest() {
        setBalance((long) (getBalance()*interestRate));
    }
}
