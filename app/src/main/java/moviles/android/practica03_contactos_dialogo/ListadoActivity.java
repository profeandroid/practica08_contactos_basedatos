package moviles.android.practica03_contactos_dialogo;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;

import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

import android.view.View;

import android.widget.ListView;

import modelo.DBContactos;


public class ListadoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		ListView lstContactos;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listado);
		//creamos DBContactos y recupera la agenda
		DBContactos gestion=new DBContactos(this);
		Cursor cur=gestion.recuperarContactos();
		//recupera ListView
		lstContactos=(ListView)this.findViewById(R.id.lstContactos);
		String [] columns=new String[]{"nombre","email","edad"};
		//crea adaptador y lo asigna a la lista
		SimpleCursorAdapter sc= new SimpleCursorAdapter(
				this,
				android.R.layout.simple_list_item_1,
				cur,
				columns,
				new int[]{android.R.id.text1},
				CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		lstContactos.setAdapter(sc);
		gestion.close();
	}

	public void salir(View v){
		this.finish();
	}
}
