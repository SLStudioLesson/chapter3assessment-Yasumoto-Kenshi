package com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;

public interface DataHandler {

    // 現在のモードを返します
    String getMode();

    // レシピデータを読み込み、Recipeオブジェクトのリストとして返します
    ArrayList<Recipe> readData() throws IOException;

    // 指定されたRecipeオブジェクトを追加します
    void writeData(Recipe recipe) throws IOException;

    // 指定されたキーワードでレシピを検索し、一致するRecipeオブジェクトのリストを返します
    ArrayList<Recipe> searchData(String keyword) throws IOException;
}