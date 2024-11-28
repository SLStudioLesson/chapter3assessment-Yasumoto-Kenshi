package com.recipeapp;

import com.recipeapp.datahandler.*;
import com.recipeapp.ui.RecipeUI;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // ファイル形式選択メニューの表示
        System.out.println("ファイル形式選択メニュー");
        System.out.println("Choose the file format:");
        System.out.println("1. CSV");
        System.out.println("2. JSON");
        System.out.print("Select (1/2): ");

        // ユーザーの入力を取得
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        // ユーザーの選択に応じてデータハンドラーを選択
        DataHandler dataHandler;
        if ("2".equals(choice)) {
            dataHandler = new JSONDataHandler();
        } else {
            dataHandler = new CSVDataHandler();
        }

        // 選択されたデータハンドラーのモードを表示
        System.out.println("Current mode: " + dataHandler.getMode());

        // RecipeUI にデータハンドラーを渡してメインメニューを表示
        RecipeUI recipeUI = new RecipeUI(dataHandler);
        recipeUI.displayMenu();
    }
}