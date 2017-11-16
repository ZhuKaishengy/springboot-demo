package com.aisino.sysconfig;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.aisino.db2.dbconfig.Db2Config;

import oracle.jdbc.xa.client.OracleXADataSource;

/**
 * @Description: 相当于applicationContext中的数据源配置（annotation版）@Primary:指定默认数据源
 * @author zhukaishengy
 * @date 2017年11月14日
 */
@Configuration
@MapperScan(basePackages={"com.aisino.db2.dao"},sqlSessionTemplateRef="sqlSessionTemplate2")
public class ApplicationContext_DataBase_Second {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource.db2")
	public DataSource dataSource2(Db2Config db2Config) throws SQLException{
		OracleXADataSource dataSource = new OracleXADataSource();
		dataSource.setURL(db2Config.getUrl());
		dataSource.setUser(db2Config.getUsername());
		dataSource.setPassword(db2Config.getPassword());
		AtomikosDataSourceBean adDataSource = new AtomikosDataSourceBean(); 
		adDataSource.setXaDataSource(dataSource);
		return adDataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager2(@Qualifier("dataSource2") DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate2(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory){
		  return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
	}
		
}
