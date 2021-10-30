package com.reto5.web;

import com.reto5.modelo.Category;
import com.reto5.service.CategoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexander
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Category/")
public class CategoryWeb {
    /**
     * atributo autowired category
     */
    @Autowired
    private CategoryApi categoryApi;

    /**
     * método para obtener todas las categorias
     *
     * @return
     */
    @GetMapping("all")
    public List<Category> getAll() {
        return categoryApi.getAll();
    }

    /**
     * método para obtener cada category por id
     *
     * @param id
     * @return
     */
    @GetMapping("{id]")
    public Optional<Category> getCategory(@PathVariable("id") int id) {
        return categoryApi.getCategory(id);
    }

    /**
     * método para guardar cada categoria
     *
     * @param category
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return categoryApi.save(category);
    }

    /**
     * método para actualziar cada categoria
     *
     * @param category
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return categoryApi.update(category);
    }

    /**
     * método para borrar cada categoria por id
     *
     * @param categoryId
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return categoryApi.deleteCategory(categoryId);
    }
}