package develop.dao;

import develop.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseDaoImpl< T > implements BaseDao {

    @PersistenceContext
    EntityManager entityManager;

    public <S extends Customer> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }


    public Optional<Customer> findById(Long aLong) {
        return Optional.empty();
    }


    public boolean existsById(Long aLong) {
        return false;
    }


    public Iterable<Customer> findAllById(Iterable<Long> iterable) {
        return null;
    }


    public long count() {
        return 0;
    }


    public void deleteById(Long aLong) {

    }


    public void deleteAll(Iterable<? extends Customer> iterable) {

    }


    public void deleteAll() {

    }

}