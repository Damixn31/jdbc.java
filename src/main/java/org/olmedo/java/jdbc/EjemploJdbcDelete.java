package org.olmedo.java.jdbc;

import org.olmedo.java.jdbc.models.Producto;
import org.olmedo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.olmedo.java.jdbc.repositorio.Repositorio;
import org.olmedo.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= obtener por id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= eliminar producto  =============");
            repositorio.eliminar(3L);
            System.out.println("producto eliminado con exito!");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
