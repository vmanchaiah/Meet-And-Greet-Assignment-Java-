import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class PortfolioGenerator {
    public static void main(String[] args)  {
        Scanner myObj = new Scanner(System.in);
       //collecting user info
        String name = SafeInput.getString(myObj, "Please enter your name : ");
        String email = SafeInput.getEmail(myObj, "Please enter valid email : ");
        String background = SafeInput.getString(myObj, "Please enter your personal background : ");
        ArrayList<String> languages = SafeInput.getArrayOfStrings(myObj, "What programming languages do you know?");
        ArrayList<String> achievement = SafeInput.getArrayOfStrings(myObj, "What are your achievements?");

        FileWriter file = null;
        try {
            //writing collected info to a file
            file = new FileWriter("MeetAndGreet.txt");
            file.write("```\n");
            file.write("************************************************\n");
            file.write(name);
            file.write("\n************************************************\n");
            file.write("\nemail: ");
            file.write(email);
            file.write("\n");
            file.write("\n** Personal Background:\n");
            file.write("----------------------------\n");
            file.write(background);
            file.write("\n");
            file.write("\n** Programming Languages:\n");
            file.write("----------------------------\n");

            for(int i = 0; i < languages.size(); i++) {
                file.write(String.valueOf(i+1));
                file.write(". ");
                file.write(languages.get(i).toString());
                file.write("\n");
            }
            file.write("\n** Achievements and Things I would like to share:\n");
            file.write("---------------------------------------------------\n");
            for(int i = 0; i < achievement.size(); i++) {
                file.write(String.valueOf(i+1));
                file.write(". ");
                file.write(achievement.get(i).toString());
                file.write("\n");
            }
            file.write("\n************************************************\n");
            file.write("```");

        } catch (IOException e) {
        //prints the code execution path
        e.printStackTrace();
    }
        // to prevent resource leaks
        finally {
            if (file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

  }

}
