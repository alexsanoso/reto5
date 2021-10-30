package com.reto5.repository.crud;

// importaciones

import com.reto5.modelo.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alexander Sánchez Osorio
 */
public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}
