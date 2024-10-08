package com.how2cook.domain.entity

import com.how2cook.domain.entity.RecipeIngredient
import com.how2cook.domain.constant.IngredientType
import com.how2cook.domain.entity.BaseEntity
import jakarta.persistence.*

@Entity
class Ingredient(
    name: String,
    type: String,
    isActive: Boolean
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    var id: Long? = null

    var name: String = name

    var isActive: Boolean = isActive

    @Column(name = "ingredient_type")
    @Enumerated(value = EnumType.STRING) // 자료형이 enum클래스일때 사용하는 어노테이션 EnumType.STRING : 이름을 그대로 넣어줌
    var type: IngredientType = IngredientType.valueOf(type)

    @ManyToOne(
        targetEntity = RecipeIngredient::class,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL]
    ) // 엔티티에서 영속성 컨테스트에 변화가 있었을 때 그 자식 엔티티도 함께 변화 적용
    @JoinColumn(name = "ingredient_id")
    var recipeIngredient: MutableList<RecipeIngredient> = mutableListOf()

}