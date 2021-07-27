package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votes = new TreeMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String username = fields[0];
                int count = Integer.parseInt(fields[1]);

                if(votes.containsKey(username)){
                    int voteSoFar = votes.get(username);
                    votes.put(username, count + voteSoFar);
                }
                else {
                    votes.put(username, count);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        }
        catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
