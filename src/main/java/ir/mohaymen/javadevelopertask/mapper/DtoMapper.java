package ir.mohaymen.javadevelopertask.mapper;

import ir.mohaymen.javadevelopertask.DTO.UserDto;
import ir.mohaymen.javadevelopertask.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface DtoMapper {
    public UserDto userToDto(User user);
    public User userDtoToUser(UserDto userDto);
}
