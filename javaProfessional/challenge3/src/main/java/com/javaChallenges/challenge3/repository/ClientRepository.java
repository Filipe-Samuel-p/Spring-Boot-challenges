package com.javaChallenges.challenge3.repository;

import com.javaChallenges.challenge3.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
