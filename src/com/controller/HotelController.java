package com.controller;
import com.model.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
        
public class HotelController {
    private String conexion;

    public HotelController() {
        this.conexion = "jdbc:mysql://localhost:3306/hotel?user=root&password=Manyito123!";}
    
    public boolean agregarServicio(Servicio nuevoserv){
        try(Connection cnn = DriverManager.getConnection(conexion)){
            PreparedStatement ps = cnn.prepareStatement(
                    "INSERT INTO servicios (Concepto, IdHabitacion, Importe)"
                    + " values (?,?,?);");
            ps.setString(1, nuevoserv.getConcepto());
            ps.setInt(2, nuevoserv.getHabitacion().getId());
            ps.setDouble(3, nuevoserv.getImporte());
            ps.execute();
            cnn.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public List<Habitacion> obtenerHabitaciones(){
        List<Habitacion> habis = new ArrayList<>();
        try(Connection cnn = DriverManager.getConnection(conexion)){
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM habitaciones");
            while (rs.next()){
                Habitacion h = new Habitacion(rs.getInt("IdHabitacion"),
                        rs.getString("Denominacion"));
                habis.add(h);
            }
            rs.close();
            cnn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return habis;
    }
    
    public double reporteUno(){
        double x = -1;
        try(Connection cnn = DriverManager.getConnection(conexion)){
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery("SELECT sum(Importe) FROM hotel.servicios;");
            while (rs.next()){
                x = rs.getInt(1);
            }
            rs.close();
            cnn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return x;
    }
    
    public List<HabitacionReporteDTO> reporteDos(){
        List<HabitacionReporteDTO> habis = new ArrayList<>();
        try(Connection cnn = DriverManager.getConnection(conexion)){
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery("SELECT h.IdHabitacion, Denominacion,"
                    + " sum(s.importe) as Suma FROM hotel.habitaciones h" +
                    " JOIN hotel.servicios s on s.IdHabitacion = h.IdHabitacion" +
                    " group by h.IdHabitacion, Denominacion" +
                    " having count(h.IdHabitacion) > 3;");
            while (rs.next()){
                HabitacionReporteDTO h = new HabitacionReporteDTO(rs.getInt("IdHabitacion"),
                        rs.getString("Denominacion"), rs.getDouble("Suma"));
                habis.add(h);
            }
            rs.close();
            cnn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return habis;
    }
    
    public List<ServicioReporteDTO> reporteTres(int n){
        List<ServicioReporteDTO> serv = new ArrayList<>();
        try(Connection cnn = DriverManager.getConnection(conexion)){
            PreparedStatement ps = cnn.prepareStatement("SELECT s.Concepto,"
                    + " s.Importe FROM"
                    + " servicios s WHERE IdHabitacion = ?;");
            ps.setInt(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ServicioReporteDTO s = new ServicioReporteDTO(rs.getString("Concepto"),
                        rs.getDouble("Importe"));
                serv.add(s);
            }
            rs.close();
            cnn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return serv;
        
    }
    
}
