package org.olmedo.java.jdbc;

import org.olmedo.java.jdbc.models.Categoria;
import org.olmedo.java.jdbc.models.Producto;
import org.olmedo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.olmedo.java.jdbc.repositorio.Repositorio;
import org.olmedo.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= editar producto =============");
            Producto producto = new Producto();
            producto.setId(5L);
            producto.setNombre("Teclado Corsair k95 mecanico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria(); // agregamos una nueva categoria
            categoria.setId(2L); // asinamos la categoria 2 que es la de Tecnologia
            producto.setCategoria(categoria); // agregamos al producto la categoria

            repositorio.guardar(producto);
            System.out.println("producto editado con exito!");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
