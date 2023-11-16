/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.Conexion;
import datos.impl.CrudSimpleInterface;
import dominio.Propiedades;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author JcarlosAd7
 */
public class PropiedadesDAO  implements CrudSimpleInterface<Propiedades> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public PropiedadesDAO(){
        CON=Conexion.getInstancia();
    }
    
    @Override
    public List<Propiedades> listar(String texto) {
        List<Propiedades> registros=new ArrayList();
        try {
            ps=CON.conectar().prepareStatement("SELECT * FROM propiedades WHERE nombre LIKE ?");
            ps.setString(1,"%" + texto +"%");
            rs=ps.executeQuery();
            while(rs.next()){
                //int id, String nombre, String direccion, boolean activo, String caracteristicas, String estado, float alquiler, String created_at, String updated_at
                registros.add(new Propiedades(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7), rs.getString(8)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Propiedades obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("INSERT INTO propiedades (nombre,direccion,activo) VALUES (?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Propiedades obj) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE propiedades SET nombre=?, direccion=? WHERE id=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());
            ps.setInt(3, obj.getId());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE propiedades SET activo=0 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE propiedades SET activo=1 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros=0;
        try {
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) FROM propiedades");            
            rs=ps.executeQuery();
            
            while(rs.next()){
                totalRegistros=rs.getInt("COUNT(id)");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT nombre FROM propiedades WHERE nombre=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }           
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
    
}