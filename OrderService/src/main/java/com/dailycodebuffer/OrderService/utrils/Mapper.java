package com.dailycodebuffer.OrderService.utrils;

public interface Mapper<D,E>
{
    E toEntity(D domain);
    D fromEntity(E entity);
}
