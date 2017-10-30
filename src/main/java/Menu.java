import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Menu {

    private Scanner sc = new Scanner(System.in).useLocale(Locale.US);

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
                    menuResumo(selecionaUser());
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

    public void menuResumo(User usuarioSelecionado){
        UserDAO userDAO = new UserDAO();
        DatabaseDAO dbdao = new DatabaseDAO();
        System.out.println("Bem vindo "+usuarioSelecionado.getNome()+", por favor selecione uma opção:");
        System.out.println("1 - Mostrar resumo");
        System.out.println("2 - Adicionar Conta");
        System.out.println("3 - Remover Conta");
        System.out.println("4 - Registrar gasto ou ganho");
        String in = sc.nextLine();
        while (!(in.equals("1") || in.equals("2") || in.equals("3") || in.equals("4"))){
            System.out.println("Opção invalida.");
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Mostrar resumo");
            System.out.println("2 - Adicionar Conta");
            System.out.println("3 - Remover Conta");
            System.out.println("4 - Registrar gasto ou ganho");
            in=sc.nextLine();
        }
        switch (Integer.parseInt(in)){
            /*case 1: printaResumo();
                    return;*/

            case 2: criarConta(usuarioSelecionado);
                    return;

            case 3: removerConta(usuarioSelecionado);
                    return;

            /*case 4: registrarMovimento();
                    return;*/
        }
    }

    public void criarConta(User usuarioSelecionado){
        ContaDAO contaDAO = new ContaDAO();
        String agencia = "";//   DONE
        String numConta = "";//   DONE
        double saldo = 0.0;//   DONE
        double mensalidade = 0.0;//   DONE
        String nome="";//    DONE
        String diaMensalidade ="";//   DONE
        String userCPF= usuarioSelecionado.getCPF();//   DONE
        while(true){// Aqui pega o nome da conta.
            System.out.println("Digite o nome da conta:");
            nome=sc.nextLine();
            System.out.println("Nome: "+nome+"\nPara confirmar digite 'sim'");
            String confirm=sc.nextLine();
            if(confirm.equalsIgnoreCase("sim")){
                break;
            }
        }

        while(true){//Aqui pega o numero da conta.
            System.out.println("Digite o numero da conta:");
            numConta=sc.nextLine();
            while(!numConta.matches("[0-9]+")){
                System.out.println("O numero da conta deve conter somente numeros.");
                System.out.println("Digite o numero da conta:");
                numConta=sc.nextLine();
            }
            System.out.println("Numero da conta: "+numConta+"\nPara confirmar digite 'sim'");
            String confirm=sc.nextLine();
            if(confirm.equalsIgnoreCase("sim")){
                break;
            }
        }

        while(true){//Aqui pega o dia que a mensalidade é cobrada.
            System.out.println("Digite o dia que a mensalidade do cartão é cobrada:");
            diaMensalidade=sc.nextLine();
            while(!diaMensalidade.matches("[0-9]+")){
                System.out.println("O dia deve conter somente numeros.");
                System.out.println("Digite o dia que a mensalidade do cartão é cobrada:");
                diaMensalidade=sc.nextLine();
            }
            while(!(diaMensalidade.length()==2)){
                System.out.println("O dia deve conter exatamente 2 numeros.");
                System.out.println("Caso o dia tenha apenas 1 numero, coloque um 0 na frente.");
                System.out.println("Digite o dia que a mensalidade do cartão é cobrada:");
                diaMensalidade=sc.nextLine();
            }
            System.out.println("Dia: "+diaMensalidade+"\nPara confirmar digite 'sim'");
            String confirm=sc.nextLine();
            if(confirm.equalsIgnoreCase("sim")){
                break;
            }
        }

        while(true){//Aqui pega a agencia.
            System.out.println("Digite a agencia da conta:");
            agencia=sc.nextLine();
            System.out.println("Agencia da conta: "+agencia+"\nPara confirmar digite 'sim'");
            String confirm=sc.nextLine();
            if(confirm.equalsIgnoreCase("sim")){
                break;
            }
        }

        while(true){//Aqui pega o valor da mensalidade.
            System.out.println("Digite o valor da mensalidade do cartão:");
            String mensalidadeString=sc.nextLine();
            while(!mensalidadeString.matches("[0-9\\.]+")){
                System.out.println("A mensaliade deve conter somente numeros e um ponto.");
                System.out.println("Digite o valor da mensalidade do cartão:");
                mensalidadeString=sc.nextLine();
            }
            mensalidade = Double.parseDouble(mensalidadeString);
            System.out.println("Mensalidade: "+mensalidade+"\nPara confirmar digite 'sim'");
            String confirm=sc.nextLine();
            if(confirm.equalsIgnoreCase("sim")){
                break;
            }
        }

        Conta criada = new Conta(agencia,numConta,saldo,mensalidade,nome,diaMensalidade,userCPF);
        contaDAO.insere(criada);
        menuResumo(usuarioSelecionado);
        return;
    }

    public void removerConta(User usuarioSelecionado){
        ContaDAO contaDAO = new ContaDAO();
        DatabaseDAO databaseDAO = new DatabaseDAO();
        ArrayList<String> numeroContas = databaseDAO.retornaNumeroContaUsuarioEspecifico(usuarioSelecionado.getCPF());
        Conta deletado=null;
        int i=0;

        System.out.println("Selecione qual conta será deletada:");
        for (i = 0; i < numeroContas.size(); i++) {
            System.out.println((i+1)+" - Numero da Conta: "+numeroContas.get(i));
        }
        String in=sc.nextLine();
        while(true){
            if(in.matches("[0-9]+")){//Checa se a string tem apenas numeros.
                if(Integer.parseInt(in)<=numeroContas.size()){//Checa se o numero é valido.
                    deletado = databaseDAO.retornaObjetoConta(numeroContas.get(Integer.parseInt(in)-1));
                    break;
                }
                else{
                    System.out.println("Não existe um usuario com este numero. Digite novamente.");
                    in=sc.nextLine();
                }

            }
            else System.out.println("Digite apenas numeros.");in=sc.next();
        }
        while (true){//------
            System.out.println("Para confirmar a exclusão da conta de numero "+deletado.getNumeroConta()+", digite o numero da conta a ser deletada:");
            in=sc.nextLine();
            if(in.equalsIgnoreCase(deletado.getNumeroConta())){
                contaDAO.remove(deletado, usuarioSelecionado.getCPF());
                System.out.println("Conta de numero "+deletado.getNumeroConta()+" excluida com sucesso.");
                menuResumo(usuarioSelecionado);
                return;
            }
            else {
                System.out.println("Numero incorreto. Voltando para o menu.");
                menuResumo(usuarioSelecionado);
                return;
            }
        }
    }
}
