package model;

import java.sql.*;

public class Database {

    public static String status = "Não conectou...";
    private Connection connection;

    public Database() {
        this.connection=getConexaoMySQL();
    }


    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;
        try {

            // Carregando o JDBC Driver padrão

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//

            String serverName = "localhost";
            String mydatabase = "BDProjeto?useSSL=false";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = "admin";

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }
            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado

            System.out.println("O driver especificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }




    }

    public static String statusConection() {

        return status;

    }

    public static boolean FecharConexao() {

        try {

            Database.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();
        return Database.getConexaoMySQL();
    }
}
