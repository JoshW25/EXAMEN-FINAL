/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipos.modelo;


import seguridad.modelo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import prototipos.controlador.clsEntrenador;

/**
 *
 * @author visitante
 */
public class daoEntrenador {
    //programado por josue moran 

    private static final String SQL_SELECT = "SELECT ID_ENTRENADOR,NOMBRE1,NOMBRE2,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM entrenador";
    private static final String SQL_INSERT = "INSERT INTO entrenador (ID_ENTRENADOR, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, FECHA_NACIMIENTO) VALUES (?,?,?,?, ?, ?);";
    private static final String SQL_UPDATE = "UPDATE entrenador SET  NOMBRE1 = ?, NOMBRE2 = ?, APELLIDO1 = ? , APELLIDO2 = ?, FECHA_NACIMIENTO = ? WHERE entrenador.ID_ENTRENADOR = ?";
    private static final String SQL_DELETE = "DELETE FROM entrenador WHERE entrenador.ID_ENTRENADOR =?";
    private static final String SQL_QUERY = "ID_ENTRENADOR,NOMBRE1,NOMBRE2,APELLIDO1,APELLIDO2,FECHA_NACIMIENTO FROM entrenador WHERE entrenador.ID_ENTRENADOR =?";
 

    public List<clsEntrenador> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       clsEntrenador compras = null;
        List<clsEntrenador> compra = new ArrayList<clsEntrenador>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_ENTRENADOR");
                String n1 = rs.getString("NOMBRE1");
                String n2 = rs.getString("NOMBRE2");
                String a1 = rs.getString("APELLIDO1");
                String a2 = rs.getString("APELLIDO2");
                String fecha = rs.getString("FECHA_NACIMIENTO");
                
                

                compras = new clsEntrenador();
                compras.setId(id);
                compras.setNombre1(n1);
                compras.setNombre2(n2);
                compras.setApellido1(a1);
                compras.setApellido2(a2);
                compras.setFecha(fecha);
                

                compra.add(compras);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compra;
    }

 

    public int insert(clsEntrenador producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,producto.getId());
            stmt.setString(2, producto.getNombre1());
            stmt.setString(3, producto.getNombre2());
            stmt.setString(4, producto.getApellido1());
            stmt.setString(5, producto.getApellido2());
            stmt.setString(6, producto.getFecha());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    

    public int update(clsEntrenador producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,producto.getNombre1());
            stmt.setString(2, producto.getNombre2());
            stmt.setString(3,producto.getApellido1());
            stmt.setString(4, producto.getApellido2());
            stmt.setString(5,producto.getFecha());
            stmt.setInt(6, producto.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

  
    public int delete(clsEntrenador producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }


    public clsEntrenador query(clsEntrenador compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, compras.getId());

            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_ENTRENADOR");
                String n1 = rs.getString("NOMBRE1");
                String n2 = rs.getString("NOMBRE2");
                String a1 = rs.getString("APELLIDO1");
                String a2 = rs.getString("APELLIDO2");
                String fecha = rs.getString("FECHA_NACIMIENTO");
                

                compras = new clsEntrenador();
                compras.setId(id);
                compras.setNombre1(n1);
                compras.setNombre2(n2);
                compras.setApellido1(a1);
                compras.setApellido2(a2);
                compras.setFecha(fecha);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return compras;
    }


}
