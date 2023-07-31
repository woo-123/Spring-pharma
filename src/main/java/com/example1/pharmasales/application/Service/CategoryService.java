package com.example1.pharmasales.application.Service;

import com.example1.pharmasales.application.Service.dto.category.CategorySaveDto;
import com.example1.pharmasales.persistence.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(Long id);

    Category create(CategorySaveDto categoryBody);
    Category edit(Long id, Category categoryBody);
    Category disabled(Long id);


}
