package com.example.blogappapis.controllers;

import com.example.blogappapis.payloads.CategoryDto;
import com.example.blogappapis.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto cateogDto){
        CategoryDto createCategory=this.categoryService.createCategory(cateogDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer catId)
    {
       CategoryDto updatedCategory=this.categoryService.updateCategory(categoryDto,catId);
       return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
    }

    @DeleteMapping("/{catId}")
    public void DeleteCategory(@PathVariable Integer catId)
    {
        this.categoryService.deleteCategory(catId);
//        return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto categoryDto =this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories=this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }




}
