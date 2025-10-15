package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "hiep2005";
	@Override
	public List<BuildingEntity> findAll(String name,Long districtId) {
		
			StringBuilder sql  = new StringBuilder("SELECT * FROM building b WHERE 1 = 1 ");
			if (name!=null && !name.equals("")) {
				sql.append("AND b.name like '%"+ name + "%' ");
			}
			if (districtId !=null) {
				sql.append("AND b.districtId" + districtId + " ");
			}
			List<BuildingEntity> result = new ArrayList<>();
			try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql.toString());
					){
				while (rs.next()) {
					BuildingEntity building1 = new BuildingEntity();
					building1.setName(rs.getString("name"));
					building1.setStreet(rs.getString("street"));
					building1.setNumberofBasement(rs.getInt("numberofBasement"));
					building1.setWard(rs.getString("ward"));
					result.add(building1);
				}
		    }
		catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("Connected database failed...");
		}
		return result;
	}
}