package com.how2cook.domain.entity

import jakarta.persistence.*

@Entity
class RecipeIngredient(recipe: Recipe, ingredient: Ingredient) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_ingredient_id")
    var id: Long? = null

    @ManyToOne(targetEntity = Recipe::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    var recipe: Recipe = recipe

    @OneToMany(targetEntity = Ingredient::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", nullable = false)
    var ingredient: Ingredient = ingredient
}