package com.ead.authuser.services;

import com.ead.authuser.models.UserStablishmentModel;

import java.util.UUID;

public interface UserStablishmentService {
    UserStablishmentModel saveSubscriptionUserInfindStablishmentById(UUID userId, UUID courseId);
}
