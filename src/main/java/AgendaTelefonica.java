//Adriano Siqueira - 8-19-21 - Agenda Telefônica

//biblioteca com os metodos de escrita e leitura, usadas aqui nas interações com o txt
import java.io.*;
//biblioteca que contém o metodo usado para coletar input
import java.util.Scanner;

public class AgendaTelefonica {

    //esse metodo inicia o programa, por padrão
    public static void  main (String [] args) throws IOException {
        System.out.println("\n" +
                "  ______                                   __                 ________              __          \n" +
                " /      \\                                 |  \\               |        \\            |  \\         \n" +
                "|  $$$$$$\\ ______   ______  _______   ____| $$ ______        | $$$$$$$______   ____| $$ ______  \n" +
                "| $$__| $$/      \\ /      \\|       \\ /      $$|      \\       | $$__  /      \\ /      $$|      \\ \n" +
                "| $$    $|  $$$$$$|  $$$$$$| $$$$$$$|  $$$$$$$ \\$$$$$$\\      | $$  \\|  $$$$$$|  $$$$$$$ \\$$$$$$\\\n" +
                "| $$$$$$$| $$  | $| $$    $| $$  | $| $$  | $$/      $$      | $$$$$| $$  | $| $$  | $$/      $$\n" +
                "| $$  | $| $$__| $| $$$$$$$| $$  | $| $$__| $|  $$$$$$$      | $$   | $$__/ $| $$__| $|  $$$$$$$\n" +
                "| $$  | $$\\$$    $$\\$$     | $$  | $$\\$$    $$\\$$    $$      | $$    \\$$    $$\\$$    $$\\$$    $$\n" +
                " \\$$   \\$$_\\$$$$$$$ \\$$$$$$$\\$$   \\$$ \\$$$$$$$ \\$$$$$$$       \\$$     \\$$$$$$  \\$$$$$$$ \\$$$$$$$\n" +
                "         |  \\__| $$                                                                             \n" +
                "          \\$$    $$                                                                             \n" +
                "           \\$$$$$$                                                                              \n");
        Menu();
    }

    //esse método exibe um menu inicial de opções ao usuário
    public static void  Menu() throws IOException {

        //Inicia o metodo de input, dando a ele o nome de scan
        Scanner scan = new Scanner(System.in);

        System.out.println("===========================================================================");
        System.out.println("============= Esse programa cria, salva, e pesquisa contatos! =============");
        System.out.println("===========================================================================");
        System.out.println("================================== MENU ===================================");
        System.out.println("===========================================================================");
        System.out.println("====================Digite 1 para buscar contato salvo=====================");
        System.out.println("=======================Digite 2 para criar contato=========================");
        System.out.println("===========================================================================");

        //le Input do usuario
        int menuOpt = scan.nextInt();

        //A sequência de condicionais abaixo, verifica se o valor inserido é uma opção, e executa a ação relacionada
        if (menuOpt == 1) {
            BuscaContato ();
        }
        else if (menuOpt == 2){
            CriaContato();
        }
        else {
            System.out.println("Só tem 1 ou 2, seu burro!!!");
            scan.next();
            Menu();
        }
    }

    //esse método cria e armazena contatos num arquivo txt
    public static void CriaContato() throws IOException {

        Scanner scan = new Scanner(System.in);

        FileWriter arq = new FileWriter("e:\\lista.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);

        System.out.println("Insira o nome: ");
        var novo = scan.next();
        gravarArq.println(novo);

        System.out.println("Insira o numero: ");
        var novoNum = scan.next();
        gravarArq.println(novoNum);

        arq.close();

        System.out.println("O contato " + novo + ", com o número " + novoNum + " foi salvo com sucesso!!");
    }

    //Esse método busca um contato pelo nome, e exibe o contato
    public static void BuscaContato () throws IOException {
        FileReader arq;
        Scanner scan = new Scanner(System.in);
        var nome = "";
        var num = "";

        System.out.println("Digite o nome do contato: ");
        var busca = scan.nextLine();

        try {
            arq = new FileReader("e:\\lista.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            while (!busca.intern().equalsIgnoreCase(nome.intern())) {
                nome = lerArq.readLine(); // lê até a linha especificada
                num = lerArq.readLine(); // lê a linha seguinte, que na ordem, corresponde ao número
                if (nome == null) {
                    System.out.println("Não existe contato salvo com esse nome.");
                    break;
                }
            }

            System.out.println(nome);
            System.out.println(num);

            arq.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Viiish, deu ruim aqui, Jão...");
        }
    }
}
