package Repository;

public interface Repo<ID,T>
{
    void add(T elem);
    void delete(T elem);
    void update(T elem,ID id);
    T findByID(ID id);
    Iterable<T> findAll();
}