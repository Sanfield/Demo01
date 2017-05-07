package com.sxt.taobao.role.service;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sxt.taobao.role.dao.RoleDao;

public class RoleService {

	RoleDao dao = new RoleDao();
	
	public JSONArray getRoleByDWR(JSONObject jsonPara){

		JSONArray jsonArray = dao.getRoleMenuList(jsonPara,0,0,"role_index","asc");

		return jsonArray;
	}

	/**
	 * 根据ID获取角色信息
	 * @param roleId
	 * @return
	 */
	public JSONObject getRoleById(Integer roleId){
		JSONObject json = dao.getRoleById(roleId);
		return json;
	}
	
	/**
	 * 根据名称获取角色信息
	 * @param roleId
	 * @return
	 */
	public JSONObject getRoleByName(String roleName){
		JSONObject json = dao.getRoleByName(roleName);
		return json;
	}
	
	/**
	 * 查询角色列表
	 * @param json
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public JSONArray getRoleListByPage(JSONObject json,Integer pageSize,Integer pageIndex,
			String orderByName,String orderByRule){
		return dao.getRoleListByPage(json, pageSize, pageIndex, orderByName, orderByRule);
	}
	/**
	 * 新增角色
	 * @param json
	 * @return
	 */
	public JSONObject insertRole(JSONObject json){
		Integer result = dao.insertRole(json);
		json.put("result", result);
		return json;
	}
	/**
	 * 更新角色
	 * @param json
	 * @return
	 */
	public JSONObject updateRole(JSONObject json){
		Integer result = dao.updateRole(json);
		json.put("result", result);
		return json;
	}
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	public JSONObject deleteRole(Integer roleId){
		JSONObject json = new JSONObject();
		Integer result = dao.deleteRole(roleId);
		json.put("result", result);
		return json;
	}
}
