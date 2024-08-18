package com.example.demo.Controller;

import com.example.demo.Service.UserAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserAddressController {
    private final UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService){
        this.userAddressService = userAddressService;
    }

    @GetMapping("/test")
    public ResponseEntity<?> parseJson() throws IOException {
        return userAddressService.parseJson();
    }
}
