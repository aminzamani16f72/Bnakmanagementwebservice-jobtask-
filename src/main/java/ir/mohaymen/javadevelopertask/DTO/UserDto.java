package ir.mohaymen.javadevelopertask.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String uniqueId;
    private Date birthDate;
    private String userType; // Using String to avoid coupling with Enum
    private String phoneNumber;
    private String address;
    private String postalCode;

}
