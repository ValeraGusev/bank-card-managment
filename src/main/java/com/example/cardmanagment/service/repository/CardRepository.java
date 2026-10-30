package com.example.cardmanagment.service.repository;

import com.example.cardmanagment.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
