package com.eduanico.picoyplaca.service.impl;

import com.eduanico.picoyplaca.model.Predictor;
import com.eduanico.picoyplaca.service.PredictorService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;


@Service
public class PredictorServiceImpl implements PredictorService {
    Logger logger = Logger.getLogger(PredictorServiceImpl.class.getName());

    @Override
    public int getLastDigit(@Valid String plateNumber) {
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
            return formatter.format(cal.getTime());
        }catch(Exception e){
            logger.warning("Exception thrown :" + e);
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
            return !validateDateAndDigit(day, lastDigit);
        }else{
            return true;
        }
    }


    public boolean validateMorningTime(String time){
        String timePattern = "hh:mm";
        try{
            Date actual = new SimpleDateFormat(timePattern).parse(time.trim());
            Date initTime = new SimpleDateFormat(timePattern).parse("07:00");
            Date endTime = new SimpleDateFormat(timePattern).parse("09:30");

            return actual.after(initTime) && actual.before(endTime);
        }
        catch(Exception e){
            logger.warning("Exception thrown :" + e);
            return false;
        }
    }

    public boolean validateAfternoonTime(String time){
        String timePattern = "hh:mm";
        try{
            Date actual = new SimpleDateFormat(timePattern).parse(time.trim());
            Date initTime = new SimpleDateFormat(timePattern).parse("16:00");
            Date endTime = new SimpleDateFormat(timePattern).parse("19:30");

            return actual.after(initTime) && actual.before(endTime);
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean validateDateAndDigit(String day, int lastDigit) {
        if(day.equalsIgnoreCase("Domingo") || day.equalsIgnoreCase("Sábado")){
            return false;
        }
        if((lastDigit == 1 || lastDigit == 2) && day.equalsIgnoreCase("Lunes")) {
            return true;
        }
        if((lastDigit == 3 || lastDigit == 4) && day.equalsIgnoreCase("Martes")){
            return true;
        }
        if( (lastDigit == 5 || lastDigit == 6) && day.equalsIgnoreCase("Miércoles")){
            return true;
        }
        if( (lastDigit == 7 || lastDigit == 8) && day.equalsIgnoreCase("Jueves")){
            return true;
        }
        if( (lastDigit == 9 || lastDigit == 0) && day.equalsIgnoreCase("Viernes")){
            return true;
        }
        return true;

    }
}


