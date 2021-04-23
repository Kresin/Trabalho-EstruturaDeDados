package model;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Menu;

public class Trabalho {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.out.println("Erro ao carregar o tema");
        }
        Menu menu = new Menu();
        menu.setVisible(true);
    }
    
}
