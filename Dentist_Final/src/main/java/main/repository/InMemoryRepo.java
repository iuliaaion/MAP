package main.repository;

import main.domain.Identifiable;

import java.util.HashMap;

public class InMemoryRepo <ID,E extends Identifiable<ID>> implements Repo<ID,E>
{
    private HashMap<ID,E> map;

    public InMemoryRepo()
    {
        map = new HashMap<>();
    }

    @Override
    public E save(E entity)
    {
        map.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public E findOne(ID e)
    {
        return map.get(e);
    }

    @Override
    public Iterable<E> findAll()
    {
        return map.values();
    }
}
