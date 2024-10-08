package com.how2cook.domain.entity

import com.how2cook.domain.entity.BaseEntity
import com.how2cook.domain.entity.Ingredient
import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.Duration

@Entity
class Recipe(
    name: String,
    description: String,
    cookingTime: Duration?,
    servingSize: Int,
    method: String?,
    createdAt: LocalDateTime?,
    updatedAt: LocalDateTime?,
    isActive: Boolean
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    var id: Long? = null

    var name: String = name

    var description: String = description

    var cookingTime: Duration? = cookingTime

    var servingSize: Int = servingSize

    var method: String? = method

    var createdAt: LocalDateTime? = createdAt

    var updatedAt: LocalDateTime? = updatedAt

    var isActive: Boolean = isActive

    @OneToMany(
        targetEntity = Ingredient::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    )
    @JoinColumn(name = "recipe_id")

    var ingredients: MutableList<Ingredient> = mutableListOf()

    fun addIngredient(ingredients: MutableList<Ingredient>?) {
        if (ingredients != null) {
            this.ingredients.addAll(ingredients)
        }
    }
}