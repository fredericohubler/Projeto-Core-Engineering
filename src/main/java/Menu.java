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
        System.out.println("3 - Remover usuário existente.");
        String in = sc.nextLine();
        while (!(in.equals("1") || in.equals("2") || in.equals("3"))){
            System.out.println("Opção invalida.");
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Entrar com usuário já existente.");
            System.out.println("2 - Criar novo usuário.");
            System.out.println("3 - Remover usuário existente.");
            in=sc.nextLine();
        }
        switch (Integer.parseInt(in)){
            case 1: if(dbdao.retornaCpfUsers().size()==0){
                        System.out.println("Voce não tem nenhum usuario criado. Retornando ao menu inicial.");
                        menuInicial();
                        return;
                    }
                    menuContas(selecionaUser());
                    return;

            case 2: criaUser();
                    return;

            case 3: deletarUser();
                    return;
        }


    }

    public void criaUser(){
        UserDAO userDAO = new UserDAO();
        String nome = "";
        String cpf = "";
        while(true){//Aqui pega o nome do usuario e pede para confirmar se está certo.
            System.out.println("Digite o nome do novo usuário:");
            nome=sc.nextLine();
            System.out.println("Nome: "+nome+"\nPara confirmar digite 'sim'");
            String confirm=sc.nextLine();
            if(confirm.equalsIgnoreCase("sim")){
                break;
            }
        }

        while(true){//Aqui pega o CPF do usuario e pede para confirmar se está certo.
            System.out.println("Digite o CPF do novo usuário:");
            cpf=sc.nextLine();
            while(!cpf.matches("[0-9]+")){//Aqui testa se o CPF é composto apenas de numeros.
                System.out.println("O CPF deve conter somente numeros.");
                System.out.println("Digite o CPF do novo usuário:");
                cpf=sc.nextLine();
            }
            while(!(cpf.length()==11)){
                System.out.println("O CPF deve conter exatamente 11 numeros.");
                System.out.println("Digite o CPF do novo usuário:");
                cpf=sc.nextLine();
            }
            System.out.println("CPF: "+cpf+"\nPara confirmar digite 'sim'");
            String confirm=sc.nextLine();
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
            System.out.println((i+1)+" - Nome: "+nomes.get(i)+" CPF:"+cpfs.get(i));
        }
        String in=sc.nextLine();
        while(true){
            if(in.matches("[0-9]+")){//Checa se a string tem apenas numeros.
                if(Integer.parseInt(in)<=cpfs.size()){//Checa se o numero é valido.
                    retorno = new User(nomes.get(Integer.parseInt(in)-1), cpfs.get(Integer.parseInt(in)-1));//Cria um user com os valores do indice.
                    break;
                }
                else{
                    System.out.println("Não existe um usuario com este numero. Digite novamente.");
                    in=sc.nextLine();
                }

            }
            else System.out.println("Digite apenas numeros.");in=sc.nextLine();
        }
        return retorno;
    }

    public void deletarUser(){
        DatabaseDAO dbdao = new DatabaseDAO();
        UserDAO userDAO = new UserDAO();
        User deletado = null;

        ArrayList<String> cpfs = dbdao.retornaCpfUsers();
        ArrayList<String> nomes = dbdao.retornaNomeUsers();
        System.out.println("Selecione qual usuario será deletado:");
        for (int i = 0; i < cpfs.size(); i++) {
            System.out.println((i+1)+" - Nome: "+nomes.get(i)+" CPF:"+cpfs.get(i));
        }
        String in=sc.nextLine();
        while(true){
            if(in.matches("[0-9]+")){//Checa se a string tem apenas numeros.
                if(Integer.parseInt(in)<=cpfs.size()){//Checa se o numero é valido.
                    deletado = new User(nomes.get(Integer.parseInt(in)-1), cpfs.get(Integer.parseInt(in)-1));//Cria um user com os valores do indice.
                    break;
                }
                else{
                    System.out.println("Não existe um usuario com este numero. Digite novamente.");
                    in=sc.nextLine();
                }

            }
            else System.out.println("Digite apenas numeros.");in=sc.next();
        }
        while (true){
            System.out.println("Para confirmar a exclusão do usuario "+deletado.getNome()+", digite o nome do usuario a ser deletado:");
            in=sc.nextLine();
            if(in.equalsIgnoreCase(deletado.getNome())){
                userDAO.remove(deletado);
                System.out.println("Usuario "+deletado.getNome()+" excluido com sucesso.");
                menuInicial();
                return;
            }
            else {
                System.out.println("Nome incorreto. Voltando para o menu inicial.");
                menuInicial();
                return;
            }
        }
    }

    public void menuContas(User usuarioSelecionado){
        UserDAO userDAO = new UserDAO();
        String printzao = userDAO.retornarNome(usuarioSelecionado) + "   " + userDAO.retornarCPF(usuarioSelecionado);
        System.out.println(printzao);
    }
}
