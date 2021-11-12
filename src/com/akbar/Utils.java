package com.akbar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class Utils {

    /**
     * @param object Object
     * @return Strings
     */
    public static String convertToString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param json String
     * @return ArrayList
     */
    public static ArrayList<Model> convertToJson(String json) {
        try {
            return new ObjectMapper().readValue(json, new TypeReference<ArrayList<Model>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
