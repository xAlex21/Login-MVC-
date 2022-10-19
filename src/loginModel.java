import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class loginModel {

	public Map<String, String> listadoUsuarios = new HashMap<String, String>();
	

	public void cargarUsuarios() throws IOException {

		String csvFile = "resources/users.csv";
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(csvFile));
	    String line = "";
	    String cvsSplitBy = ",";
	    
		while ((line  = br.readLine()) != null) {
			
	       String[] datos = line.split(cvsSplitBy);
	       listadoUsuarios.put(datos[0], datos[1]);
	       
	    }

	}
	
	public Map<String, String> getUsuarios() {
		return listadoUsuarios;
	}
	
}
