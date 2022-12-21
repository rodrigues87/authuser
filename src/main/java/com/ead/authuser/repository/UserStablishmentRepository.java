package com.ead.authuser.repository;

import com.ead.authuser.models.UserStablishmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserStablishmentRepository extends JpaRepository<UserStablishmentModel, UUID> {
}