package beans;

import java.io.Serializable;

public class Contacto implements Serializable{
	private String nombre;
	private String email;
	private int edad;
	public Contacto(String nombre, String email, int edad) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return nombre+"cambio";
	}
}
