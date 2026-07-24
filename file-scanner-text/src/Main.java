import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        File file = new File("C:\\Java\\Trabalhando com arquivos\\Trabalhando com arquivos Testes\\in.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.print(sc.nextLine());
            }
        }
        catch (IOException e){
            System.out.print("Error: " + e.getMessage());
        }
        finally {
            if (sc != null){
                sc.close();
            }
        }
    }
}