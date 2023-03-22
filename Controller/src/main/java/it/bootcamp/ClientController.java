package it.bootcamp;

import it.bootcamp.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    public static final int PAGE_SIZE = 10;
    public static final String SORT_FIELD = "email";
    private final UserService userService;

    public ClientController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all/{pageNumber}")
    public ResponseEntity<List<UserDto>> getUserList(@PathVariable("pageNumber") int pageNumber) {
        List<UserDto> allUser = userService.findAllUser(pageNumber, PAGE_SIZE, SORT_FIELD).toList();
        ResponseEntity<List<UserDto>> response;
        if (allUser.size() == 0) {
            response = new ResponseEntity<>(allUser, HttpStatus.NO_CONTENT);
        } else {
            response = ResponseEntity.ok(allUser);
        }
        return response;
    }

}
