package com.eduanico.picoyplaca.CmdRunner;

import com.eduanico.picoyplaca.model.Predictor;
import com.eduanico.picoyplaca.service.PredictorService;
import com.eduanico.picoyplaca.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    public static final Scanner sc = new Scanner(System.in);

    @Autowired
    private ValidatorService validatorService;

    @Autowired
    private PredictorService predictorService;

    @Override
    public void run(String...args) {
        printMenu();

    }

    public void printMenu(){
        boolean flag = false;

        while(!flag){
            System.out.println("******* SYSTEM TO VALIDATE IF PLATE NUMBER CAN BE ON THE ROAD ********");

            System.out.print("Enter a valid plate number (e. GSK-1234) : ");
            String plateNumber = sc.nextLine();
            if(!validatorService.validatePlateNumberFormat(plateNumber)){
                System.out.println("Enter a valid plate number again.");
                continue;
            }
            int lastDigit = predictorService.getLastDigit(plateNumber);


            System.out.print("Enter a valid date (dd/mm/yyyy) : ");
            String date = sc.nextLine();
            if(!validatorService.validateDateFormat(date)) {
                System.out.println("Enter a valid date again.");
                continue;
            }
            String dayOfWeek = predictorService.getDayOfWeek(date);


            System.out.print("Enter a valid time (hh:mm) : ");
            String time = sc.nextLine();
            if(!validatorService.validateTimeFormat(time)){
                System.out.println("Enter a valid time again.");
                continue;
            }

	    	Predictor predictor = new Predictor(plateNumber,date,time);
            showResults(predictor, lastDigit,dayOfWeek);

            System.out.println("Make another query (Y/N): ");
            String isContinue = sc.nextLine();
            if(isContinue.equals("N")){
                flag = true;
            }
        }
    }


    public void showResults(Predictor predictor, int lastDigit, String dayOfWeek){
        if(predictorService.validate(predictor)){
            System.out.println("You can be on road with last digit: " + lastDigit +
                    ", on day of the week: "+ dayOfWeek + ", of date: "+ predictor.getDate() + ", at time : " + predictor.getTime());
        }else{
            System.out.println("You can not be on road with last digit: " + lastDigit +
                    ", on day of the week: "+ dayOfWeek + ", of date: "+ predictor.getDate() + ", at time : " + predictor.getTime());
        }
    }


}