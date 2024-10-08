package com.how2cook.domain.repository

import com.how2cook.domain.entity.Ingredient
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository : JpaRepository<Ingredient, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Ingredient>
}