package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	public ConnectionDAO() {
		try {
			// Necess�rio para utilizar o driver JDBC do MySQL
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// Erro de driver JDBC (quando n�o esta adicionado o driver .jar do MySQL em
			// /WEB-INF/lib)
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {
		// URL de conex�o com o banco de dados
		// O parametro createDatabaseIfNotExist com o valor true passa para o MySQL que crie a base caso ela n�o exista
		String url = "jdbc:mysql://localhost/projeto06?createDatabaseIfNotExist=true";
		// Conecta utilizando a URL, usu�rio e senha.
		Connection conn = DriverManager.getConnection(url, "root", "");
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		ConnectionDAO db = new ConnectionDAO();
		// Testa a conex�o
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}
