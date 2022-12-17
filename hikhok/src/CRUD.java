import java.io.*;
import java.util.Scanner;

public class CRUD {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while(true){        
            System.out.println("--------------------------------------------------------");
            System.out.println("1. INSERT DATA");
            System.out.println("2. DISPLAY INFORMATION");
            System.out.println("3. UPDATE USER DATA");
            System.out.println("4. DELETE USER DATA");
            System.out.println("5. TO EXIT");
            System.out.print("PLEASE CHOOSE AN OPTION: ");
            int choice = scanner.nextInt();
            System.out.println("--------------------------------------------------------");
            switch (choice) {
                case 1:
                // INSERT DATA
                System.out.print("ENTER YOUR ID: ");
                int id = scanner.nextInt();
                System.out.print("ENTER YOUR FIRST NAME: ");
                String firstName = scanner.next();
                System.out.print("ENTER YOUR MIDDLE NAME: ");
                String middleName = scanner.next();
                System.out.print("ENTER YOUR LAST NAME: ");
                String lastName = scanner.next();

                // SAVE THE RECORD TO A TXT FILE NAMED records.txt
                //BufferedWriter is used to write text to a character-output stream, 
                //buffering characters so as to provide for the efficient writing of single characters, arrays, and strings.
                BufferedWriter writer = new BufferedWriter(new FileWriter("records.txt", true));
                //BufferedWriter used writer.write to write those info (id, firstname, middlename,lastname) to a records.txt file
                writer.write(id + "," + firstName + "," + middleName + "," + lastName + "\n");
                writer.close();
                System.out.println("--------------------------------------------------------");
                System.out.println("RECORD ADDED SUCCESSFULLY");
                System.out.println("--------------------------------------------------------");
                break;

                case 2:
                // DISPLAY DATA
                //BufferedReader used to read text from a character-input stream, 
                //buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
                //FileReader is used to read data in records.txt
                BufferedReader reader = new BufferedReader(new FileReader("records.txt"));
                String line;
                //this loop reads of the data in records.txt until the value of line which is declared as reader is null
                while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                //printing all the data from records.txt
                System.out.println("ID: " + fields[0] + ", Name: " + fields[1] + " " + fields[2] + " " + fields[3]);
                }
                reader.close();
                break;

                case 3:
                // UPDATE DATA
                System.out.println("--------------------------------------------------------");
                System.out.print("ENTER THE ID YOU WISH TO UPDATE: ");
                int updateId = scanner.nextInt();
                // READS THE RECORD OF DATA IN records.txt
                BufferedReader updateReader = new BufferedReader(new FileReader("records.txt"));
                String updateLine;
                StringBuilder sb = new StringBuilder();
                boolean recordFound = false;
                //The BufferedReader is used to read each line of the file, one at a time, using a while loop
                while ((updateLine = updateReader.readLine()) != null) {
                    String[] updateFields = updateLine.split(",");
                        if (Integer.parseInt(updateFields[0]) == updateId) {
                        // Update the record
                        System.out.print("ENTER YOUR NEW FIRST NAME: ");
                        String newFirstName = scanner.next();
                        System.out.print("ENTER YOUR NEW MIDDLE NAME: ");
                        String newMiddleName = scanner.next();
                        System.out.print("ENTER YOUR NEW LAST NAME: ");
                        String newLastName = scanner.next();
                        System.out.println("--------------------------------------------------------");
                        //sb will later be used to write the updated records back to the records.txt file.
                        sb.append(updateId + "," + newFirstName + "," + newMiddleName + "," + newLastName + "\n");
                        //recordFound is set to true to indicate that a record with a matching ID was found in the records.txt and 
                        //has been updated 
                        recordFound = true;
                        } 
                        else {
                            sb.append(updateLine + "\n");
                        }
                }
                updateReader.close();

                if (recordFound) {
                    // SAVES THE NEW DATA INTO records.txt
                    BufferedWriter updateWriter = new BufferedWriter(new FileWriter("records.txt"));
                    //updateWriter writes the new records back in record.txt
                    updateWriter.write(sb.toString());
                    updateWriter.close();
                    System.out.println("RECORD UPDATED SUCCESSFULLY!");
                    break;
                }
                
                case 4:
                // DELETE DATA
                System.out.print("ENTER THE ID YOU WISH TO DELETE: ");
                int deleteId = scanner.nextInt();
                // READ THE RECORDS OF DATA FROM THE records.txt
                BufferedReader deleteReader = new BufferedReader(new FileReader("records.txt"));

                String deleteLine;
                StringBuilder deleteSb = new StringBuilder();
                //deleteRecordFound is set to true to indicate that a record with a matching ID was found
                boolean deleteRecordFound = false;
                while ((deleteLine = deleteReader.readLine()) != null) {
                    String[] deleteFields = deleteLine.split(",");
                        if (Integer.parseInt(deleteFields[0]) == deleteId) {
                        deleteRecordFound = true;
                        } 
                        else {
                            //this line is appended to a StringBuilder called deleteSb
                            deleteSb.append(deleteLine + "\n");
                        }
                }
                //it is when the value of deleteLine is null in while loop
                deleteReader.close();
                
                if (deleteRecordFound) {
                    // SAVES THE UPDATED RECORD TO records.txt
                    //BufferedWriter is connected to a FileWriter which is used to write the records.txt file
                    //BufferedWriter is used to write the contents of the deleteSb which now contains the all of the records 
                    //except the deleted record
                    BufferedWriter deleteWriter = new BufferedWriter(new FileWriter("records.txt"));
                    deleteWriter.write(deleteSb.toString());
                    //deleteWriter is close and a message is printed to the terminal indicating that 
                    //the record is deleted
                    deleteWriter.close();
                    System.out.println("RECORD DELETED SUCCESSFULLY!");
                    } 
                else {
                    //if a record with a matching ID was not found, a message is printed to the terminal
                    //indicating that the record is not found.
                    System.out.println("RECORD NOT FOUND.");
                }
                break;
                
                default:
                return;
            }
        }
    }
}
