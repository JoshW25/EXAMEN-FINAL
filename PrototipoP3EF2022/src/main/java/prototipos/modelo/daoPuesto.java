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
import prototipos.controlador.clsPuesto;

/**
 *
 * @author visitante
 */
public class daoPuesto {

    private static final String SQL_SELECT = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIO FROM tipo_puesto";
    private static final String SQL_INSERT = "INSERT INTO tipo_puesto (ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIO) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tipo_puesto SET  NOMBRE_PUESTO = ?, SALARIO = ? WHERE tipo_puesto.ID_TIPO_PUESTO = ?";
    private static final String SQL_DELETE = "DELETE FROM tipo_puesto WHERE tipo_puesto.ID_TIPO_PUESTO = ?";
    private static final String SQL_QUERY = "SELECT ID_TIPO_PUESTO, NOMBRE_PUESTO, SALARIO FROM tipo_puesto  WHERE tipo_puesto.ID_TIPO_PUESTO = ?";

    public List<clsPuesto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPuesto concepto = null;
        List<clsPuesto> concept = new ArrayList<clsPuesto>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int conid = rs.getInt("ID_TIPO_PUESTO");
                String connombre = rs.getString("NOMBRE_PUESTO");
                double conefecto = rs.getDouble("SALARIO");
                

                concepto = new clsPuesto();
                concepto.setId(conid);
                concepto.setNombre(connombre);
                concepto.setSalario(conefecto);
                
                
                concept.add(concepto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return concept;
    }

    public int insert(clsPuesto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, concepto.getId());
            stmt.setString(2, concepto.getNombre());
            stmt.setDouble(3, concepto.getSalario());
     

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


    public int update(clsPuesto concepto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, concepto.getNombre());
            stmt.setDouble(2, concepto.getSalario());
            stmt.setInt(3, concepto.getId());
        

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

    public int delete(clsPuesto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, concepto.getId());
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

    public clsPuesto query(clsPuesto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, concepto.getId());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                int conid = rs.getInt("ID_TIPO_PUESTO");
                String connombre = rs.getString("NOMBRE_PUESTO");
                double conefecto = rs.getDouble("SALARIO");
                

                concepto = new clsPuesto();
                concepto.setId(conid);
                concepto.setNombre(connombre);
                concepto.setSalario(conefecto);
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
        return concepto;
    }
}
