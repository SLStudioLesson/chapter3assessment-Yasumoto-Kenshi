package com.recipeapp.datahandler;

import com.recipeapp.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// CSV形式のレシピデータを扱うクラス
// DataHandlerインターフェースを実装
public class CSVDataHandler implements DataHandler {

    // レシピデータを格納するCSVファイルのパス
    private String filePath;

    // デフォルトコンストラクタ
    // デフォルトのファイルパスを指定
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    // ファイルパスを指定するコンストラクタ
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // データハンドラーのモードを返す
    // CSVモードとして固定
    @Override
    public String getMode() {
        return "CSV";
    }

    // CSVファイルからデータを読み込み、レシピのリストを返す
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>(); // レシピを格納するリスト

        // ファイルを読み込む
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 行を分割してレシピ名と材料リストを取得
                String[] parts = line.split(",", 2);
                if (parts.length < 2) continue; // 不正な行はスキップ

                // レシピ名を取得
                String name = parts[0].trim();

                // 材料リストを作成
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                Arrays.stream(parts[1].split(","))
                        .map(String::trim) // 材料名をトリム
                        .forEach(ingredient -> ingredients.add(new Ingredient(ingredient)));

                // レシピを作成してリストに追加
                recipes.add(new Recipe(name, ingredients));
            }
        }

        // レシピリストを返す
        return recipes;
    }

    // CSVファイルに新しいレシピを追加する
    @Override
    public void writeData(Recipe recipe) throws IOException {
        // ファイルを追記モードで開く
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // レシピ名と材料リストをカンマ区切りで書き込む
            writer.write(recipe.getName() + "," +
                    String.join(", ", recipe.getIngredients().stream().map(Ingredient::getName).toList()));
            writer.newLine(); // 改行
        }
    }

    // キーワードでレシピを検索するメソッド (未実装)
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; // 未実装
    }
}