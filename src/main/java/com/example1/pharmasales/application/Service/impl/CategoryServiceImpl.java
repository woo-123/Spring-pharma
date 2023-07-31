package com.example1.pharmasales.application.Service.impl;

import com.example1.pharmasales.application.Service.CategoryService;
import com.example1.pharmasales.application.Service.dto.category.CategorySaveDto;
import com.example1.pharmasales.persistence.entity.Category;
import com.example1.pharmasales.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        List<Category> categories = (List<Category>)
                categoryRepository.findAll();

                return categories;
    }

    @Override
    public Category findById(Long id) {
        Category category = categoryRepository.findById(id).get();

        return category;
    }

    @Override
    public Category create(CategorySaveDto categoryBody) {
        Category categorySave = new Category();
        categorySave.setName(categoryBody.getName());
        categorySave.setDescription(categoryBody.getDescription());

        categorySave.setKeyword(categoryBody.getName());
        categorySave.setState("A");
        categorySave.setCreateAt(LocalDateTime.now());

        Category category = categoryRepository.save(categorySave);

        return category;
    }

    @Override
    public Category edit(Long id, Category categoryBody) {
        categoryBody.setId(id);

        Category category = categoryRepository.save(categoryBody);

        return category;
    }

    @Override
    public Category disabled(Long id) {
        Category categoryDb = categoryRepository.findById(id).get();
        categoryDb.setState("E");


        Category category = categoryRepository.save(categoryDb);

        return category;
    }
}
