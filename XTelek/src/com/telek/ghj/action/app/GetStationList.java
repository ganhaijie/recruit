package com.telek.ghj.action.app;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.mapping.TStation;
import com.telek.ghj.service.StationService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class GetStationList extends HttpServlet{

	private static final long serialVersionUID = 5525425862826153979L;

	private StationService stationService=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String name=DataTools.nvl(request, "stationname", "");
			long page=DataTools.nvl(request, "page", 1L);//接收并处理显示的当前页的信息
			long rows=DataTools.nvl(request, "rows",10L);//接收并处理每页显示的行数信息
			
			try {
				Map<String, Object> jsonMap=stationService.getTStationList(name, page, rows);
				OutTools.printJSON(response, jsonMap);//JSON格式输出
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public StationService getStationService() {
		return stationService;
	}


	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}

	
}
