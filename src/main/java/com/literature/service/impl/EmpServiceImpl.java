package com.literature.service.impl;

import com.literature.entity.Emp;
import com.literature.mapper.EmpMapper;
import com.literature.service.EmpService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * InnoDB free: 11264 kB; (`dept_id`) REFER `test/dept`(`id`) 服务实现类
 * </p>
 *
 * @author Literature
 * @since 2018-11-07
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

	@Autowired
	protected EmpMapper empMapper;
	
	@Override
	public Emp getWithDept(long id) {
		return empMapper.selectByPrimaryKeyWithDept(id);
	}
	
	@Override
	public IPage<Emp> getByDeptIdWithDept(IPage<Emp> page, long deptId) {
		return empMapper.selectByDeptIdWithDept(page,deptId);
	}

}
