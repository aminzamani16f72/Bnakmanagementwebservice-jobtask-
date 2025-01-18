package ir.mohaymen.javadevelopertask.services;

import ir.mohaymen.javadevelopertask.DTO.UserDto;
import ir.mohaymen.javadevelopertask.mapper.DtoMapper;
import ir.mohaymen.javadevelopertask.model.User;
import ir.mohaymen.javadevelopertask.model.UserType;
import ir.mohaymen.javadevelopertask.repository.UserRepository;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DtoMapper dtoMapper;
    @Autowired
    private UserRepository userRepository;

    public UserService(DtoMapper dtoMapper, UserRepository userRepository) {
        this.dtoMapper = dtoMapper;
        this.userRepository = userRepository;
    }


    public UserDto get(long id) {
        return userRepository.findById(id).map(user->dtoMapper.userToDto(user)).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    public void add(UserDto userDto) {
        User user=dtoMapper.userDtoToUser(userDto);
        userRepository.save(user);
    }


    public void update(UserDto userDto, long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
        if (userDto.getUserType() != null) {
            try {
                UserType userType = UserType.valueOf(userDto.getUserType().toUpperCase());
                user.setUserType(userType);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid userType value: " + userDto.getUserType());
            }
        }
        user.setAddress(userDto.getAddress());
        user.setName(userDto.getName());
        user.setBirthDate(userDto.getBirthDate());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPostalCode(userDto.getPostalCode());
        user.setUniqueId(userDto.getUniqueId());
    }

    public void delete(long id) {
        User user=userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found with ID: " + id));
        userRepository.delete(user);
    }
}
