package cl.edutecno.service;

import java.util.ArrayList;
import cl.edutecno.model.Producto;

public abstract class Exportador {
	
	public abstract void exportar(String nombreArchivo, ArrayList<Producto> listaProducto);

}
