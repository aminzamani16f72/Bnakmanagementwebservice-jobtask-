package ir.mohaymen.javadevelopertask.services;

import ir.mohaymen.javadevelopertask.model.BankAccount;
import ir.mohaymen.javadevelopertask.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountRepository bankAccountRepository;

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, long amount) {
        BankAccount firstAccount = bankAccountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("Source account not found"));
        BankAccount secondAccount = bankAccountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("Destination account not found"));

        if (canTransfer(firstAccount, amount)) {
            firstAccount.withdraw(amount);
            secondAccount.deposit(amount);

            bankAccountRepository.save(firstAccount);
            bankAccountRepository.save(secondAccount);
        } else {
            throw new RuntimeException("Insufficient balance in source account");
        }
    }

    private boolean canTransfer(BankAccount firstAccount, long transferAmount) {
        return firstAccount.getBalance() >= transferAmount;
    }
}

