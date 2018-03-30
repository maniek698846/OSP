package projektOSP;

import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
	static String sciezka = "C:\\Users\\User\\eclipse\\ospmarian\\osp.sqlite";
	Connection conn=null;
	public static Connection dbConnector() 
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+sciezka);
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
