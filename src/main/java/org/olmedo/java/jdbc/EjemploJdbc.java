package org.olmedo.java.jdbc;

import org.olmedo.java.jdbc.models.Producto;
import org.olmedo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.olmedo.java.jdbc.repositorio.Repositorio;
import org.olmedo.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);

            System.out.println(repositorio.porId(2L));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
