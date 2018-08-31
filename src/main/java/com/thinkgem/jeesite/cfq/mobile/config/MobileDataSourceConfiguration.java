//package com.thinkgem.jeesite.cfq.mobile.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//
///**
// */
//
//@Configuration
//@MapperScan(basePackages = "com.thinkgem.jeesite.cfq.mobile.rest.dao", sqlSessionTemplateRef  = "mobileSqlSessionTemplate")
//public class MobileDataSourceConfiguration {
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.url}")
//    private String url;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//
//    @Bean(name = "mobileDataSource")
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(this.driverClassName);
//        dataSource.setUrl(this.url);
//        dataSource.setUsername(this.username);
//        dataSource.setPassword(this.password);
//        return dataSource;
//    }
//
//    @Bean(name = "mobileSqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("mobileDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappings/mobile/rest/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "mobileTransactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("mobileDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "mobileSqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("mobileSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}