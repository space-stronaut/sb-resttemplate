package com.example.demo.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserAddressService {
    private final String uri = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<?> parseJson() throws IOException{
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        JsonNode object = objectMapper.readTree(response.getBody());

        List<User> users = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();

        for (JsonNode jsonNode : object) {
            User user = new User();
            user.setId(jsonNode.get("id").asLong());
            user.setName(jsonNode.get("name").asText());
            user.setEmail(jsonNode.get("email").asText());
            user.setPhone(jsonNode.get("phone").asText());
            user.setWebsite(jsonNode.get("website").asText());
            user.setUsername(jsonNode.get("username").asText());
//            users.add(user);

            JsonNode addressNode = jsonNode.path("address");

            Address address = new Address();

            address.setUserId(jsonNode.get("id").asLong());
            address.setSuite(addressNode.get("suite").asText());
            address.setCity(addressNode.get("city").asText());
            address.setStreet(addressNode.get("street").asText());
            address.setZipcode(addressNode.get("zipcode").asText());
            addresses.add(address);
            user.setAddress(address);

            users.add(user);
        }

        return ResponseEntity.ok(users);
    }
}
