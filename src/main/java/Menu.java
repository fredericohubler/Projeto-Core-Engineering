import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

    private Scanner sc = new Scanner(System.in);

    public void menuInicial(){
        DatabaseDAO dbdao = new DatabaseDAO();
        System.out.println("Bem vindo ao sistema.");
        System.out.println("Selecione a opção desejada:");
        System.out.println("1 - Entrar com usuário já existente.");
        System.out.println("2 - Criar novo usuário.");
        String in = sc.next();
        while (!(in.equals("1") || in.equals("2"))){
            System.out.println("Opção invalida.");
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Entrar com usuário já existente.");
            System.out.println("2 - Criar novo usuário.");
            in=sc.next();
        }
        if(in.equals("1")){
            if(dbdao.retornaCpfUsers().size()==0){
                System.out.println("Voce não tem nenhum usuario criado. Retornando ao menu inicial.");
                menuInicial();
                return;
            }
            selecionaUser();
            return;
        }
        else{
            criaUser();
            return;
        }
    }

    public void criaUser(){
        UserDAO userDAO = new UserDAO();
        String nome = "";
        String cpf = "";
        while(true){//Aqui pega o nome do usuario e pede para confirmar se está certo.
            System.out.println("Digite o nome do novo usuário:");
            nome=sc.next();
            System.out.println("Nome: "+nome+"\nPara confirmar digite 'sim'");
            String confirm=sc.next();
            if(confirm.equalsIgnoreCase("sim")){
                break;
            }
        }

        while(true){//Aqui pega o CPF do usuario e pede para confirmar se está certo.
            System.out.println("Digite o CPF do novo usuário:");
            cpf=sc.next();
            while(!cpf.matches("[0-9]+")){//Aqui testa se o CPF é composto apenas de numeros.
                System.out.println("O CPF deve conter somente numeros.");
                System.out.println("Digite o CPF do novo usuário:");
                cpf=sc.next();
            }
            while(!(cpf.length()==11)){
                System.out.println("O CPF deve conter exatamente 11 numeros.");
                System.out.println("Digite o CPF do novo usuário:");
                cpf=sc.next();
            }
            System.out.println("CPF: "+cpf+"\nPara confirmar digite 'sim'");
            String confirm=sc.next();
            if(confirm.equalsIgnoreCase("sim")){
                break;
            }
        }

        User user = new User(nome,cpf);//nome e cpf
        userDAO.insere(user);
        menuInicial();
        return;
    }

    public User selecionaUser(){
        int i =0;
        User retorno = null;
        DatabaseDAO dbdao = new DatabaseDAO();
        ArrayList<String> cpfs = dbdao.retornaCpfUsers();
        ArrayList<String> nomes = dbdao.retornaNomeUsers();
        System.out.println("Selecione um usuario:");
        for (i = 0; i < cpfs.size(); i++) {
            System.out.println("1 - Nome: "+nomes.get(i)+" CPF:"+cpfs.get(i));
        }
        String in=sc.next();
        while(true){
            if(in.matches("[0-9]+")){//Checa se a string tem apenas numeros.
                if(Integer.parseInt(in)<=cpfs.size()){//Checa se o numero é valido.
                    retorno = new User(nomes.get(Integer.parseInt(in)), cpfs.get(Integer.parseInt(in)));//Cria um user com os valores do indice.
                    break;
                }
                else System.out.println("Não existe um usuario com este numero. Digite novamente.");in=sc.next();

            }
            else System.out.println("Digite apenas numeros.");in=sc.next();

        }
        return retorno;
    }
}
