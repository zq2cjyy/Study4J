package luzq.std.jstd.spbt.config;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

public abstract class AbsDataSource {

    protected abstract String getUrl();

    protected abstract String getDriver();

    protected abstract String getUser();

    protected abstract String getPwd();


    public static DataSource getDataSource(AbsDataSource dataSourceConfig) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceConfig.getDriver());
        dataSource.setUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUser());
        dataSource.setPassword(dataSourceConfig.getPwd());
        return dataSource;
    }
}
