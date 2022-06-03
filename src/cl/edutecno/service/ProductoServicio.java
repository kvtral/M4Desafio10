package cl.edutecno.service;

import java.util.ArrayList;
import java.util.Scanner;

import cl.edutecno.model.Producto;

public class ProductoServicio {
	
	private ArrayList<Producto> listaProductos;

	public ProductoServicio() {
		listaProductos = new ArrayList<>();
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public void listarProductos() {
		if (!getListaProductos().isEmpty()) {
			System.out.println("#################################");
			System.out.println("#     PRODUCTOS DISPONIBLES     #");
			System.out.println("#################################");
			System.out.println();
			
			for (Producto productoTemp : listaProductos) {
				System.out.println("##    " + productoTemp.toString());
			}
			System.out.println("##");
			System.out.println("#################################");

		} else {
			
			System.out.println("#################################");
			System.out.println("#         SIN PRODUCTOS         #");
			System.out.println("#################################");
			
		}
	}
	
	public void agregarProductos() {
		Scanner sc = new Scanner(System.in);
		Producto producto =  new Producto();
		System.out.println("#################################");
		System.out.println("#        INGRESE PRODUCTO       #");
		System.out.println("#################################");
		System.out.println("#  INGRESE NOMBRE DEL PRODUCTO  #");
		System.out.println("#################################");
		producto.setArticulo(sc.nextLine());
		System.out.println("#################################");
		System.out.println("#  INGRESE PRECIO DEL PRODUCTO  #");
		System.out.println("#################################");
		producto.setPrecio(sc.nextLine());
		System.out.println("#################################");
		System.out.println("#    DESCRIPCION DEL PRODUCTO   #");
		System.out.println("#################################");
		producto.setDescripcion(sc.nextLine());
		System.out.println("#################################");
		System.out.println("#  INGRESE CODIGO DEL PRODUCTO  #");
		System.out.println("#################################");
		producto.setCodigo(sc.nextLine());
		System.out.println("#################################");
		System.out.println("#  INGRESE TALLA  DEL PRODUCTO  #");
		System.out.println("#################################");
		producto.setTalla(sc.nextLine());
		System.out.println("#################################");
		System.out.println("#  INGRESE MARCA  DEL PRODUCTO  #");
		System.out.println("#################################");
		producto.setMarca(sc.nextLine());
		System.out.println("#################################");
		System.out.println("#  INGRESE COLOR  DEL PRODUCTO  #");
		System.out.println("#################################");
		producto.setColor(sc.nextLine());
		
		listaProductos.add(producto);
		
	}
	
	public void editarProducto( ) {
		
		Scanner sc = new Scanner(System.in);
		
		if (!listaProductos.isEmpty()) {
			System.out.println("#################################");
			System.out.println("#  INGRESE CODIGO DEL PRODUCTO  #");
			System.out.println("#          A MODIFICAR          #");
			System.out.println("#################################");
			String codigoProducto = sc.nextLine();
			if (!codigoProducto.isEmpty()) {
				
				for (Producto productoTemp: listaProductos) {
					if (productoTemp.getCodigo().equals(codigoProducto)) {
						menuEditar(productoTemp);
					}
				}
				
			} else {
				System.out.println("#################################");
				System.out.println("#  CODIGO INGRESADO INCORRECTO  #");
				System.out.println("#################################");
			}
		} else {
			System.out.println("#################################");
			System.out.println("#         SIN PRODUCTOS         #");
			System.out.println("#################################");
		}
		
		
	}
	
	private void menuEditar(Producto p) {
		
		Scanner sc = new Scanner(System.in);
		String opcion;
		
		do {
			
			System.out.println("#################################");
			System.out.println("#      PARAMETRO A EDITAR       #");
			System.out.println("#################################");
			System.out.println("#                               #");
			System.out.println("#   1.- Nombre Producto         #");
			System.out.println("#   2.- Precio Producto         #");
			System.out.println("#   3.- Descripcion Producto    #");
			System.out.println("#   4.- Codigo Producto         #");
			System.out.println("#   5.- Talla Producto          #");
			System.out.println("#   6.- Color Producto          #");
			System.out.println("#   7.- Salir de la edicion     #");
			System.out.println("#                               #");
			System.out.println("#################################");
			System.out.println("#                               #");
			System.out.println("#   Ingrese una opción:         #");
			System.out.println("#                               #");
			System.out.println("#################################");
			
			opcion = sc.nextLine();
			
			switch (opcion) {
			
			case "1":
				System.out.println("#################################");
				System.out.println("#      INGRESE NUEVO NOMBRE     #");
				System.out.println("#################################");
				p.setArticulo(sc.nextLine());
				break;
				
			case "2":
				System.out.println("#################################");
				System.out.println("#      INGRESE NUEVO PRECIO     #");
				System.out.println("#################################");
				p.setPrecio(sc.nextLine());
				break;
			
			case "3":
				System.out.println("#################################");
				System.out.println("#   INGRESE NUEVA DESCRIPCION   #");
				System.out.println("#################################");
				p.setDescripcion(sc.nextLine());
				break;
			
			case "4":
				System.out.println("#################################");
				System.out.println("#     INGRESE NUEVO CODIGO      #");
				System.out.println("#################################");
				p.setCodigo(sc.nextLine());
				break;
				
			case "5":
				System.out.println("#################################");
				System.out.println("#  INGRESE TALLA DEL PRODUCTO   #");
				System.out.println("#################################");
				p.setTalla(sc.nextLine());
				break;
				
			case "6":
				System.out.println("#################################");
				System.out.println("#  INGRESE COLOR DEL PRODUCTO   #");
				System.out.println("#################################");
				p.setColor(sc.nextLine());
				break;

			default:
				System.out.println("#################################");
				System.out.println("#    INGRESE OPCION VALIDA      #");
				System.out.println("#################################");
				break;
			}

		} while (!opcion.contentEquals("7"));
		
	}
	

}
