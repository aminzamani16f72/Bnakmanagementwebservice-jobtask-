package ir.mohaymen.javadevelopertask.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BankAccount {
    @Id
    private Long id;
    private Long accountNumber;
    private String owner;
    private long balance;

    @ManyToMany(mappedBy = "bankAccounts")
    private Set<User> users;

    public void deposit(long amount) {
        this.balance += amount;
    }

    public void withdraw(long amount) {
        this.balance -= amount;
    }

    protected abstract void addInterest();


}
