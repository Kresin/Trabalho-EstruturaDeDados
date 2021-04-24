package model.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {
    
    public BufferedReader carregaArquivo(String localArquivo) {
        File file = new File(localArquivo);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao carregar o arquivo.");
        }
        return new BufferedReader(fileReader);
    }
    
    public void percorreArquivo(BufferedReader bufferedReader){
        String linhaAtual;
        System.out.println("Conteúdo do arquivo:");
        try {
            while ((linhaAtual = bufferedReader.readLine()) != null) {
                System.out.println(linhaAtual);
            }
        } catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo.");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }
    }
    
}
