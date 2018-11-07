package com.literature.service;

import com.literature.entity.Emp;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * InnoDB free: 11264 kB; (`dept_id`) REFER `test/dept`(`id`) 服务类
 * </p>
 *
 * @author Literature
 * @since 2018-11-07
 */
public interface EmpService extends IService<Emp> {

	Emp getWithDept(long id);

	IPage<Emp> getByDeptIdWithDept(IPage<Emp> page, long deptId);

}
