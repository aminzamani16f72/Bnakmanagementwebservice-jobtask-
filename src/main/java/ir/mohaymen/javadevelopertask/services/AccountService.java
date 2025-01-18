package ir.mohaymen.javadevelopertask.services;

import ir.mohaymen.javadevelopertask.DTO.BankAccountDto;
import ir.mohaymen.javadevelopertask.mapper.DtoMapper;
import ir.mohaymen.javadevelopertask.model.BankAccount;
import ir.mohaymen.javadevelopertask.model.LongTermAccount;
import ir.mohaymen.javadevelopertask.model.User;
import ir.mohaymen.javadevelopertask.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService  {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DtoMapper dtoMapper;

    public AccountService(AccountRepository accountRepository,DtoMapper dtoMapper) {
        this.accountRepository = accountRepository;
        this.dtoMapper=dtoMapper;
    }
    public void save(BankAccountDto accountDto) {
        String accountType=accountDto.getAccountType();
        switch (accountType) {
            case "LongTerm":
                BankAccount longTermAccount = dtoMapper.DtoToLongTermAccount(accountDto);
                accountRepository.save(longTermAccount);
                break; // Add break to prevent fall-through

            case "ShortTerm":
                BankAccount shortTermAccount = dtoMapper.DtoToshortTermAccount(accountDto);
                accountRepository.save(shortTermAccount);
                break; // Add break to prevent fall-through

            default:
                throw new IllegalArgumentException("Unsupported account type: " + accountType);
        }
    }
    public void update(BankAccountDto accountDto, long id) {
        BankAccount bankAccount = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BankAccount with id " + id + " not found"));

        bankAccount.setAccountNumber(accountDto.getAccountNumber());
        bankAccount.setBalance(accountDto.getBalance());
        bankAccount.setOwner(accountDto.getOwner());

        accountRepository.save(bankAccount);
    }



    public BankAccountDto getAccountById(long id) {
        return accountRepository.findById(id)
                .map(account -> dtoMapper.bankAccountToDto(account))
                .orElseThrow(null);
    }

    public void delete(long id) {
        BankAccount account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BankAccount not found with ID: " + id));
        accountRepository.delete(account);
    }

}
