package davidrowantechnologies.medibuddy4;

import android.text.BidiFormatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by inspi on 1/28/2017.
 */

@SuppressWarnings("UnusedAssignment")
public class GrabMedInfo {
    public Medicine readMedDatabase(String barcode) throws IOException
    {
        boolean found= false;
        String path = new File("medDatabase.txt").getAbsolutePath();
        String readIn;
        String[] finalData = new String[6];
        Scanner reader = new Scanner(new File(path));
        String medData = null;
        while(reader.hasNext() && !found){
            readIn = reader.nextLine();
            if(readIn.contains(barcode)){
                medData = readIn;
                found = true;
                addToCurrentMeds(medData);
            }

        }
        reader.close();
        Medicine splitMedInfo = null;
        if(medData!=null) {
            splitMedInfo = splitInfo(medData);
        }
        return splitMedInfo;

    }
    public void addToCurrentMeds(String data) throws IOException {

        FileWriter currentMeds = new FileWriter("currentMeds.txt", false);
        PrintWriter writer = new PrintWriter(currentMeds);
        writer.append(data);
        writer.close();
        System.out.println("File Writer Completed, Wrote " + data + " to the file");

    }
    public ArrayList<Medicine> retrieveCurrentMeds(){
        Scanner curMedRead = new Scanner("currentMeds.txt");
        String medData;
        ArrayList<Medicine> ListOfMeds = new ArrayList<Medicine>();
        while(curMedRead.hasNext()){
            medData = curMedRead.nextLine();
            ListOfMeds.add(splitInfo(medData));
        }

        return ListOfMeds;
    }
    public Medicine splitInfo(String data){
        String[] splitData = data.split(Pattern.quote("|"));
        Medicine med = new Medicine();
        med.setBarcode(splitData[0]);
        med.setName(splitData[1]);
        med.setSideEffects(splitData[2]);
        med.setAmount(splitData[3]);
        med.setDosage(splitData[4]);
        med.setInteract(splitData[5]);
        return med;
    }
    public void removeMed(String data) throws IOException
    {
        File inputFile = new File("currentMeds.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = data;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.contains(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);

    }


}
