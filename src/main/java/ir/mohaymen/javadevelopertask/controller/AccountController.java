package ir.mohaymen.javadevelopertask.controller;

import ir.mohaymen.javadevelopertask.DTO.BankAccountDto;
import ir.mohaymen.javadevelopertask.DTO.TransferRequest;
import ir.mohaymen.javadevelopertask.services.AccountService;
import ir.mohaymen.javadevelopertask.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private BankService bankService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<BankAccountDto> getAccount(@RequestParam("id") long id) {
        BankAccountDto accountDto = accountService.getAccountById(id);

        if (accountDto != null) {
            return ResponseEntity.ok(accountDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<String> addAccount(@RequestBody BankAccountDto bankAccountDto) {
        accountService.save(bankAccountDto);
        return ResponseEntity.status(HttpStatus.OK).body("Account created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateAccount(@RequestBody BankAccountDto bankAccountDto, @RequestParam("id") long id) {
        accountService.update(bankAccountDto, id);
        return ResponseEntity.status(HttpStatus.OK).body("Account updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAccount(@RequestParam("id") long id) {
        accountService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Account deleted successfully");
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}


