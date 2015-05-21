package cn.looip.wap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.looip.wap.repository.dao.WapDao;
import cn.looip.wap.repository.domain.Project;
import cn.looip.wap.repository.domain.SysUser;
import cn.looip.wap.service.interfaces.WapService;

@Service
public class WapServiceImpl implements WapService {
	@Autowired
	private WapDao wapdao;// 当他报错时候，代表找不到实现类

	
	
	@Override
	public boolean getLogin(SysUser user) {
		if (wapdao.getUserName(user.getLoginName()) != null) {
			if (wapdao.getLogin(user.getLoginName(), user.getLoginPwd()) != null) {

				return true;
			}
		}
		return false;
	}
	


	@Override
	public Integer getUserName(String username) {
		
		return wapdao.getUserName(username);
	}



	@Override
	public List<Project> getProjects(int id) {
        
		return wapdao.getProjects(id);
	}

}
