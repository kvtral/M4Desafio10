package cl.edutecno.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import cl.edutecno.model.Producto;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String ruta, ArrayList<Producto> listaProducto) {
		Scanner sc = new Scanner(System.in);
		
		crearDirectorio(ruta);
		
		System.out.println("# Ingrese el nombre del archivo # ");
		String file = sc.nextLine();
		ruta = "src/" + ruta + "/" + file + ".txt";

		crearArchivoYEscribir(ruta, listaProducto);

	}

	private static void crearDirectorio (String nombreDirectorio) {
		File directorio = new File ("src/" + nombreDirectorio);
		if (directorio.exists()) {
			System.out.println("Carpeta existe");
		} else {
			directorio.mkdir();
			System.out.println("Carpeta no existe, se creará");
		}
	}
	
	private static void crearArchivoYEscribir(String ruta, ArrayList<Producto> listaProducto) {
		
		try {
    		Scanner sc = new Scanner(System.in);
        	File archivo = new File(ruta);
        	boolean sobrescribir = false;
        	FileWriter fw;
        	
			if (archivo.exists()) {
        		System.out.println ("Archivo " + ruta + " ya existe");
        		System.out.println ("**********************************************");
        		System.out.println ("* Puede sobrescribir archivo o agregar texto *");
        		System.out.println ("**********************************************");
        		System.out.println ("¿Desea sobrescribir archivo? (S/N)");
				char respuesta = sc.next().charAt(0);
        		sobrescribir = (respuesta != 'S') ? false : true ;
        	}
        	
        	if (sobrescribir) {
        		fw = new FileWriter(archivo);
        	} else {
        		fw = new FileWriter(archivo, true);
        	}
        	
        	BufferedWriter bw = new BufferedWriter(fw);
        	
        	for (Producto productoTemp: listaProducto) {
        		bw.write(productoTemp.formateo());
        		bw.newLine();
        	}
            
			System.out.println("#################################");
			System.out.println("#       ARCHIVO EXPORTADO       #");
			System.out.println("#################################");
    		System.out.println ("Archivo : " + ruta);
    		
			bw.close();
			fw.close();
		
		}catch (Exception e){
			System.out.println("Excepcion escibiendo fichero : " + e);
		}
	}
	
}
