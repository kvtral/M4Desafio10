package cl.edutecno.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import cl.edutecno.model.Producto;

public class ArchivoServicio {

	public ArrayList<Producto> cargaDatos(){
		
		File archivo = new File("src/ProductoImportados.csv");

		ArrayList<Producto> listaProductos = new ArrayList <Producto>();
		
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = br.readLine();
			
			while (linea != null) {
				ArrayList<String> camposProductos = new ArrayList<String>(Arrays.asList(linea.split(",")));
				Producto producto = new Producto ();
				
				producto.setArticulo(camposProductos.get(0));
				producto.setPrecio(camposProductos.get(1));
				producto.setDescripcion(camposProductos.get(2));
				producto.setCodigo(camposProductos.get(3));
				producto.setTalla(camposProductos.get(4));
				producto.setMarca(camposProductos.get(5));
				producto.setColor(camposProductos.get(6));
				
				listaProductos.add(producto);
				
				linea = br.readLine();
				
			}
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Archivo importado correctamente");
		return listaProductos;	
		
	}
}
