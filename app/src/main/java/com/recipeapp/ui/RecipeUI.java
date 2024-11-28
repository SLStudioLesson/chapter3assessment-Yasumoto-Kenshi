package com.recipeapp.ui;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Recipe;

import java.io.IOException;
import java.util.ArrayList;

// ユーザーインターフェースを担当するクラス
// ユーザー操作を処理して、DataHandlerを介してデータを操作
public class RecipeUI {
    private DataHandler dataHandler; // データ操作を委譲するDataHandler

    // コンストラクタ
    // 指定されたDataHandlerを使用してインスタンスを初期化
    public RecipeUI(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    // メインメニューを表示し、ユーザーの選択を処理
    public void displayMenu() {
        // メインメニューの表示
        System.out.println("Main Menu:");
        System.out.println("1: Display Recipes"); // レシピ一覧表示
        System.out.println("2: Add New Recipe");  // 新しいレシピの追加
        System.out.println("3: Search Recipe");   // レシピの検索 (未実装)
        System.out.println("4: Exit Application");// アプリケーションの終了
        System.out.print("Please choose an option: ");

        // ユーザー入力を取得
        int option = new java.util.Scanner(System.in).nextInt();

        // ユーザーの選択に基づいて処理を実行
        switch (option) {
            case 1 -> displayRecipes(); // レシピ一覧を表示
            case 2 -> addNewRecipe();   // 新しいレシピを追加
            // 他の選択肢は未実装
        }
    }

    // レシピ一覧を表示するメソッド
    private void displayRecipes() {
        System.out.println("Recipes:");
        try {
            // DataHandlerからレシピリストを取得
            ArrayList<Recipe> recipes = dataHandler.readData();

            // レシピが存在しない場合の処理
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
            } else {
                System.out.println("-----------------------------------");
                // 各レシピを整形して表示
                recipes.forEach(recipe -> {
                    System.out.println("Recipe Name: " + recipe.getName());
                    System.out.print("Main Ingredients: ");
                    System.out.println(String.join(", ", recipe.getIngredients().stream()
                            .map(ingredient -> ingredient.getName()).toList()));
                    System.out.println("-----------------------------------");
                });
            }
        } catch (IOException e) {
            // ファイル読み込みエラーの表示
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 新しいレシピを追加するメソッド
    private void addNewRecipe() {
        System.out.println("Adding a new recipe.");

        // ユーザーからレシピ名を入力
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();

        // ユーザーから材料を入力
        ArrayList<String> ingredients = new ArrayList<>();
        System.out.println("Enter ingredients (type 'done' when finished):");
        while (true) {
            System.out.print("Ingredient: ");
            String ingredient = scanner.nextLine();
            if ("done".equalsIgnoreCase(ingredient)) break; // 'done'で終了
            ingredients.add(ingredient);
        }

        try {
            // 入力されたデータで新しいレシピを作成
            Recipe newRecipe = new Recipe(name, new ArrayList<>(
                    ingredients.stream().map(com.recipeapp.model.Ingredient::new).toList()
            ));
            // DataHandlerを介してCSVにレシピを追加
            dataHandler.writeData(newRecipe);
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            // ファイル書き込みエラーの表示
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}