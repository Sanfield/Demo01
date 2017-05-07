package com.sxt.taobao.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sxt.taobao.common.db.DB;


public class RoleDao {

	/**
	 * 根据角色ID获取角色信息
	 * @param roleId
	 * @return
	 */
	public JSONObject getRoleById(Integer roleId){
		String sql = "select * from rbac_role where role_id = ? ";
		
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,sql);
		ResultSet rs = null;
		
		JSONObject user = null;
		try{
			stmt.setInt(1, roleId);
			rs = stmt.executeQuery();
			while(rs.next()){
				user = new JSONObject();
				getRoleFromRs(user,rs);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 根据角色名称获取角色信息
	 * @param roleName
	 * @return
	 */
	public JSONObject getRoleByName(String roleName){
		String sql = "select * from rbac_role where role_name = ? ";
		
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,sql);
		ResultSet rs = null;
		
		JSONObject user = null;
		try{
			stmt.setString(1, roleName);
			rs = stmt.executeQuery();
			while(rs.next()){
				user = new JSONObject();
				getRoleFromRs(user,rs);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 根据传入条件查询角色信息
	 * @param userObj 角色对象
	 * @param pageSize 分页信息数(每页显示的记录条数)
	 * @param pageIndex 分页索引(当前页码)
	 * @param orderByName 排序字段
	 * @param orderByRule 排序规则
	 * @return
	 */
	public JSONArray getRoleMenuList(JSONObject roleObj,Integer pageSize,Integer pageIndex,
												String orderByName,String orderByRule){
		JSONArray list = new JSONArray();
		
		StringBuffer sql = new StringBuffer("select * from rbac_role_menu where 1=1");
		//如果角色ID不为空增加过滤条件
		if(roleObj.get("roleId") != null && roleObj.get("roleId")!=""){
			sql.append(" and role_id = ? ");
		}
		
		//根据传入的分页索引和分页显示数进行分页查询(如果pageSize为0则查询全部信息)
		if(pageSize > 0){
			Integer countFrom = pageSize*(pageIndex-1);
			Integer countTo = pageSize*pageIndex;
			sql.append(" limit " + countFrom + "," + countTo);
		}
		//按照指定排序规则进行排序查询
		sql.append(" order by " + orderByName + " " + orderByRule);
		
		
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,sql.toString());
		ResultSet rs = null;
		
		JSONObject role;
		
		try {
			//
			if(roleObj.get("roleId") != null && roleObj.get("roleId")!=""){
				stmt.setInt(0, Integer.parseInt(roleObj.get("roleId").toString()));
			}
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				role = new JSONObject();
				getRoleFromRs(role,rs);
				
				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 根据传入条件查询角色信息
	 * @param userObj 用户对象
	 * @param pageSize 分页信息数(每页显示的记录条数)
	 * @param pageIndex 分页索引(当前页码)
	 * @param orderByName 排序字段
	 * @param orderByRule 排序规则
	 * @return
	 */
	public JSONArray getRoleListByPage(JSONObject userObj,Integer pageSize,Integer pageIndex,
												String orderByName,String orderByRule){
		JSONArray list = new JSONArray();
		
		StringBuffer sql = new StringBuffer("select * from rbac_role where 1=1");
		
		//按照指定排序规则进行排序查询
		sql.append(" order by " + orderByName + " " + orderByRule);
		
		//根据传入的分页索引和分页显示数进行分页查询(如果pageSize为0则查询全部信息)
		if(pageSize > 0){
			Integer countFrom = pageSize*(pageIndex-1);
			Integer countTo = pageSize*pageIndex;
			sql.append(" limit " + countFrom + "," + countTo);
		}
		
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,sql.toString());
		ResultSet rs = null;
		
		JSONObject role;
		
		try {
			rs = stmt.executeQuery();
			
			while(rs.next()){
				role = new JSONObject();
				getRoleFromRs(role,rs);
				
				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 新增角色记录
	 * @param role 角色对象
	 * @return 操作结果
	 */
	public Integer insertRole(JSONObject role){
		
		Integer result = 0;
		//定义插入数据的SQL语句
		String insertSQL = "insert into rbac_role (role_name,role_desc) values(?,?)";
		
		//打开数据库连接
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,insertSQL);

		try{
			//给stmt对象设置参数
			stmt.setString(1, role.get("roleName").toString());
			stmt.setString(2, role.get("roleDesc").toString());
			
			//执行插入更新操作
			result = stmt.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 更新角色记录
	 * @param role 角色对象
	 * @return 操作结果
	 */
	public Integer updateRole(JSONObject json){
		
		Integer result = 0;
		//定义更新数据的SQL语句
		String updateSQL = "update rbac_role set role_name = ?, role_Desc = ?  where role_id = ?";
		
		//打开数据库连接
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,updateSQL);

		try{
			//给stmt对象设置参数
			stmt.setString(0, json.getString("roleName"));
			stmt.setString(1, json.getString("roleDesc"));
			stmt.setInt(2, json.getInt("roleIndex"));
			
			//执行插入更新操作
			result = stmt.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 删除角色记录
	 * @param roleId 用户对象ID
	 * @return 操作结果
	 */
	public Integer deleteRole(Integer roleId){
		
		Integer result = 0;
		//定义删除数据的SQL语句
		String deleteSQL = "delete from rbac_role where role_Id = ?";
		
		//打开数据库连接
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,deleteSQL);

		try{
			//给stmt对象设置参数
			stmt.setInt(0, roleId);
			
			//执行插入更新操作
			result = stmt.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return result;
	}
	
	//将从RS中取出的值和USERBEAN属性进行对应
	private void getRoleFromRs(JSONObject user,ResultSet rs) throws SQLException{
		user.put("roleId",rs.getInt("role_id"));
		user.put("roleName",rs.getString("role_name"));
		user.put("roleDesc",rs.getString("role_Desc"));
	}
}
