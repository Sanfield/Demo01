package com.sxt.taobao.menu.service;


import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sxt.taobao.menu.bean.Menu;
import com.sxt.taobao.menu.dao.MenuDao;

public class MenuService {

	
	MenuDao dao = new MenuDao();
	
	public JSONArray getMenuByDWR(JSONObject jsonPara){

		JSONArray jsonArray = dao.getRoleMenuList(jsonPara,0,0,"menu_index","asc");

		return jsonArray;
	}

	/**
	 * 根据角色ID获取菜单对象
	 * @param menuId
	 * @return
	 */
	public JSONObject getMenuById(Integer menuId){
		JSONObject json = dao.getMenuById(menuId);
		return json;
	}
	public JSONObject getMenuByName(String menuName){
		JSONObject json = dao.getMenuByName(menuName);
		return json;
	}
	
	/**
	 * 查询菜单列表信息
	 * @param json
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public JSONArray getMenuListByPage(JSONObject json,Integer pageSize,Integer pageIndex,
			String orderByName,String orderByRule){
		JSONArray jsonArray =  dao.getMenuListByPage(json, pageSize, pageIndex, orderByName, orderByRule);
		for(int i = 0;i<jsonArray.size(	);i++){
			JSONObject jsonObj= (JSONObject) jsonArray.get(i);
			JSONObject jsonParent = dao.getMenuById(jsonObj.getInt("menuParentId"));
			jsonObj.put("menuParentName",jsonParent!=null?jsonParent.getString("menuName"):"");
		}
		return jsonArray;
	}
	/**
	 * 新增菜单
	 * @param json
	 * @return
	 */
	public JSONObject insertMenu(Menu menu){
		JSONObject json = new JSONObject();
		Integer result = dao.insertMenu(menu);
		json.put("result", result);
		return json;
	}
	/**
	 * 更新菜单
	 * @param json
	 * @return
	 */
	public JSONObject updateMenu(JSONObject json){
		Integer result = dao.updateMenu(json);
		json.put("result", result);
		return json;
	}
	/**
	 * 删除菜单
	 * @param menuId
	 * @return
	 */
	public JSONObject deleteMenu(Integer menuId){
		JSONObject json = new JSONObject();
		Integer result = dao.deleteMenu(menuId);
		json.put("result", result);
		return json;
	}
	public JSONObject registerByServlet(HttpServletRequest request){
		String menuName = (String)request.getParameter("menuName");
		Integer menuParentId =  Integer.parseInt(request.getParameter("menuParentId"));
		Integer menuIndex =  Integer.parseInt(request.getParameter("menuIndex"));
		String menuIcon = (String)request.getParameter("menuIcon");
		String menuUrl = (String)request.getParameter("menuUrl");
		String menuDesc = (String)request.getParameter("menuDesc");
		
		Menu menu = new Menu();
		menu.setMenuName(menuName);
		menu.setMenuParentId(menuParentId);
		menu.setMenuIndex(menuIndex);
		menu.setMenuIcon(menuIcon);
		menu.setMenuUrl(menuUrl);
		menu.setMenuDesc(menuDesc);
		Integer result = dao.insertMenu(menu);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json;
	}
}
