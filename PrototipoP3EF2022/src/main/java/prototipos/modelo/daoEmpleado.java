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
import prototipos.controlador.clsEmpleado;

/**
 *
 * @author visitante
 */
public class daoEmpleado {
    //programado por josue moran 

    private static final String SQL_SELECT = "SELECT ID_EMPLEADO,NOMBRE1,NOMBRE2,APELLIDO1,APELLIDO2,CORREO,ID_TIPO_PUESTO,DIRECCION,FECHA_NACIMIENTO,NIT,DPI FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado (ID_EMPLEADO, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, CORREO, ID_TIPO_PUESTO, DIRECCION, FECHA_NACIMIENTO, NIT, DPI) VALUES (?, ?,?,?,?,?,?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE empleado SET  NOMBRE1 = ? , NOMBRE2 = ? , APELLIDO1 = ? , APELLIDO2 = ? , CORREO = ? ,ID_TIPO_PUESTO = ?, DIRECCION = ?,FECHA_NACIMIENTO = ?, NIT = ?, DPI = ? WHERE empleado.ID_EMPLEADO = ?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE empleado.ID_EMPLEADO = ?";
    private static final String SQL_QUERY = "SELECT ID_EMPLEADO,NOMBRE1,NOMBRE2,APELLIDO1,APELLIDO2,CORREO,ID_TIPO_PUESTO,DIRECCION,FECHA_NACIMIENTO,NIT,DPI FROM empleado WHERE empleado.ID_EMPLEADO = ?";
 

    public List<clsEmpleado> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       clsEmpleado compras = null;
        List<clsEmpleado> compra = new ArrayList<clsEmpleado>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_EMPLEADO");
                String n1 = rs.getString("NOMBRE1");
                String n2 = rs.getString("NOMBRE2");
                String a1 = rs.getString("APELLIDO1");
                String a2 = rs.getString("APELLIDO2");
                String co = rs.getString("CORREO");
                int ti = rs.getInt("ID_TIPO_PUESTO");
                String di = rs.getString("DIRECCION");
                String fecha = rs.getString("FECHA_NACIMIENTO");
                String nit = rs.getString("NIT");
                String dpi = rs.getString("DPI");
                
                

                compras = new clsEmpleado();
                compras.setId(id);
                compras.setNombre1(n1);
                compras.setNombre2(n2);
                compras.setApellido1(a1);
                compras.setApellido2(a2);
                compras.setCorreo(co);
                compras.setPuesto(ti);
                compras.setDireccion(di);
                compras.setFecha(fecha);
                compras.setNit(nit);
                compras.setDpi(dpi);
                

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

 

    public int insert(clsEmpleado producto) {
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
            stmt.setString(6, producto.getCorreo());
            stmt.setInt(7,producto.getPuesto());
            stmt.setString(8, producto.getDireccion());
            stmt.setString(9, producto.getFecha());
            stmt.setString(10, producto.getNit());
            stmt.setString(11, producto.getDpi());
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

    

    public int update(clsEmpleado producto) {
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
            stmt.setString(5, producto.getCorreo());
            stmt.setInt(6, producto.getPuesto());
            stmt.setString(7, producto.getDireccion());
            stmt.setString(8,producto.getFecha()); 
            stmt.setString(9, producto.getNit());
            stmt.setString(10, producto.getNit());
            stmt.setInt(11, producto.getId());
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

  
    public int delete(clsEmpleado producto) {
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


    

}
