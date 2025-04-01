package emt223287.service.application;


import emt223287.dto.CreateUserDto;
import emt223287.dto.DisplayUserDto;
import emt223287.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
