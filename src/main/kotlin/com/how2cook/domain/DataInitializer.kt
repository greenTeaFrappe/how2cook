package com.how2cook.domain

import com.how2cook.domain.entity.Ingredient
import com.how2cook.domain.entity.Recipe
import com.how2cook.domain.entity.RecipeIngredient
import com.how2cook.domain.repository.IngredientRepository
import com.how2cook.domain.repository.RecipeRepository
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.LocalDateTime

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val recipeRepository: RecipeRepository,
    private val ingredientRepository: IngredientRepository
) {
    @PostConstruct
    fun initializeData() {
        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val ingredients = mutableListOf<Ingredient>(
            Ingredient(
                name = "계란",
                type = "MEAT",
                isActive = true
            ),
            Ingredient(
                name = "간장",
                type = "SEASONINGS",
                isActive = true
            ),
            Ingredient(
                name = "즉석밥",
                type = "PROCESSED",
                isActive = true
            )
        )
        ingredientRepository.saveAll(ingredients)

        val recipes = mutableListOf<Recipe>(
            Recipe(
                name = "간장계란밥",
                description = "첫번째 자취 요리 레시피",
                cookingTime = Duration.ofMinutes(10),
                servingSize = 1,
                method = "",
                createdAt = LocalDateTime.now(),
                updatedAt = null,
                isActive = true
            )
        )
        recipeRepository.saveAll(recipes)

        recipes.forEach { recipe ->
            ingredients.forEach { ingredient ->
                val recipeIngredient = RecipeIngredient(recipe = recipe, ingredient = ingredient)
                recipe.addIngredient(mutableListOf(ingredient)) // 재료를 레시피에 추가
            }
            recipeRepository.save(recipe) // 각 레시피를 저장
        }
    }
}