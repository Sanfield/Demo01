package com.sxt.taobao.user.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sxt.taobao.user.bean.User;
import com.sxt.taobao.user.dao.UserDao;

public class UserService {

	UserDao dao = new UserDao();
	
	/**
	 * �û���¼
	 * @param user
	 * @return
	 */
	public JSONObject login(User user){
		Integer result = dao.login(user);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json;
	}
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public JSONObject register(JSONObject jsonPara){
		User user = (User) JSONObject.toBean(jsonPara);
		Integer result = dao.insertUser(user);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json;
	}
	/**
	 * �����û�ID��ȡ�û���Ϣ
	 * @param userId
	 * @return
	 */
	public JSONObject getUserById(String userId){
		User user = dao.getUserById(userId);
		return JSONObject.fromObject(user);
	}
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param userObj
	 * @param pageSize
	 * @param pageIndex
	 * @param orderByName
	 * @param orderByRule
	 * @return
	 */
	public JSONArray getUserListByPage(User userObj,Integer pageSize,Integer pageIndex,
			String orderByName,String orderByRule){
		List<User> list = dao.getUserListByPage(userObj, pageSize, pageIndex, orderByName, orderByRule);
		return JSONArray.fromObject(list);
	}
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public JSONObject insertUser(User user){
		JSONObject json = new JSONObject();
		Integer result = dao.insertUser(user);
		json.put("result", result);
		return json;
	}
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public JSONObject updateUser(User user){
		JSONObject json = new JSONObject();
		Integer result = dao.updateUser(user);
		json.put("result", result);
		return json;
	}
	/**
	 * ɾ���û�
	 * @param userId
	 * @return
	 */
	public JSONObject deleteUser(String userId){
		JSONObject json = new JSONObject();
		Integer result = dao.deleteUser(userId);
		json.put("result", result);
		return json;
	}
}
