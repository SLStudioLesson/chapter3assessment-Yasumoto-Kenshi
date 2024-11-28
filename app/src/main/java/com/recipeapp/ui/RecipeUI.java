package com.recipeapp.ui;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Recipe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    // コンストラクタ
    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    // レシピ一覧を表示するメソッド
    private void displayRecipes() {
        try {
            // DataHandler からレシピデータを取得
            ArrayList<Recipe> recipes = dataHandler.readData();

            // レシピが存在しない場合
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
                return;
            }

            // レシピを整形して出力
            System.out.println("Recipes:");
            for (Recipe recipe : recipes) {
                System.out.println("-----------------------------------");
                System.out.println("Recipe Name: " + recipe.getName());
                System.out.print("Main Ingredients: ");
                recipe.getIngredients().forEach(ingredient -> 
                    System.out.print(ingredient.getName() + ", "));
                System.out.println("\n-----------------------------------");
            }
        } catch (IOException e) {
            // 例外処理
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // メインメニューの表示
    public void displayMenu() {
        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // レシピ一覧を表示
                        displayRecipes();
                        break;
                    case "2":
                        // TODO: 新しいレシピを追加する処理
                        System.out.println("Add New Recipe - Not Implemented");
                        break;
                    case "3":
                        // TODO: レシピ検索の処理
                        System.out.println("Search Recipe - Not Implemented");
                        break;
                    case "4":
                        // アプリケーション終了
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }
}