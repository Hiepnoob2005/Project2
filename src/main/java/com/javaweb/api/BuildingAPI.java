package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

import org.springframework.web.bind.annotation.ResponseBody;

import customexception.FieldRequiredException;

@RestController
public class BuildingAPI {
	private BuildingService buildingService;
	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuidling(@RequestParam(name = "name",required = false) String name ,
			@RequestParam(name = "districtId",required = false) Long district,
			@RequestParam(name = "typecode",required = false) List<String> typecode){
		List<BuildingDTO> result = buildingService.findAll(name,district);
		return result;
		
	}
//    @GetMapping("/test")
//    public String testAPI() {
//        return "success";
//    }
//	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
//	@GetMapping(value = "/api/building/")
//	@ResponseBody
//	@GetMapping(value = "/api/building/")
//	public List<BuildingDTO> getBuidling(@RequestParam(name = "name") String name) {
//		String sql  = "SELECT * FROM building b WHERE name like'%"+ name +" %'";
//		List<BuildingDTO> result = new ArrayList<>();
//		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);
//				){
//			while (rs.next()) {
//				BuildingDTO building1 = new BuildingDTO();
//				building1.setName(rs.getString("name"));
//				building1.setStreet(rs.getString("street"));
//				building1.setNumberofBasement(rs.getInt("numberofBasement"));
//				building1.setWard(rs.getString("ward"));
//				result.add(building1);
//			}
//	    }
//	catch (SQLException e) {
//	    e.printStackTrace();
//	    System.out.println("Connected database failed...");
//	}
//		return result;
//	}
		//xử lý DB xong rồi
//		List<BuildingDTO> listBuildings = new ArrayList<>();
//		BuildingDTO buildingDTO1 = new BuildingDTO();
//		buildingDTO1.setName("ABC building");
//		buildingDTO1.setNumberofBasement(3);
//		buildingDTO1.setWard("Tan Mai");
//		BuildingDTO buildingDTO2 = new BuildingDTO();
//		buildingDTO1.setName("ACM Tower");
//		buildingDTO1.setNumberofBasement(2);
//		buildingDTO1.setWard("Da Cao");
//		listBuildings.add(buildingDTO1);
//		listBuildings.add(buildingDTO2);
//		try {
//			System.out.print(5/0);
//			valiDate(building);
//		}
//		catch (Exception e) {
////			System.out.print(e.getMessage());
//			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//			errorResponseDTO.setError(e.getMessage());
//			List<String> details = new ArrayList<>();
//			details.add("check lại name hoặc num đi bị null đó");
//			errorResponseDTO.setDetail(details);
//			return errorResponseDTO;
//		}
//		System.out.print(5/0);
//		valiDate(building);
//		return result;
//		BuildingDTO res = new BuildingDTO();
//		res.setName(name);
//		res.setNumberofBasement(numberofBasement);
//		res.setWard(ward);
//		return res;
//		return listBuildings;
	public void valiDate(BuildingDTO buildingDTO){
		if (buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumberofBasement() == null) {
			throw new FieldRequiredException("name or numberofBasements is null");
		}
	}
//	@RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//	@PostMapping(value = "/api/building/")
//	public BuildingDTO getBuidling2(@RequestBody BuildingDTO building) {
////		BuildingDTO buildingDTO = null;
//		//sau khi xử lý DB
//		return building;
//	}
	@DeleteMapping(value = "/api/building/{id}/{name}")
	public void deleteBuilding(@PathVariable Integer id,
								@PathVariable String name ) {
		System.out.print("Da xoa toa nha co id" + id + "roi nha");
	}
}
