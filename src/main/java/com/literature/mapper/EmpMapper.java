package com.literature.mapper;

import com.literature.entity.Emp;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * InnoDB free: 11264 kB; (`dept_id`) REFER `test/dept`(`id`) Mapper 接口
 * </p>
 *
 * @author Literature
 * @since 2018-11-07
 */
public interface EmpMapper extends BaseMapper<Emp> {

	Emp selectByPrimaryKeyWithDept(@Param(value="id")long id);

	IPage<Emp> selectByDeptIdWithDept(IPage<Emp> page,@Param(value="deptId") long deptId);

}
