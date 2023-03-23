package it.bootcamp;

import it.bootcamp.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    public static final int PAGE_SIZE = 10;
    public static final String SORT_FIELD = "email";
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUserList(@RequestParam(name = "page", required = false) Integer page,
                                                     @RequestParam(name = "per_page", required = false) Integer perPage,
                                                     @RequestParam(name = "sort", required = false) String sortField) {
        Integer page = Optional.ofNullable(page).orElse(1);
        List<UserDto> allUser = userService.findAllUser(page, PAGE_SIZE, SORT_FIELD).toList();
        ResponseEntity<List<UserDto>> response;
        if (allUser.size() == 0) {
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            response = ResponseEntity.ok(allUser);
        }
        return response;
    }

}
