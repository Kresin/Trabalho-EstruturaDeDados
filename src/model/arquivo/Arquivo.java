package model.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.listaTag.*;
import model.pilha.PilhaLista;
import model.tag.TagService;
import model.tag.Tag;

public class Arquivo {

    private PilhaLista<String> pilha = new PilhaLista<String>();

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

    public void percorreArquivo(BufferedReader bufferedReader, ListaTag listaTag) {
        TagService tagService = new TagService();

        String linhaAtual;
        System.out.println("Conteúdo do arquivo:");
        try {
            while ((linhaAtual = bufferedReader.readLine()) != null) {
                System.out.println(linhaAtual);
                boolean primeiraBusca = true;
                int indice = 0;
                String tag;
                while (indice > -1) {

                    if (primeiraBusca) {
                        indice = tagService.verificaSeLinhaContemTags(indice, linhaAtual);
                        primeiraBusca = false;
                        //System.out.println(indice);
                        //System.out.println("Tag: " + tagService.obtemTag(indice, linhaAtual));

                        if (indice != -1) {
                            tag = tagService.obtemTag(indice, linhaAtual);
                            if (tagService.verificaTagDeFechamento(tag)) {
                                if (tag.substring(2).equals(pilha.peek().substring(1))) { //tag de fechamento é igual a última tag
                                    pilha.pop();
                                } else {
                                    System.out.println("Arquivo está fora do formato. Era esperado o fechamento de: " + pilha.peek() + ". Foi encontrado: " + tag);
                                }

                            } else {//Não é tag de fechamento

                                if (tagService.verificaTagComposta(tag)) { //Lida com tag composta
                                    tag = tagService.extraiTagComposta(tag);
                                }

                                if (tagService.verificaSingletonTag(tag)) {

                                    if (listaTag.buscar(tag) != null){ //Já existe esta tag na lista
                                        listaTag.buscar(tag).getInfo().incrementaInvokes();
                                    } else { //Não existe, então adiciona
                                        Tag novaTag = new Tag(tag);
                                        novaTag.incrementaInvokes();
                                        listaTag.inserir(novaTag);
                                    }

                                } else { //Não é singleton, então joga pra pilha
                                    pilha.push(tag);

                                    if (listaTag.buscar(tag) != null){ //Já foi adicionada
                                        listaTag.buscar(tag).getInfo().incrementaInvokes();
                                    } else {
                                        Tag novaTag = new Tag(tag);
                                        novaTag.incrementaInvokes();
                                        listaTag.inserir(novaTag);
                                    }

                                }
                            }
                        }
                    } else {
                        // Incrementado o indice do início da busca para não procurar a partir do mesmo lugar e retornar o indice da tag anterior
                        indice = tagService.verificaSeLinhaContemTags(indice + 1, linhaAtual);
                        //System.out.println(indice);
                        //System.out.println("Tag: " + tagService.obtemTag(indice, linhaAtual));

                        if (indice != -1) {
                            tag = tagService.obtemTag(indice, linhaAtual);
                            if (tagService.verificaTagDeFechamento(tag)) {
                                if (tag.substring(2).equals(pilha.peek().substring(1))) { //tag de fechamento é igual a última tag
                                    pilha.pop();
                                } else {
                                    System.out.println("Arquivo está fora do formato. Era esperado: o fechamento de" + pilha.peek() + ". Foi encontrado: " + tag);
                                }

                            } else {//Não é tag de fechamento

                                if (tagService.verificaTagComposta(tag)) { //Lida com tag composta
                                    tag = tagService.extraiTagComposta(tag);
                                }

                                if (tagService.verificaSingletonTag(tag)) {

                                    if (listaTag.buscar(tag) != null){ //Já existe esta tag na lista
                                        listaTag.buscar(tag).getInfo().incrementaInvokes();
                                    } else { //Não existe, então adiciona
                                        Tag novaTag = new Tag(tag);
                                        novaTag.incrementaInvokes();
                                        listaTag.inserir(novaTag);
                                    }

                                } else { //Não é singleton, então joga pra pilha
                                    pilha.push(tag);

                                    if (listaTag.buscar(tag) != null){ //Já foi adicionada
                                        listaTag.buscar(tag).getInfo().incrementaInvokes();
                                    } else {
                                        Tag novaTag = new Tag(tag);
                                        novaTag.incrementaInvokes();
                                        listaTag.inserir(novaTag);
                                    }
                                }
                            }
                        }
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
        System.out.println(listaTag.toString());
    }

}
