import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PersonReader {

    public static void main(String[] args)  {
        try {
            JFileChooser chooser = new JFileChooser(".");

            //launches dialog window to open file
            int returnValue = chooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                //User successfully selected a file
                //Creating a File object and assigning it to selectedFile variable
                File selectedFile = chooser.getSelectedFile();

                //System.out.println(selectedFile.getAbsolutePath());

                //creating buffered reader for the selected file
                BufferedReader objReader = new BufferedReader(new FileReader(selectedFile));

                String strCurrentLine;
                boolean firstRow = true;

                //while there is info to read from the file, the loop will execute
                while ((strCurrentLine = objReader.readLine()) != null) {
                    //columns are identified by using comma as a delimiter(separates things)
                    String[] studentInfo = strCurrentLine.split(",");
                    int numberOfItems = studentInfo.length;

                    //formatting and displaying the info read from the file
                    for (int i = 0; i < numberOfItems; i++) {
                        String column = studentInfo[i];
                        if (firstRow) {
                            System.out.printf("%-15s", column.toUpperCase());
                        } else {
                            System.out.printf("%-15s", column);
                        }

                    }
                    System.out.print("\n");
                    if (firstRow) {
                        System.out.println("===================================================================");
                        firstRow = false;
                    }


                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}


