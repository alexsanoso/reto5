package com.reto5.service;

import com.reto5.modelo.Category;
import com.reto5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander
 */
@Service
public class CategoryApi {
    /**
     * Atributo autowired para category
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * método para obtener todos los category
     *
     * @return
     */
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    /**
     * método para obtener category por id
     *
     * @param id
     * @return
     */
    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    /**
     * método save para category
     *
     * @param category
     * @return
     */
    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> evt = categoryRepository.getCategory(category.getId());
            if (evt.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    /**
     * método para actualizar una categoria
     *
     * @param category
     * @return
     */
    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> actualizar = categoryRepository.getCategory(category.getId());
            if (!actualizar.isEmpty()) {
                if (category.getDescription() != null) {
                    actualizar.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    actualizar.get().setName(category.getName());
                }
                return categoryRepository.save(actualizar.get());
            }
        }
        return category;
    }

    /**
     * método para borrar una categoria por id
     *
     * @param id
     * @return
     */
    public boolean deleteCategory(int id) {
        Boolean borrar = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return borrar;
    }
}
