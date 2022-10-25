package com.net.jwt.mapper.impl;

import com.net.jwt.entity.User;
import com.net.jwt.mapper.UserEntityToUserResponseDto;
import com.net.jwt.responseDto.UserResponseDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class UserEntityToUserResponseDtoImpl implements UserEntityToUserResponseDto {

    @Override
    public UserResponseDto entityToDto(User user) {

        return UserResponseDto
            .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .passportNumber(user.getPassportNumber())
                .role(user.getRole().getName())
                .status(user.getStatus())
                .build();
    }

    @Override
    public List<UserResponseDto> entityListToDtoList(List<User> users) {
        List<UserResponseDto> usersDtoList = new ArrayList<>();
        for(User user : users) {
            usersDtoList.add(entityToDto(user));
        }
        return usersDtoList;
    }

}
