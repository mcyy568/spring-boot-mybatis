package com.lance.mybatis.conf.dataSource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lance.mybatis.Application;

/**
 * @author 菩提树下的椰子
 * 
 * 数据源配置
 */

@Configuration
@EnableTransactionManagement 				// 启用事务
@MapperScan("com.lance.mybatis.mapper") 	// Mybatis扫描mapper
public class DataSourceConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	// 单数据源配置
	// @Bean
	// @Primary
	// @ConfigurationProperties(prefix = "spring.datasource")
	// public DataSource dataSource() {
	// LOGGER.info("-------------------- Configuring Datasource ---------------------");
	// return new DruidDataSource();
	// }
	//
	// @Bean
	// public PlatformTransactionManager txManager() {
	// return new DataSourceTransactionManager(dataSource());
	// }

	
	
	//-------------------------分隔--------------------------------
	
	
	
	// 多数据源配置
    @Qualifier("primaryDataSource")
    @Bean(name="primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")  
    public DataSource primaryDataSource() {  
    	LOGGER.info("-------------------- primaryDataSource init ---------------------");
        DataSource dataSourceSecondary = DataSourceBuilder.create().build();
        return dataSourceSecondary;
    }
      

    @Qualifier("secondaryDataSource")
    @Bean(name="secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")  
    public DataSource secondaryDataSource() {  
    	LOGGER.info("-------------------- secondaryDataSource init ---------------------");
        DataSource dataSourceSecondary = DataSourceBuilder.create().build();
        return dataSourceSecondary;  
    }  

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@Aautowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource,
                                        @Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        Map<Object, Object> mapDataSources = new HashMap<>();
        mapDataSources.put(DatabaseType.test1, primaryDataSource);
        mapDataSources.put(DatabaseType.test2, secondaryDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(mapDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(primaryDataSource);// 默认的datasource设置为primaryDataSource
        return dataSource;
    }

    //配置事务管理器
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}