package com.recipeapp;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();
            
            // DataHandlerの選択（問4）
            DataHandler dataHandler;
            if ("1".equals(choice)) {
                dataHandler = new CSVDataHandler();
            } else if ("2".equals(choice)) {
                dataHandler = new JSONDataHandler();
            } else {
                System.out.println("Invalid input. Defaulting to CSV.");
                dataHandler = new CSVDataHandler();
            }

            // RecipeUIの初期化とメインメニューの表示（問4）
            RecipeUI ui = new RecipeUI(dataHandler);
            ui.displayMenu();

        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }
    }
}