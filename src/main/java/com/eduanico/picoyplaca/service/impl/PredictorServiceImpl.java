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
            String dayOfWeek = formatter.format(cal.getTime());
            return dayOfWeek;
        }catch(Exception e){
            System.out.println(e);
        }

        return null;
    }

    @Override
    public boolean validate(Predictor predictor) {
        String time = predictor.getTime();
        String date = predictor.getDate();
        String plateNumber = predictor.getPlateNumber();
        if(validateMorningTime(time) || validateAfternoonTime(time)){
            String day = getDayOfWeek(date);
            int lastDigit = getLastDigit(plateNumber);
            if(validateDateAndDigit(day, lastDigit)){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }


    public boolean validateMorningTime(String time){
        String actualTime = new String(time);
        try{
            Date actual = new SimpleDateFormat("hh:mm").parse(actualTime.trim());
            Date initTime = new SimpleDateFormat("hh:mm").parse("07:00");
            Date endTime = new SimpleDateFormat("hh:mm").parse("09:30");

            if( actual.after(initTime) && actual.before(endTime) ){
                return true;
            }else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean validateAfternoonTime(String time){
        String actualTime = new String(time);
        try{
            Date actual = new SimpleDateFormat("hh:mm").parse(actualTime.trim());
            Date initTime = new SimpleDateFormat("hh:mm").parse("16:00");
            Date endTime = new SimpleDateFormat("hh:mm").parse("19:30");

            if( actual.after(initTime) && actual.before(endTime) ){
                return true;
            }else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    private boolean validateDateAndDigit(String day, int lastDigit) {
        if(day.equalsIgnoreCase("Domingo") || day.equalsIgnoreCase("Sábado")){
            return false;
        }else if((lastDigit == 1 || lastDigit == 2) && day.equalsIgnoreCase("Lunes")) {
            return true;
        }else if((lastDigit == 3 || lastDigit == 4) && day.equalsIgnoreCase("Martes")){
            return true;
        }else if( (lastDigit == 5 || lastDigit == 6) && day.equalsIgnoreCase("Miércoles")){
            return true;
        }else if( (lastDigit == 7 || lastDigit == 8) && day.equalsIgnoreCase("Jueves")){
            return true;
        }else if( (lastDigit == 9 || lastDigit == 0) && day.equalsIgnoreCase("Viernes")){
            return true;
        }else{
            return true;
        }
    }
}


