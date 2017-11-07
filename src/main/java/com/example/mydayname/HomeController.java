package com.example.mydayname;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


@Controller
public  class HomeController{
    @RequestMapping("/loadform")
    public String loadFormPage(){
        return "formtemplate";

    }
    @RequestMapping("/processform")
    public  String loadFormPage(@RequestParam("date")String date, @RequestParam("gender") String gender, Model model){
        model.addAttribute("dateval",date);
        model.addAttribute("genderval", gender);
        Scanner keyboard = new Scanner(System.in);
      //Date from the user
        LocalDate userDate= null;


        //Date Formatter
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dayweek = DateTimeFormatter.ofPattern("EEEE");
       userDate = LocalDate.parse(date,dTF);
//        System.out.println("Enter a date in the past (dd/MM/yyyy");
//
//        userDate=LocalDate.parse(keyboard.nextLine(),dTF);
        System.out.println("Date format dd/mm/yyyy: "+userDate.format(dayweek));

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEEE");
        //Format day of week using datetimeformatter dayweek
        String dayofweek=userDate.format(dayweek);
        String myfemaledayname="null";
        String mymaledayname="null";
        if (dayofweek.equalsIgnoreCase("monday"))
        {
            myfemaledayname="Adjoa";
            mymaledayname="Kojo";

        }
        else if(dayofweek.equalsIgnoreCase("tuesday"))

        {
            myfemaledayname="Abena";
            mymaledayname="Kwabena";

        }
        else if(dayofweek.equalsIgnoreCase("wednesday"))

        {
            myfemaledayname="Akua";
            mymaledayname="Kweku";

        }

        else if(dayofweek.equalsIgnoreCase("thursday"))

        {
            myfemaledayname="Yaa";
            mymaledayname="Yaw";

        }
        else if(dayofweek.equalsIgnoreCase("friday"))

        {
            myfemaledayname="Afua";
            mymaledayname="Kofi";

        }

        else if(dayofweek.equalsIgnoreCase("saturday"))

        {
            myfemaledayname="Ama";
            mymaledayname="Kwame";

        }
        else if (dayofweek.equalsIgnoreCase("sunday"))

        {
            myfemaledayname="Akosua";
            mymaledayname="Kwesi";

        }

        model.addAttribute("myfemaledaynameval",myfemaledayname);
        model.addAttribute("mymaledaynameval", mymaledayname);
        if(gender.equalsIgnoreCase("f")){
            model.addAttribute("mynameval", myfemaledayname);
        }
        if(gender.equalsIgnoreCase("m")){
            model.addAttribute("mynameval", mymaledayname);
        }
        if(gender.equalsIgnoreCase("b")){
            model.addAttribute("mynameval", "Female:  "+ myfemaledayname +   "    "  +   "      Male:  "  +mymaledayname);
        }
        return "name";
    }

    public static String getDay(Date date){
                        return "";

    }
}
