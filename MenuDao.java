package com.sxt.taobao.menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sxt.taobao.common.db.DB;
import com.sxt.taobao.menu.bean.Menu;


public class MenuDao {

	/**
	 * 根据菜单Id获取菜单信息
	 * @param menuId
	 * @return
	 */
	public JSONObject getMenuById(Integer menuId){
		String sql = "select * from rbac_menu where menu_id = ? ";
		
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,sql);
		ResultSet rs = null;
		
		JSONObject menu = null;
		try{
			stmt.setInt(1, menuId);
			rs = stmt.executeQuery();
			while(rs.next()){
				//将集合封装在集合对象中
				menu = new JSONObject();
				getMenuFromRs(menu,rs);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return menu;
	}
	/**
	 * 根据菜单名称获取菜单
	 * @param menuId
	 * @return
	 */
	public JSONObject getMenuByName(String menuName){
		String sql = "select * from rbac_menu where menu_name = ? ";
		
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,sql);
		ResultSet rs = null;
		
		JSONObject menu = null;
		try{
			stmt.setString(1, menuName);
			rs = stmt.executeQuery();
			while(rs.next()){
				//将集合封装在集合对象中
				menu = new JSONObject();
				getMenuFromRs(menu,rs);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return menu;
	}
	
	/**
	 * 鏍规嵁浼犲叆鏉′欢鏌ヨ鑿滃崟淇℃伅
	 * @param menuObj 鑿滃崟瀵硅薄
	 * @param pageSize 鍒嗛〉淇℃伅鏁�姣忛〉鏄剧ず鐨勮褰曟潯鏁�
	 * @param pageIndex 鍒嗛〉绱㈠紩(褰撳墠椤电爜)
	 * @param orderByName 鎺掑簭瀛楁
	 * @param orderByRule 鎺掑簭瑙勫垯
	 * @return
	 */
	public JSONArray getRoleMenuList(JSONObject menuObj,Integer pageSize,Integer pageIndex,
												String orderByName,String orderByRule){
		JSONArray list = new JSONArray();
		
		StringBuffer sql = new StringBuffer("select * from rbac_menu where 1=1");
		//濡傛灉鑿滃崟ID涓嶄负绌哄鍔犺繃婊ゆ潯浠�
		if(menuObj.get("menuId") != null && menuObj.get("menuId")!=""){
			sql.append(" and menu_id = ? ");
		}
		
		//鏍规嵁浼犲叆鐨勫垎椤电储寮曞拰鍒嗛〉鏄剧ず鏁拌繘琛屽垎椤垫煡璇�濡傛灉pageSize涓�鍒欐煡璇㈠叏閮ㄤ俊鎭�
		if(pageSize > 0){
			Integer countFrom = pageSize*(pageIndex-1);
			Integer countTo = pageSize*pageIndex;
			sql.append(" limit " + countFrom + "," + countTo);
		}
		//鎸夌収鎸囧畾鎺掑簭瑙勫垯杩涜鎺掑簭鏌ヨ
		sql.append(" order by " + orderByName + " " + orderByRule);
		
		
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,sql.toString());
		ResultSet rs = null;
		
		JSONObject menu;
		
		try {
			//
			if(menuObj.get("menuId") != null && menuObj.get("menuId")!=""){
				stmt.setInt(0, Integer.parseInt(menuObj.get("menuId").toString()));
			}
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				menu = new JSONObject();
				getMenuFromRs(menu,rs);
				
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 鏍规嵁浼犲叆鏉′欢鏌ヨ鑿滃崟淇℃伅
	 * @param menuObj 鐢ㄦ埛瀵硅薄
	 * @param pageSize 鍒嗛〉淇℃伅鏁�姣忛〉鏄剧ず鐨勮褰曟潯鏁�
	 * @param pageIndex 鍒嗛〉绱㈠紩(褰撳墠椤电爜)
	 * @param orderByName 鎺掑簭瀛楁
	 * @param orderByRule 鎺掑簭瑙勫垯
	 * @return
	 */
	public JSONArray getMenuListByPage(JSONObject menuObj,Integer pageSize,Integer pageIndex,
												String orderByName,String orderByRule){
		JSONArray list = new JSONArray();
		
		StringBuffer sql = new StringBuffer("select * from rbac_menu where 1=1");
		sql.append(" order by " + orderByName + " " + orderByRule);
		//鏍规嵁浼犲叆鐨勫垎椤电储寮曞拰鍒嗛〉鏄剧ず鏁拌繘琛屽垎椤垫煡璇�濡傛灉pageSize涓�鍒欐煡璇㈠叏閮ㄤ俊鎭�
		if(pageSize > 0){
			Integer countFrom = pageSize*(pageIndex-1);
			Integer countTo = pageSize*pageIndex;
			sql.append(" limit " + countFrom + "," + countTo);
		}
		//鎸夌収鎸囧畾鎺掑簭瑙勫垯杩涜鎺掑簭鏌ヨ
		
		
		
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,sql.toString());
		ResultSet rs = null;
		
		JSONObject menu;
		
		try {
			rs = stmt.executeQuery();
			
			while(rs.next()){
				menu = new JSONObject();
				getMenuFromRs(menu,rs);
				
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 鏂板鑿滃崟璁板綍
	 * @param menu 鑿滃崟瀵硅薄
	 * @return 鎿嶄綔缁撴灉
	 */
	public Integer insertMenu(Menu menu){
		
		Integer result = 0;
		//瀹氫箟鎻掑叆鏁版嵁鐨凷QL璇彞
		String insertSQL = "insert into rbac_menu (menu_name,menu_parent_id,menu_index,menu_icon,menu_url,menu_desc) values(?,?,?,?,?,?)";
		
		//鎵撳紑鏁版嵁搴撹繛鎺�
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,insertSQL);

		try{
			//缁檚tmt瀵硅薄璁剧疆鍙傛暟
			//stmt.setInt(1, menu.getMenuId());
			stmt.setString(1, menu.getMenuName());
			stmt.setInt(2,menu.getMenuParentId());
			stmt.setInt(3, menu.getMenuIndex());
			stmt.setString(4, menu.getMenuIcon());
			stmt.setString(5, menu.getMenuUrl());
			stmt.setString(6, menu.getMenuDesc());
			
			//鎵ц鎻掑叆鏇存柊鎿嶄綔
			result = stmt.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 鏇存柊鑿滃崟璁板綍
	 * @param menu 鑿滃崟瀵硅薄
	 * @return 鎿嶄綔缁撴灉
	 */
	public Integer updateMenu(JSONObject json){
		
		Integer result = 0;
		//瀹氫箟鏇存柊鏁版嵁鐨凷QL璇彞
		String updateSQL = "update rbac_menu set menu_name = ?, menu_Parent_Id = ?, menu_Index = ?, menu_Icon = ?, menu_Url = ?, menu_Desc = ?  where menu_id = ?";
		
		//鎵撳紑鏁版嵁搴撹繛鎺�
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,updateSQL);

		try{
			//缁檚tmt瀵硅薄璁剧疆鍙傛暟
			stmt.setString(0, json.getString("menuName"));
			stmt.setInt(1, json.getInt("menuParentId"));
			stmt.setInt(2, json.getInt("menuIndex"));
			stmt.setString(3, json.getString("menuIcon"));
			stmt.setString(4, json.getString("menuUrl"));
			stmt.setString(5, json.getString("menuDesc"));
			
			//鎵ц鎻掑叆鏇存柊鎿嶄綔
			result = stmt.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 鍒犻櫎鑿滃崟璁板綍
	 * @param menuId 鐢ㄦ埛瀵硅薄ID
	 * @return 鎿嶄綔缁撴灉
	 */
	public Integer deleteMenu(Integer menuId){
		
		Integer result = 0;
		//瀹氫箟鍒犻櫎鏁版嵁鐨凷QL璇彞
		String deleteSQL = "delete from rbac_menu where menu_Id = ?";
		
		//鎵撳紑鏁版嵁搴撹繛鎺�
		Connection conn = DB.getConn();
		PreparedStatement stmt = DB.getStatement(conn,deleteSQL);

		try{
			//缁檚tmt瀵硅薄璁剧疆鍙傛暟
			stmt.setInt(0, menuId);
			
			//鎵ц鎻掑叆鏇存柊鎿嶄綔
			result = stmt.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return result;
	}
	
	//灏嗕粠RS涓彇鍑虹殑鍊煎拰menuBEAN灞炴�杩涜瀵瑰簲
	private void getMenuFromRs(JSONObject menu,ResultSet rs) throws SQLException{
		menu.put("menuId",rs.getInt("menu_id"));
		menu.put("menuName",rs.getString("menu_name"));
		menu.put("menuParentId",rs.getInt("menu_Parent_Id"));
		menu.put("menuIndex",rs.getInt("menu_Index"));
		menu.put("menuIcon",rs.getString("menu_Icon"));
		menu.put("menuUrl",rs.getString("menu_Url"));
		menu.put("menuDesc",rs.getString("menu_Desc"));
	}
}
