package model.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.tag.TagService;

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

    public void percorreArquivo(BufferedReader bufferedReader) {
        TagService tagService = new TagService();
        String linhaAtual;
        System.out.println("Conteúdo do arquivo:");
        try {
            while ((linhaAtual = bufferedReader.readLine()) != null) {
                System.out.println(linhaAtual);
                boolean primeiraBusca = true;
                int indice = 0;
                while (indice > -1) {
                    if (primeiraBusca) {
                        indice = tagService.verificaSeLinhaContemTags(indice, linhaAtual);
                        primeiraBusca = false;
                        System.out.println(indice);
                        System.out.println("Tag: " + tagService.obtemTag(indice, linhaAtual));
                    } else {
                        // Incrementado o indice do início da busca para não procurar a partir do mesmo lugar e retornar o indice da tag anterior
                        indice = tagService.verificaSeLinhaContemTags(indice + 1, linhaAtual);
                        System.out.println(indice);
                        System.out.println("Tag: " + tagService.obtemTag(indice, linhaAtual));
                    }
                }
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
