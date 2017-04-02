package moviles.android.practica03_contactos_dialogo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import beans.Contacto;
import modelo.DBContactos;


public class BuscarActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
	}
	public void buscar(View v){
		String email=((EditText)this.findViewById(R.id.edtEmailBusca)).getText().toString();
		//guardamos aquí el contacto recuperado
		Contacto c=null;
		//creamos GestionContacto y buscamos
		DBContactos gestion=new DBContactos(this);
		c=gestion.buscarPorEmail(email);
		mostrarDato(c);
		//cerramos la base de datos
		gestion.close();
	}
	public void salir(View v){
		//finaliza la actividad
		this.finish();
	}

	private void mostrarDato(Contacto c){
		if(c==null){
			AlertDialog.Builder cuadro=new AlertDialog.Builder(this);
			cuadro.setMessage("No se ha encontrado el contacto, ¿Desea realizar otra búsqueda?");
			//en caso de que diga que no, salimos de la actividad
			cuadro.setNegativeButton(android.R.string.no,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//Abandona la actividad
							BuscarActivity.this.finish();
						}
					});
			//no se define ningún escuchador para el botón de afirmación
			cuadro.setPositiveButton(android.R.string.yes,null);
			cuadro.show();

		}
		else{
			String datos="Nombre: "+c.getNombre()+"\n Email:"+c.getEmail()+"\n Edad:"+c.getEdad();
			Toast.makeText(this,datos,Toast.LENGTH_LONG).show();

		}
	}
	
}
