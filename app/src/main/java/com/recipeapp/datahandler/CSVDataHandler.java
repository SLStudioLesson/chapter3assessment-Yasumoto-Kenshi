package com.recipeapp.datahandler;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "src/main/resources/recipes.csv";
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();

        // ファイルを読み込み
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // CSVの各行をパース
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue; // 不正な行をスキップ

                String recipeName = parts[0];
                String[] ingredientNames = parts[1].split(", ");
                ArrayList<Ingredient> ingredients = new ArrayList<>();

                // 材料をIngredientオブジェクトに変換
                for (String ingredientName : ingredientNames) {
                    ingredients.add(new Ingredient(ingredientName));
                }

                // Recipeオブジェクトを作成してリストに追加
                recipes.add(new Recipe(recipeName, ingredients));
            }
        }

        return recipes;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        // このメソッドは未実装
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; // このメソッドは未実装
    }
}