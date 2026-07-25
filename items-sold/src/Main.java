import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo .csv: ");
        String strPath = sc.nextLine();

        File sourceFile = new File(strPath);
        String sourceFolderStr = sourceFile.getParent();

        // Cria a subpasta "out" 
        boolean success = new File(sourceFolderStr + "/out").mkdir();

        String targetFileStr = sourceFolderStr + "/out/summary.csv";

        // Lê o arquivo original e escreve o resumo simultaneamente
        try (BufferedReader br = new BufferedReader(new FileReader(strPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

            String itemCsv = br.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                double total = price * quantity;

                bw.write(name + "," + String.format("%.2f", total));
                bw.newLine();

                itemCsv = br.readLine();
            }

            System.out.println("Arquivo 'summary.csv' gerado com sucesso em: " + targetFileStr);

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivos: " + e.getMessage());
        }

        sc.close();
    }
}
