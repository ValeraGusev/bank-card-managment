package com.example.cardmanagment.service.dto.card;

import com.example.cardmanagment.entity.enumed.CardStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CardDto {

    private UUID id;
    private String cardNumber;
    private String cardHashNumber;
    private BigDecimal balance;
    private CardStatus status;
    private UUID users;
    private LocalDate expiryCard;
}
