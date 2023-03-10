package org.olmedo.java.jdbc;

import org.olmedo.java.jdbc.models.Categoria;
import org.olmedo.java.jdbc.models.Producto;
import org.olmedo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.olmedo.java.jdbc.repositorio.Repositorio;
import org.olmedo.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= insertar nuevo producto =============");
            Producto producto = new Producto();
            producto.setNombre("Teclado Razer mecanico");
            producto.setPrecio(550);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L); // este es del id de computacion de las relacion de categorias
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("producto guardado con exito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
