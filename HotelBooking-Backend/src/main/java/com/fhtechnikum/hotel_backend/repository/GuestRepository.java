package com.fhtechnikum.hotel_backend.repository;

import com.fhtechnikum.hotel_backend.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
    Optional<Guest> findByGuestEmail(String email);
}
