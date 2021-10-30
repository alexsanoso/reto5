package com.reto5.repository.crud;

// importaciones

import com.reto5.modelo.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alexander Sánchez Osorio
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
