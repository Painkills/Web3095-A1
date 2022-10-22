package com.a1.cookbook.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepo extends CrudRepository<Chef, Long> {
    Iterable<Chef> findChefIdById(Long ChefId);
}
