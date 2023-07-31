package com.example1.pharmasales.expose.web;


import com.example1.pharmasales.application.Service.CategoryService;
import com.example1.pharmasales.application.Service.dto.category.CategorySaveDto;
import com.example1.pharmasales.persistence.entity.Category;
import com.example1.pharmasales.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoriesService;


    @GetMapping
    ResponseEntity<List<Category>> findAll(){
    List<Category> categories = categoriesService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> findById(@PathVariable("id") Long id) {
        Category category = categoriesService.findById(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping
    ResponseEntity<Category> create(@RequestBody CategorySaveDto categoryBody) {
        Category category = categoriesService.create(categoryBody);

        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    ResponseEntity<Category> edit(@PathVariable("id") Long id, @RequestBody Category categoryBody) {
        categoryBody.setId(id);

        Category category = categoriesService.edit(id , categoryBody);


        return ResponseEntity.ok(category);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Category> disabled(@PathVariable("id") Long id) {
        Category categoryDb = categoriesService.disabled(id);
        categoryDb.setState("E");


        Category category = categoryRepository.save(categoryDb);

        return ResponseEntity.ok(category);
    }
}
