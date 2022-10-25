package com.net.jwt.responseDto;

import com.net.jwt.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {

    Long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String passportNumber;
    UserStatus status;
    String role;
}
