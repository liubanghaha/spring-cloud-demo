package ${basepackage}.${namespace}.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ${basepackage}.${namespace}.domain.${table.className};

@Mapper
@Repository
public interface ${table.className}Mapper {
	
	/**
	 * 插入数据
	 * 
	 * @param ${table.classNameFirstLower}
	 * @return
	 */
	Integer insert(@Param("${table.classNameFirstLower}") ${table.className} ${table.classNameFirstLower});
	
	/**
	 * 更新数据
	 * 
	 * @param ${table.classNameFirstLower}
	 * @param where
	 * @return
	 */
	Integer update(@Param("${table.classNameFirstLower}") ${table.className} ${table.classNameFirstLower}, @Param("where") ${table.className} where);

	/**
	 * 根据主键更新
	 * 
	 * @param ${table.classNameFirstLower}
	 * @param ${table.classNameFirstLower}Id
	 * @return
	 */
	Integer updateById(@Param("${table.classNameFirstLower}") ${table.className} ${table.classNameFirstLower}, @Param("${table.classNameFirstLower}Id") ${table.pkColumn.javaType} ${table.classNameFirstLower}Id);
	
	/**
	 * 更新有值数据
	 * 
	 * @param ${table.classNameFirstLower}
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("${table.classNameFirstLower}") ${table.className} ${table.classNameFirstLower}, @Param("where") ${table.className} where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param ${table.classNameFirstLower}
	 * @param ${table.classNameFirstLower}Id
	 * @return
	 */
	Integer updateActiveById(@Param("${table.classNameFirstLower}") ${table.className} ${table.classNameFirstLower}, @Param("${table.classNameFirstLower}Id") ${table.pkColumn.javaType} ${table.classNameFirstLower}Id);

	/**
	 * 查询列表
	 * 
	 * @param ${table.classNameFirstLower}
	 * @return
	 */
	List<${table.className}> select(@Param("${table.classNameFirstLower}") ${table.className} ${table.classNameFirstLower});

	/**
	 * 根据主键查询
	 * 
	 * @param ${table.classNameFirstLower}Id
	 * @return
	 */
	${table.className} selectById(@Param("${table.classNameFirstLower}Id") ${table.pkColumn.javaType} ${table.classNameFirstLower}Id);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") ${table.className} where);

	/**
	 * 按主键删除
	 * 
	 * @param ${table.classNameFirstLower}Id
	 * @return
	 */
	Integer deleteById(@Param("${table.classNameFirstLower}Id") ${table.pkColumn.javaType} ${table.classNameFirstLower}Id);
}
