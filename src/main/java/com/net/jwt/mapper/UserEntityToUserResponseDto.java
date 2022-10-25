package com.net.jwt.mapper;

import com.net.jwt.entity.User;
import com.net.jwt.responseDto.UserResponseDto;

import java.util.List;

public interface UserEntityToUserResponseDto {

    UserResponseDto entityToDto(User user);

    List<UserResponseDto> entityListToDtoList(List<User> users);

}
