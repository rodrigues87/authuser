package com.ead.authuser.services.impl;

import com.ead.authuser.clients.StablishmentClient;
import com.ead.authuser.dtos.StablishmentDto;
import com.ead.authuser.models.UserStablishmentModel;
import com.ead.authuser.models.UserModel;
import com.ead.authuser.repository.UserStablishmentRepository;
import com.ead.authuser.services.UserStablishmentService;
import com.ead.authuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserStablishmentServiceImpl implements UserStablishmentService {

    @Autowired
    UserStablishmentRepository userStablishmentRepository;

    @Autowired
    UserService userService;

    @Autowired
    StablishmentClient userClient;

    @Override
    public UserStablishmentModel saveSubscriptionUserInfindStablishmentById(UUID userId, UUID stablishmentId) {
        UserStablishmentModel userStablishmentModel = new UserStablishmentModel();

        Optional<UserModel> userModelOptional = userService.findById(userId);

        if(userModelOptional.isEmpty()){
            throw new RuntimeException("O usuário não existe");
        }

        StablishmentDto stablishmentDto = userClient.findStablishmentById(userId);

        if(stablishmentDto ==null){
            throw new RuntimeException("O Estabelecimento não existe");
        }

        userStablishmentModel.setUser(userModelOptional.get());
        userStablishmentModel.setStablishmentId(stablishmentId);

        return userStablishmentRepository.save(userStablishmentModel);
    }
}
