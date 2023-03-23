package it.bootcamp.impl;

import it.bootcamp.UserService;
import it.bootcamp.converter.Converter;
import it.bootcamp.dto.UserDto;
import it.bootcamp.entity.User;
import it.bootcamp.repo.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Converter<User, UserDto> userConverter;

    public UserServiceImpl(final UserRepository userRepository, final Converter<User, UserDto> userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDto addUser(final UserDto userDto) {
        User user = userRepository.save(userConverter.toEntity(userDto));
        return userConverter.toDto(user);
    }

    @Override
    public Page<UserDto> findAllUser(final int pageNumber, final int pageSize, final String sortField) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortField).ascending());
        return userRepository.findAll(pageable).map(userConverter::toDto);
    }
}
