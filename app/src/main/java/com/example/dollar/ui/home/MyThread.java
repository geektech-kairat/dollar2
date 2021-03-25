package com.example.dollar.ui.home;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MyThread extends Thread {
    private Document document;
    private ArrayList<String> byeMid = new ArrayList<String>();
    private ArrayList<String> saleMid = new ArrayList();
    private ArrayList<String> byeBest = new ArrayList();
    private ArrayList<String> saleBest = new ArrayList();


    public ArrayList<String> getByeMid() {
        return byeMid;
    }

    public ArrayList<String> getSaleMid() {
        return saleMid;
    }

    public ArrayList<String> getByeBest() {
        return byeBest;
    }

    public ArrayList<String> getSaleBest() {
        return saleBest;
    }

    @Override
    public void run() {
        try {
            document = Jsoup.connect("https://valuta.kg/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.getElementsByClass("kurs-table");
//        Log.e("TAG", "run: " + elements.get(1).child(1).child(1).child(0).text());
//        Log.e("TAG", "run2: " + elements.get(2).child(1).child(0).child(0).text());


        for (int i = 0; i < 3; i++) {
            byeMid.add(i, elements.get(1).child(1).child(i).child(0).text());
            saleMid.add(i, elements.get(1).child(1).child(i).child(1).text());
            byeBest.add(i, elements.get(2).child(1).child(i).child(0).text());
            saleBest.add(i, elements.get(2).child(1).child(i).child(1).text());
        }

//
//        Log.e("TAG", "run: " + byeMid.toString());
//        Log.e("TAG", "run: " + saleMid.toString());
//        Log.e("TAG", "run: " + byeBest.toString());
//        Log.e("TAG", "run: " + saleBest.toString());

    }

}
