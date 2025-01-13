package ir.mohaymen.javadevelopertask.controller;

import ir.mohaymen.javadevelopertask.DTO.BankAccountDto;
import ir.mohaymen.javadevelopertask.mapper.DtoMapper;
import ir.mohaymen.javadevelopertask.model.BankAccount;
import ir.mohaymen.javadevelopertask.services.AccountService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;


    public AccountController(AccountService accountService, DtoMapper dtoMapper) {
        this.accountService = accountService;
    }
    @GetMapping
    public ResponseEntity<BankAccountDto> getAccount(@RequestParam("id") long id){
        BankAccountDto accountDto = accountService.getAccountById(id);

        // Return the account if found, or 404 Not Found if not
        if (accountDto != null) {
            return ResponseEntity.ok(accountDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<HttpStatus> addAccount(@RequestBody BankAccountDto bankAccountDto){
        accountService.save(bankAccountDto);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
