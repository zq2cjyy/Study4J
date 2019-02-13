package luzq.std.jstd.spbt.dao.cluster;

import luzq.std.jstd.spbt.model.cluster.AreaCity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaDao {
    List<AreaCity> getAllCity();
}
