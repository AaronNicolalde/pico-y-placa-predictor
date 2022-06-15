package com.eduanico.picoyplaca.service.impl;

import com.eduanico.picoyplaca.model.Predictor;
import com.eduanico.picoyplaca.service.PredictorService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Service
public class PredictorServiceImpl implements PredictorService {


    @Override
    public int getLastDigit(String plateNumber) {
        int len = plateNumber.length();
        return Integer.parseInt(String.valueOf(plateNumber.charAt(len-1)));
    }

    @Override
    public String getDayOfWeek(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            Date date1 = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
            String dayOfWeekString = formatter.format(cal.getTime());
            return dayOfWeekString;

        }catch(Exception e){
            System.out.println(e);
        }

        return null;
    }

    @Override
    public boolean validate(Predictor predictor) {

        return true;
    }


}


