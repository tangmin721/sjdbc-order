package com.cachexic.sjdbc.common.config.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;


@Component
@Configuration
@Order(1)
public class DruidDatasource implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 公共属性
     */
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.datasource.removeAbandoned}")
    private boolean removeAbandoned;

    @Value("${spring.datasource.removeAbandonedTimeout}")
    private int removeAbandonedTimeout;

    @Value("${spring.datasource.logAbandoned}")
    private boolean logAbandoned;

    @Value("${spring.datasource.slowSqlMillis}")
    private String slowSqlMillis;

    /**
     * 数据源ds_0
     * @param url
     * @param username
     * @param password
     * @return
     */
    @Bean(name = "ds_0")
    @Primary
    @ConfigurationProperties(prefix = "sharding.jdbc.datasource")
    public DataSource ds_0(
            @Value("${sharding.jdbc.datasource.ds_0.url}") String url,
            @Value("${sharding.jdbc.datasource.ds_0.username}") String username,
            @Value("${sharding.jdbc.datasource.ds_0.password}") String password) {
        DruidDataSource datasource = getDruidDataSource(url, username, password);
        return datasource;
    }

    /**
     * 数据源ds_1
     * @param url
     * @param username
     * @param password
     * @return
     */
    @Bean(name = "ds_1")
    @ConfigurationProperties(prefix = "sharding.jdbc.datasource")
    public DataSource ds_1(
            @Value("${sharding.jdbc.datasource.ds_1.url}") String url,
            @Value("${sharding.jdbc.datasource.ds_1.username}") String username,
            @Value("${sharding.jdbc.datasource.ds_1.password}") String password) {
        DruidDataSource datasource = getDruidDataSource(url, username, password);
        return datasource;
    }

    private DruidDataSource getDruidDataSource(String url, String username, String password) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        setCommonProperties(datasource);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        return datasource;
    }


    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", "druid");
        reg.addInitParameter("loginPassword", "druid123456");
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
        filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");
        return filterRegistrationBean;
    }

    private void setCommonProperties(DruidDataSource datasource) {
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setRemoveAbandoned(removeAbandoned);
        datasource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        datasource.setLogAbandoned(logAbandoned);
        datasource.setConnectionProperties("druid.stat.slowSqlMillis="+slowSqlMillis);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}