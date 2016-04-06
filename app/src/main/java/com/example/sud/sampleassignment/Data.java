package com.example.sud.sampleassignment;

import java.util.ArrayList;

/**
 * Created by Sudarshan on 05/04/16.
 */
public class Data {

    public String name;
    public double price;
    ArrayList<Integer> qtys;
    ArrayList<Integer> imageIds;

    Data(String name, double price, ArrayList<Integer> qtys, ArrayList<Integer> imageIds) {

        this.name = name;
        this.price = price;
        this.qtys = qtys;
        this.imageIds = imageIds;
    }
}
