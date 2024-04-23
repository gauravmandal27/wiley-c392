import java.io.*;
import java.util.Scanner;

public class FileStreamTask {
    public static void main(String[] args) {
        String initialData = "\nThis is the First Line of the File.";
        Scanner sc = new Scanner(System.in);
        try(Writer writer = new FileWriter("output.txt",true)) {
            System.out.println("Initial Data Written into the file");
            writer.append(initialData);
            char choice = 'y';
            do {
                System.out.println("Do you want to continue y/n?");
                choice = sc.next().charAt(0);
                if (choice == 'n') {
                    break;
                } else {
                    System.out.println("Enter The Data to be added to file:");
                    String data ="\n"+sc.nextLine();
                    writer.append(data);
                }
            } while (true);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(Reader reader = new FileReader("output.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println("The Data in the File is: ");
            String line = bufferedReader.readLine();
            for (String s : bufferedReader.lines().toList()) {
                System.out.println(s);
            }
            }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }