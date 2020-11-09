package repository;

import domain.Identifiable;

import java.util.*;

public abstract class AbstractRepository<ID, T extends Identifiable<ID>> implements Repository<ID,T>
{
    private Map<ID,T> map;

    public AbstractRepository()
    {
        map = new HashMap<>();
    }

    public void add(T elem)
    {
        if(map.containsKey(elem.getID()))
            throw new RuntimeException("Element already exists!");
        map.put(elem.getID(),elem);
    }

    public void delete(T elem)
    {
        if(map.containsKey(elem.getID()))
            map.remove(elem.getID());
        else
            throw new RuntimeException("Missing element!");
    }

    public void update(T elem, ID id)
    {
        if(map.containsKey(elem.getID()))
            map.put(id,elem);
        else
            throw new RuntimeException("Missing element!");
    }

    public T findByID(ID id)
    {
        if(map.containsKey(id))
            return map.get(id);
        else
            return null;
    }

    public Iterable<T> findAll()
    {
        return map.values();
    }
}
