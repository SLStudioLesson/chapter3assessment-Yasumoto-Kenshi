//問3で作成

package com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.ArrayList;

public class JSONDataHandler implements DataHandler {

    // モードを返す
    @Override
    public String getMode() {
        return "JSON";
    }

    // レシピデータを読み込む (未実装)
    @Override
    public ArrayList<Recipe> readData() throws IOException {
        return null; // 未実装のため null を返す
    }

    // レシピデータを書き込む (未実装)
    @Override
    public void writeData(Recipe recipe) throws IOException {
        // 未実装
    }

    // レシピデータを検索する (未実装)
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null; // 未実装のため null を返す
    }
}