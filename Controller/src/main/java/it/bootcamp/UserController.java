package it.bootcamp;

import it.bootcamp.dto.UserDto;
import it.bootcamp.entity.UserFieldEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PER_PAGE = 10;
    public static final String DEFAULT_SORT_FIELD = "email";
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Page<UserDto>> getUserPage(@RequestParam(name = "page", required = false) Integer pageParam,
                                                     @RequestParam(name = "per_page", required = false) Integer perPageParam,
                                                     @RequestParam(name = "sort", required = false) String sortFieldParam) {
        logger.info("METHOD::getUserPage");
        int page = Optional.ofNullable(pageParam)
                .filter(pageNumber -> pageNumber >= 0)
                .orElse(DEFAULT_PAGE);
        int perPage = Optional.ofNullable(perPageParam)
                .filter(pageNumber -> pageNumber > 0)
                .orElse(DEFAULT_PER_PAGE);
        String sortField = Optional.ofNullable(sortFieldParam)
                .filter(field -> Arrays.stream(UserFieldEnum.values())
                        .map(Enum::name)
                        .collect(Collectors.toList())
                        .contains(field))
                .orElse(DEFAULT_SORT_FIELD);

        Page<UserDto> allUser = userService.findAllUser(page, perPage, sortField);
        ResponseEntity<Page<UserDto>> response;
        if (allUser.isEmpty()) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = ResponseEntity.ok(allUser);
        }
        return response;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto) {
        logger.info("METHOD::addUser");
        UserDto userDtoFromRepo = userService.addUser(userDto);
        return new ResponseEntity<>(userDtoFromRepo, HttpStatus.CREATED);
    }

}
