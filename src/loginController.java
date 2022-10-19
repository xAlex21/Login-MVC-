import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.scene.control.Alert;

public class loginController {


	static loginModel modelo = new loginModel();
	public Map<String, String> listadoUsers = new HashMap<String, String>();
	
	public loginController() throws IOException {
		
		this.cargarDatos();
		
		this.listadoUsers = modelo.getUsuarios();
		
	}
	
	
	public void comprobarDatos(String nombre, String contrasena) {
		
		String passActual = (listadoUsers.get(nombre));
		String passIntroducida = this.encriptar(contrasena);
		
		if(passActual != null && passActual.equals(passIntroducida)) {
		    Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    alert.setHeaderText(null);
		    alert.setTitle("Acceso permitido");
		    alert.setContentText("Las credenciales de acceso son válidas.");
		    alert.showAndWait();
		}else {
		    Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Acceso denegado");
		    alert.setContentText("El usuario y/o la contraseña no son válidos.");
		    alert.showAndWait();
		}
	}
	
	public void cargarDatos() throws IOException {
		
		modelo.cargarUsuarios();

	}
	
	public String encriptar(String contrasena) {
		
		String md5 = DigestUtils.md5Hex(contrasena).toUpperCase();
		return (md5);
		
	}
}
