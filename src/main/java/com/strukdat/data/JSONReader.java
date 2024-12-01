package com.strukdat.data;

import com.strukdat.model.Tree;
import com.strukdat.gimmick.GimmickInterface;
import com.strukdat.gimmick.RandomGimmick;
import com.strukdat.gimmick.TicTacToeGimmick;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONReader {
    public static void loadJsonData(Tree<String, String> rbTree, String resourcePath) {
        try (InputStream jsonStream = JSONReader.class.getResourceAsStream(resourcePath)) {
            if (jsonStream != null) {
                JSONArray jsonArray = new JSONArray(new JSONTokener(jsonStream));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String key = jsonObject.keys().next();
                    String value = jsonObject.getString(key);
                    GimmickInterface gimmick = null;
                    if (jsonObject.has("gimmick")) {
                        String gimmickType = jsonObject.getString("gimmick");
                        switch (gimmickType) {
                            case "random":
                                gimmick = new RandomGimmick();
                                break;
                            case "tictactoe":
                                gimmick = new TicTacToeGimmick();
                                break;
                        }
                    }
                    if (gimmick != null) {
                        rbTree.add(key, value, gimmick);
                    } else {
                        rbTree.add(key, value);
                    }
                }
            } else {
                System.err.println("Failed to load data.json. The resource is not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}