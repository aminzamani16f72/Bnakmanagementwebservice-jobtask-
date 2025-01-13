package ir.mohaymen.javadevelopertask.repository;

import ir.mohaymen.javadevelopertask.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount,Long> {
}
