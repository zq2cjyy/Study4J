package luzq.std.jstd.spbt.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = "luzq.std.jstd.spbt.dao.cluster", sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDatasourceConfig extends AbsDataSource {
    @Value("${cluster.datasource.url}")
    private String url;

    @Value("${cluster.datasource.username}")
    private String user;

    @Value("${cluster.datasource.password}")
    private String password;

    @Value("${cluster.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource() {
        return AbsDataSource.getDataSource(this);
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/cluster/*.xml"));
        return sessionFactory.getObject();
    }

    @Override
    protected String getUrl() {
        return this.url;
    }

    @Override
    protected String getDriver() {
        return this.driverClass;
    }

    @Override
    protected String getUser() {
        return this.user;
    }

    @Override
    protected String getPwd() {
        return this.password;
    }
}
