//問1でRecipeクラスを作成

package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe {
    private String name; // レシピの名前
    private ArrayList<Ingredient> ingredients; // 材料リスト

    // コンストラクタ
    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    // レシピ名を取得
    public String getName() {
        return name;
    }

    // 材料リストを取得
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
}