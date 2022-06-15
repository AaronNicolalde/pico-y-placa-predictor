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
        return 0;
    }

    @Override
    public String getDayOfWeek(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(!date.isEmpty()){
            try{
                Date date1 = sdf.parse(date);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date1);
                SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
                String dayOfWeekString = formatter.format(cal.getTime());

                System.out.println("Day of the Week - in Text :: " + dayOfWeekString);
                return dayOfWeekString;
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return null;
    }

    @Override
    public boolean validate(Predictor predictor) {
        return false;
    }
}


