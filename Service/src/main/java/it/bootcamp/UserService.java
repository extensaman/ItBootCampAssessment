package it.bootcamp;

import it.bootcamp.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);
    Page<UserDto> findAllUser(int pageNumber, int pageSize, String sortField);
}
