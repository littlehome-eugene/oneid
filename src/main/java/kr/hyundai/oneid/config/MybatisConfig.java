package kr.hyundai.oneid.config;

import kr.hyundai.oneid.PayData;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

import javax.sql.DataSource;

public abstract class MybatisConfig {
    protected void configureSqlSessionFactory(SqlSessionFactoryBean sessionFactoryBean, DataSource dataSource) throws IOException {
        PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setConfigLocation(pathResolver.getResource("classpath:mybatis/mybatis-config.xml"));
        sessionFactoryBean.setMapperLocations(pathResolver.getResources("classpath:mapper/*.xml"));
    }

}

@Configuration
@MapperScan(basePackages = {"kr.hyundai.oneid.module.persistence"}, annotationClass = PayData.class, sqlSessionFactoryRef = "paySqlSessionFactory")
class PayMyBatisConfig extends MybatisConfig {

    @Bean
    public SqlSessionFactory paySqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        configureSqlSessionFactory(sessionFactoryBean, dataSource);
        return sessionFactoryBean.getObject();
    }
}