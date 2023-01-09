package com.example.roomdatabase07062022.utils;

import android.util.Log;

import com.example.roomdatabase07062022.BuildConfig;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaCsvHelper {
    private String filePath;

    public JavaCsvHelper(String filePath) {
        this.filePath = filePath;
    }

    public void writeData(String fileName, List<String[]> dataList) {
        File file = new File(filePath + "/" + fileName);

        try (FileWriter fw = new FileWriter(file);
             CSVWriter cw = new CSVWriter(fw)) {
            for (String[] strings : dataList) {
                cw.writeNext(strings);
            }
        } catch (IOException e) {
            Log.d("CCC", e.toString());
        }
    }

    public List<String[]> readCsvData(String fileName) {
        File file = new File(filePath + "/" + fileName);
        List<String[]> dataArray = new ArrayList<>();

        try (FileReader fr = new FileReader(file);
             CSVReader reader = new CSVReader(fr)) {
            for (String[] data : reader) {
                dataArray.add(data);
            }

            return dataArray;
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }

            return new ArrayList<>();
        }
    }
}
