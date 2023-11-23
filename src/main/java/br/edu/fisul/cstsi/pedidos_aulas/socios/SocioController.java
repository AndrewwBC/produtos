package br.edu.fisul.cstsi.pedidos_aulas.socios;


import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class SocioController {

    private static final Scanner input = new Scanner(System.in);
    private static SocioService socioService;
    public SocioController (SocioService SocioService) {
        SocioController.socioService = SocioService;
    }

    public static void main(String[] args) {

        int menu;

        do {
            System.out.println("CRUD ANDREW");
            System.out.print(
                    """  
                        1. Inserir Socio
                        2. Atualizar Socio
                        3. Listar socios
                        4. Deletar Socio
                        Opção (Zero p/sair):\s""");

            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> listarSocios();
                case 4 -> deletarSocio();
                default -> {
                    if (menu != 0) System.out.println("Opção inválida.");
                }
            }

        } while (menu != 0);

    }
    private static void inserir() {
        Socio socio = new Socio();

        System.out.println("Digite o cartao do socio");
        socio.setCartao_socio(input.nextLong());

        input.nextLine();
        System.out.println("Digite o nome do socio");
        socio.setNome_socio(input.nextLine());

        System.out.println("Digite o endereço");
        socio.setEnd_socio(input.nextLine());

        System.out.println("Digite o telefone");
        socio.setTel_socio(input.nextLine());

        System.out.println("Digite o email");
        socio.setEmail_socio(input.nextLine());
        socioService.insertSocio(socio);

    }

    private static void atualizar(){
        Socio socio;

        System.out.println("Digite o código do Socio");
        Long codigo = input.nextLong();
        input.nextLine();

        socio = socioService.getSocioById(codigo);
        if(socio != null) {

        } else {
            System.out.println("Socio não encontrado. Verifique o código.");
        }

    }

    private static void listarSocios(){
        System.out.println("Mostrando todos os socios ;)");

        socioService.listSocios().forEach(socio -> {
            System.out.println(socio);
        });

    }
    private static void deletarSocio(){

        System.out.println("Digite o código do sócio que deseja deletar");
        Long codigo = input.nextLong();

        if(codigo > 0){
            System.out.println(socioService.getNameById(codigo));
            System.out.println("Confirma a exclusão deste socio? Digite 1 - Sim | 2 - Não");
            Integer opcao = input.nextInt();

            if(opcao == 1) {
                Socio socio = socioService.getSocioById(codigo);
                socioService.deleteSocio(socio);
                System.out.println("Exclusão confirmada!");

            }
        }
    }




}
