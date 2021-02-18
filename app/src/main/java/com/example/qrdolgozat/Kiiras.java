package com.example.qrdolgozat;


import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Kiiras {
    public static void kiir(String szoveg) throws IOException {
        Date datum = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formazottDatum = df.format(datum);
        String sor = String.format("%s,%s",szoveg,formazottDatum);
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            File file = new File(Environment.getExternalStorageDirectory(),"gps_adatok.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true),1024);
            bw.append(sor);
            bw.append(System.lineSeparator());
            bw.close();
        }
    }
}
