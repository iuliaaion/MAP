package Repository;

public interface Repository <ID, T> {

    void add(T elem) throws Exception;

    void delete(T elem) throws Exception;

    void update(T elem, ID id) throws Exception;

    T findByID(ID id) throws Exception;

    Iterable <T> findAll();
}
