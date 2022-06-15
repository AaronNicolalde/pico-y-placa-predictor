package com.eduanico.picoyplaca.CmdRunner;

import com.eduanico.picoyplaca.service.PredictorService;
import com.eduanico.picoyplaca.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    public Scanner sc = new Scanner(System.in);

    @Autowired
    private ValidatorService validatorService;

    @Autowired
    private PredictorService predictorService;

    @Override
    public void run(String...args) throws Exception {
        printMenu();

    }

    public void printMenu(){
        boolean flag = false;

        while(!flag){
            System.out.println("******* SYSTEM TO VALIDATE IF PLATE NUMBER CAN BE ON THE ROAD ********");

            System.out.println("Enter a valid plate number (e. GSK-1234) : ");
            String plateNumber = sc.nextLine();

            System.out.println("Enter a valid date (dd/mm/yyyy) : ");
            String date = sc.nextLine();

            System.out.println("Enter a valid time (hh:mm) : ");
            String time = sc.nextLine();

//		Predictor predictor = new Predictor(plateNumber,date,time);

//		System.out.println(predictorService.getDayOfWeek(predictor.getDate()));


            System.out.println("Make another query (Y/N): ");
            String isContinue = sc.nextLine();
            if(isContinue.equals("N")){
                flag = true;
            }

        }

    }

}