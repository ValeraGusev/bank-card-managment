package com.example.cardmanagment.entity.enumed;

public enum CardStatus {
    ACTIVE, BLOCKED, EXPIRED;

    public Boolean isActive() {
        return this == ACTIVE;
    }
}
