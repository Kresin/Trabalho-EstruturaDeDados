package model.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.pilha.PilhaTags;
import model.tag.TagService;
import model.tag.Tag;

/**
 * Class dedicada para manipulação de arquivos.
 */
public class Arquivo {

    private PilhaTags<String> pilha = new PilhaTags<String>();

    /**
     * Carrega o araquivo para a memória da aplicação.
     * 
     * @param localArquivo Local onde está localizado o arquivo.
     * @return Objeto com o arquivo carregado.
     */
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

    /**
     * Percorre todas as linhas do arquivo e adiciona as tags encontradas em uma
     * pilha. Ao final da execução o arquivo é fechado e é retornado uma pilha contendo
     * as tags encontradas.
     * 
     * @param bufferedReader Buffer com o arquivo carregado.
     * @return Pilha contendo as tags encontradas.
     */
    public PilhaTags<Tag> percorreArquivo(BufferedReader bufferedReader) {
        PilhaTags<Tag> pilhaLista = new PilhaTags<>();
        String linhaAtual;
        TagService tagService = new TagService();

        System.out.println("Conteúdo do arquivo:");
        try {
            while ((linhaAtual = bufferedReader.readLine()) != null) {
                System.out.println(linhaAtual);
                tagService.adicionaTagsDaLinha(linhaAtual, pilhaLista);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }
        return pilhaLista;
    }

}
