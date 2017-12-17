package ospmarian;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class wypelnijcb extends JFrame {

	public static void wypComboBox(JComboBox<String> comboBoxName2) {
		Connection connection=sqliteConnection.dbConnector();

		try {
			
			String query="select distinct Imie, Nazwisko from zaloga ORDER BY Nazwisko, Imie ASC";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();		
			while(rs.next())
			{
				comboBoxName2.addItem(rs.getString("Imie")+" "+rs.getString("Nazwisko"));		
			}
			
		}catch(Exception exc)
		{
			exc.printStackTrace();		 
		}
		
	}
	
}


