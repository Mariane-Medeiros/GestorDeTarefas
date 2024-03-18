import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class appTarefa {
  static Scanner scan = new Scanner(System.in);
  static ArrayList <Tarefa> colecao_tarefas = new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }
 
    public static void menu(){
        int opcao_escolhida = 0;
        System.out.println("\n----------------BEM VINDO AO GESTOR DE TAREFAS----------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------ESCOLHA UMA DAS OPCOES--------------------");
        System.out.println(" 1) Adicionar tarefa");
        System.out.println(" 2) Visualizar tarefas");
        System.out.println(" 3) Buscar tarefa");
        System.out.println(" 4) Excluir tarefa");
        System.out.println(" 5) Concluir tarefa");
        System.out.println(" 6) Fechar gestor");

        //NAO FUNCIONA
        try{
            opcao_escolhida = scan.nextInt();
            scan.nextLine();
        }catch(InputMismatchException nome){
            System.out.println("Opcao invalida");
            menu();
        }

        switch (opcao_escolhida) {
            case 1:
                addTarefa();
                break;
            case 2:
                listaTarefa();
            break;
            case 3:
                buscarTarefa();
            break;
            case 4:
                excluirTarefa();
            break;
            case 5:
                concluirTarefa();
            break;
            case 6:
                System.out.println("Obrigada pela preferencia!");
                System.exit(0);
            default:
            System.out.println("Opcao invalida");
            break;
        }
    }

    public static void addTarefa(){


        String nome_tarefa, desc;
        System.out.println("Digite o nome da tarefa:");
        nome_tarefa = scan.nextLine();

         //GARANTIR QUE NAO PODE TAREFA COM NOME REPETIDO
        if(!(colecao_tarefas.size() == 0)){
        for(Tarefa t: colecao_tarefas){
                if(t.getNome().equals(nome_tarefa)){
                    System.out.println("Este nome ja esta sendo utilizado.");
                    menu();
                }
            }
        }


        System.out.println("Digite a descricao da tarefa");
        desc = scan.nextLine();

        Tarefa tarefa = new Tarefa(nome_tarefa, desc);
        colecao_tarefas.add(tarefa);

        System.out.println("Tarefa adicionada!");
        menu();
    }

    public static void listaTarefa(){
        if(colecao_tarefas.size() == 0){
            System.out.println("Nao existe nenhuma tarefa cadastrada!");
            menu();
        }
        else{
            for(Tarefa t: colecao_tarefas){
                System.out.print(t);
                System.out.println("");
            }
        }
        menu();
    }

    public static int procurarPosicao(){
        String temp;
        int posicao = 0;
        System.out.println("Digite o nome da tarefa: ");
        temp=scan.nextLine();
        for(Tarefa t: colecao_tarefas){//percorre todos os objetos tarefa
            if(t.getNome().equals(temp)){//acha o nome do objeto que corresponde ao nome procurado
                posicao = (colecao_tarefas.indexOf(t));
                break;
            }
        }
        return posicao;
    }

    public static void buscarTarefa(){
    int posicao = procurarPosicao();
    System.out.print(colecao_tarefas.get(posicao));
        menu();
    }

    public static void excluirTarefa(){
        int posicao = procurarPosicao();
        colecao_tarefas.remove(posicao);
        menu();
    }

    public static void concluirTarefa(){
        int posicao = procurarPosicao();
        System.out.print(posicao);
        colecao_tarefas.get(posicao).setstatus("Concluida");
        System.out.print(colecao_tarefas.get(posicao));
        menu();
    }


}

