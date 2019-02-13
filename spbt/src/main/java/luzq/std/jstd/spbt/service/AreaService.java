package luzq.std.jstd.spbt.service;

import luzq.std.jstd.spbt.dao.cluster.AreaDao;
import luzq.std.jstd.spbt.model.cluster.AreaCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {
    @Autowired
    AreaDao areaDao;

    public List<AreaCity> getAllCity() {
        return areaDao.getAllCity();
    }
}
