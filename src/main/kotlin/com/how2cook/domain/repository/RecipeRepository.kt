package com.how2cook.domain.repository

import com.how2cook.domain.entity.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository : JpaRepository<Recipe, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Recipe>
}