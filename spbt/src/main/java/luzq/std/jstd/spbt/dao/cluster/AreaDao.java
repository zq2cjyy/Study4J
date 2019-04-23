package luzq.std.jstd.spbt.dao.cluster;

import luzq.std.jstd.spbt.model.cluster.AreaCity;
import luzq.std.jstd.spbt.model.cluster.SeriesJsonModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AreaDao {
    List<AreaCity> getAllCity();

    List<SeriesJsonModel> getSeriesJson();

    boolean insertSeries(Map<String, Object> par);
}
