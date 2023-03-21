package it.bootcamp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ClientController
{
    @GetMapping("/all")
    public ResponseEntity<List<String>> getUserList(){
        return ResponseEntity.ok(List.of("1","6","3"));
    }

}
