package com.example.cardmanagment.service.repository.mapper;

public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);
}
