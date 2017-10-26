import com.sun.org.apache.xpath.internal.SourceTree;

public class Menu {

    public String menuInicial(){
        String retorno = "";

        retorno = "Bem vindo ao sistema.\n";
        retorno += "Selecione a opção desejada:\n";
        retorno += "1 - Entrar com usuário já existente.\n";
        retorno += "2 - Criar novo usuário.";

        return retorno;
    }

    public void printa(String print){
        System.out.println(print);
    }
}
