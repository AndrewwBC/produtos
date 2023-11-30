package br.edu.fisul.cstsi.pedidos_aulas.socios;


import org.springframework.stereotype.Controller;

import java.util.List;
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
                        5. Encontrar por nome
                        Opção (Zero p/sair):\s""");

            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> listarSocios();
                case 4 -> deletarSocio();
                case 5 -> encontrarPorNome();
                default -> {
                    if (menu != 0) System.out.println("Opção inválida.");
                }
            }

        } while (menu != 0);

    }

    private static void atualizar() {
        System.out.println("\nAtualizando Socio\n");

            System.out.println("Digite o código do sócio");
            Long codigoInserido = input.nextLong();

            Socio socio = socioService.getSocioById(codigoInserido);
            System.out.println("Este foi o sócio selecionado: \n" + socio + "\n Confirme a atualização deste sócio? 1. Sim | 2. Não");

            int menu = input.nextInt();

            if(menu == 1){

                Long cartao_socio;
                String nome_socio;
                String end_socio;
                String tel_socio;
                String email_socio;

                System.out.println("Insira os novos dados\n");
                System.out.println("*** DEIXE VAZIO OS CAMPOS QUE NÃO SERÃO ATUALIZADOS *** \n");

                System.out.println("Cartao do sócio - Insira o valor 0 se não quiser atualizar\n");
                cartao_socio = input.nextLong();

                input.nextLine();
                System.out.println("Nome do sócio");
                nome_socio = input.nextLine();

                System.out.println("Endereço do sócio");
                end_socio = input.nextLine();

                System.out.println("Telefone do sócio");
                tel_socio = input.nextLine();

                System.out.println("Email do sócio");
                email_socio = input.nextLine();

                System.out.println("Confirmar atualizações? 1. Sim | 2. Não\n");
                int opcaoConfirmar;
                opcaoConfirmar = input.nextInt();

                if(opcaoConfirmar == 1) {

                    if(cartao_socio != 0) {
                        socio.setCartao_socio(cartao_socio);
                    }

                    if(!nome_socio.isEmpty()) {
                        socio.setNome_socio(nome_socio);
                    }

                    if(!end_socio.isEmpty()) {
                        socio.setEnd_socio(end_socio);
                    }

                    if(!tel_socio.isEmpty()) {
                        socio.setTel_socio(tel_socio);
                    }

                    if(!email_socio.isEmpty()) {
                        socio.setEmail_socio(email_socio);
                    }

                    if(socioService.update(socio) != null) {
                        System.out.println("cliente atualizado com sucesso. " + socioService.getSocioById(socio.getId()));
                    } else {
                        System.out.println("Não foi possível atualizar este socio. Por favor, contate o administrador.");
                    }

                }

            } else {
                return;
            }
    }


    private static void inserir() {
        Socio socio = new Socio();

        System.out.println("Todos dados devem estar preenchido!");

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

    private static void encontrarPorNome(){

        System.out.println("Digite o nome que pretende encontrar");
        String nomeInserido = input.nextLine();

        if(nomeInserido != null) {

            List<Socio> busca = socioService.getSocioByName(nomeInserido);
            System.out.println(busca);
        }
    }

}
