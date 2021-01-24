package main.repository;

import main.domain.Identifiable;

public interface Repo <ID, E extends Identifiable<ID>>
{
    E save(E e);
    E findOne(ID e);
    Iterable<E> findAll();
}
