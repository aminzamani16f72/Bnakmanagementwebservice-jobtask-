package ir.mohaymen.javadevelopertask.controller;

import ir.mohaymen.javadevelopertask.DTO.UserDto;
import ir.mohaymen.javadevelopertask.services.AccountService;
import ir.mohaymen.javadevelopertask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    public UserController(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam("id") long id){
        UserDto userDto=userService.get(id);
        return ResponseEntity.ok(userDto);

    }
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        userService.add(userDto);
        return ResponseEntity.status(HttpStatus.OK).body("User created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto,@RequestParam("id") long id){
        userService.update(userDto,id);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam("id")long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
