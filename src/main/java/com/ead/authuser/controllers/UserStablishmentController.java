package com.ead.authuser.controllers;

import com.ead.authuser.clients.StablishmentClient;
import com.ead.authuser.dtos.StablishmentDto;
import com.ead.authuser.models.UserStablishmentModel;
import com.ead.authuser.services.UserStablishmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserStablishmentController {

    @Autowired
    StablishmentClient userClient;

    @Autowired
    UserStablishmentService userStablishmentService;

    @GetMapping("/users/{userId}/stablishments")
    public ResponseEntity<Page<StablishmentDto>> getAllStablishmentsByuser
            (@PageableDefault(page = 0, size = 10, sort = "userId", direction = Sort.Direction.ASC) Pageable pageable,
             @RequestParam(required = false) UUID userId) {

        return ResponseEntity.status(HttpStatus.OK).body(userClient.getAllStablishmentsByUser(userId,pageable));

    }

    @GetMapping("/user/{userId}/{stablishmentId}")
    public ResponseEntity<Object> saveSubscriptionUserInStablishment(@PathVariable UUID userId, UUID stablishmentId){

        UserStablishmentModel userStablishmentModel = userStablishmentService.saveSubscriptionUserInfindStablishmentById(userId,stablishmentId);

        return ResponseEntity.status(HttpStatus.OK).body(userStablishmentModel);
    }
}
