package com.edubridge.powerbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.powerbook.model.Powerbank;
import com.edubridge.powerbook.util.DBUtils;

public class PowerbankDaoImpl implements PowerbankDao {

	    @Override
	    public int addPowerbank(Powerbank pb) {
	        String insert = "INSERT INTO powerbanks(id, name, price, quantity, brand, description, color) VALUES(?, ?, ?, ?, ?, ?, ?)";
	        Connection con = DBUtils.getConnection();
	        int status = 0;
	        try {
	            PreparedStatement ps = con.prepareStatement(insert);
	            
	            ps.setInt(1, pb.getId());
	            ps.setString(2, pb.getName());
	            ps.setFloat(3, pb.getPrice());
	            ps.setLong(4, pb.getQuantity());
	            ps.setString(5, pb.getBrand());
	            ps.setString(6, pb.getDiscription());
	            ps.setString(7, pb.getColor());
	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	    @Override
	    public List<Powerbank> getAllPowerbanks() {
	        String select = "SELECT * FROM powerbanks";
	        Connection con = DBUtils.getConnection();
	        List<Powerbank> powerbank = new ArrayList<>();
	        try {
	            PreparedStatement ps = con.prepareStatement(select);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Powerbank pb = new Powerbank();
	                pb.setId(rs.getInt("id"));
	                pb.setName(rs.getString("name"));
	                pb.setPrice(rs.getFloat("price"));
	                pb.setQuantity(rs.getLong("quantity"));
	                pb.setBrand(rs.getString("brand"));
	                pb.setDiscription(rs.getString("description"));
	                pb.setColor(rs.getString("Color"));
	                powerbank.add(pb);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return powerbank;
	    }

	    @Override
	    public Powerbank getPowerbank(String name) {
	        String select = "SELECT * FROM Powerbanks WHERE name = ?";
	        Connection con = DBUtils.getConnection();
	        Powerbank pb = null;
	        try {
	            PreparedStatement ps = con.prepareStatement(select);
	            ps.setString(1, name);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                pb = new Powerbank();
	                pb.setId(rs.getInt("id"));
	                pb.setName(rs.getString("name"));
	                pb.setPrice(rs.getFloat("price"));
	                pb.setQuantity(rs.getLong("quantity"));
	                pb.setBrand(rs.getString("brand"));
	                pb.setDiscription(rs.getString("discription"));
	                pb.setColor(rs.getString("Color"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return pb;
	    }

	    @Override
	    public int updatePowerbank(Powerbank pb) {
	        String update = "UPDATE Powerbanks SET id = ?,price = ?,quantity = ?,brand = ?,discription = ?,colors = ? where name = ?";
	        Connection con = DBUtils.getConnection();
	        int status = 0;
	        try {
	            PreparedStatement ps = con.prepareStatement(update);
	            ps.setInt(1, pb.getId());
	            ps.setFloat(2, pb.getPrice());
	            ps.setLong(3, pb.getQuantity());
	            ps.setString(4, pb.getBrand());
	            ps.setString(5, pb.getDiscription());
	            ps.setString(6, pb.getColor());
	            ps.setString(7, pb.getName());

	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	    @Override
	    public int deletePowerbank(String name) {
	        String delete = "DELETE FROM Powerbanks WHERE name = ?";
	        Connection con = DBUtils.getConnection();
	        int status = 0;
	        try {
	            PreparedStatement ps = con.prepareStatement(delete);
	            ps.setString(1, name);

	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return status;
	    }

	    @Override
	    public void deleteAllPowerbanks() {
	        String deleteAll = "DELETE FROM Powerbanks";
	        Connection con = DBUtils.getConnection();
	        try {
	            PreparedStatement ps = con.prepareStatement(deleteAll);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
}
