package moviles.android.practica03_contactos_dialogo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import beans.Contacto;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void agregar(View v){
		Intent intent=new Intent(this,AgregarActivity.class);
		this.startActivityForResult(intent,1);
	}
	public void buscar(View v){
		Intent intent=new Intent(this,BuscarActivity.class);
		this.startActivity(intent);
	}
	public void ver(View v){
		//commit 1
		Intent intent=new Intent(this,ListadoActivity.class);
		this.startActivity(intent);
	}

}
