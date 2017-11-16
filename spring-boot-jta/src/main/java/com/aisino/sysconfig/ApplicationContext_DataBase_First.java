package com.aisino.sysconfig;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.aisino.db1.dbconfig.Db1Config;

import oracle.jdbc.xa.client.OracleXADataSource;

/**
 * @Description: 相当于applicationContext中的数据源配置（annotation版）@Primary:指定默认数据源
 * @author zhukaishengy
 * @date 2017年11月14日
 */
@Configuration
@MapperScan(basePackages={"com.aisino.db1.dao"},sqlSessionTemplateRef="sqlSessionTemplate1")
public class ApplicationContext_DataBase_First {

	@Primary
	@Bean
	public DataSource dataSource1(Db1Config db1Config) throws SQLException {
		OracleXADataSource dataSource = new OracleXADataSource();
		dataSource.setURL(db1Config.getUrl());
		dataSource.setUser(db1Config.getUsername());
		dataSource.setPassword(db1Config.getPassword());
		AtomikosDataSourceBean adDataSource = new AtomikosDataSourceBean(); 
		adDataSource.setXaDataSource(dataSource);
		return adDataSource;
	}
	
	@Bean
	@Primary
	public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
	}
	
	@Bean
	@Primary
	public DataSourceTransactionManager dataSourceTransactionManager1(@Qualifier("dataSource1") DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	@Primary
	public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory){
		  return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
	}
		
}
