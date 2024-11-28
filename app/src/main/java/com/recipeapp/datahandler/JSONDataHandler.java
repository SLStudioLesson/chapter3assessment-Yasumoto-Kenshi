package com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;

public class JSONDataHandler implements DataHandler {

    // 現在のモードを返す
    @Override
    public String getMode() {
        return "JSON";
    }

    // レシピデータを読み込む（未実装）
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        return null; // 処理は以降の設問で実装
    }

    // レシピデータを追加する（未実装）
    @Override
    public void writeData(Recipe recipe) throws IOException {
        // 処理は以降の設問で実装
    }

    // レシピを検索する（未実装）
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; // 処理は以降の設問で実装
    }
}