package test;

import view.QuanLyBenhAnView;


public class TestMain {
    public static void main(String[] args) {
        try {
            QuanLyBenhAnView frame = new QuanLyBenhAnView();
            frame.showDisplay();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
