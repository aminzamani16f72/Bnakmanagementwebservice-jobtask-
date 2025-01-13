package ir.mohaymen.javadevelopertask.mapper;

import ir.mohaymen.javadevelopertask.DTO.BankAccountDto;
import ir.mohaymen.javadevelopertask.DTO.UserDto;
import ir.mohaymen.javadevelopertask.model.BankAccount;
import ir.mohaymen.javadevelopertask.model.LongTermAccount;
import ir.mohaymen.javadevelopertask.model.ShortTermAccount;
import ir.mohaymen.javadevelopertask.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DtoMapper {
    public UserDto userToDto(User user);
    public User userDtoToUser(UserDto userDto);
    public BankAccountDto bankAccountToDto(BankAccount bankAccount);
    public LongTermAccount DtoToLongTermAccount(BankAccountDto bankAccountDto);
    public ShortTermAccount DtoToshortTermAccount(BankAccountDto bankAccountDto);
}
