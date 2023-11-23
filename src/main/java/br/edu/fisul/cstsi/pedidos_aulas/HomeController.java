package br.edu.fisul.cstsi.pedidos_aulas;


import br.edu.fisul.cstsi.pedidos_aulas.socios.SocioController;

import java.util.Scanner;

public class HomeController {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n-------  Home -------");
            System.out.print(
                    """
    
                        1. MANTER SOCIO
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> SocioController.main(null);
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }

}//fim classe