package luzq.std.jstd.spbt.service;

import com.alibaba.fastjson.JSON;
import luzq.std.jstd.spbt.dao.cluster.AreaDao;
import luzq.std.jstd.spbt.model.cluster.AreaCity;
import luzq.std.jstd.spbt.model.cluster.SeriesJsonModel;
import luzq.std.jstd.spbt.model.cluster.SeriesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaService {
    @Autowired
    AreaDao areaDao;

    public List<AreaCity> getAllCity() {
        return areaDao.getAllCity();
    }

    public List<SeriesModel> getAllJson() {
        List<SeriesModel> ret = new ArrayList<>();
        List<SeriesJsonModel> list = areaDao.getSeriesJson();
        for (SeriesJsonModel json : list) {
//            List<SeriesModel> seriesModel = JSON.parseArray(json.getJson(), SeriesModel.class);
            ret.addAll(insertSer(json));
        }
        return ret;
    }
//
//    public List<SeriesModel> insertSeries() {
//        List<SeriesModel> ret = new ArrayList<>();
//        List<SeriesJsonModel> list = areaDao.getSeriesJson();
//        for (SeriesJsonModel json : list) {
//            try {
//                SeriesModel seriesModel = JSON.parseObject(json.getJson(), SeriesModel.class);
//                ret.add(seriesModel);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return ret;
//    }

    private List<SeriesModel> insertSer(SeriesJsonModel model) {

        List<SeriesModel> seriesModel = JSON.parseArray(model.getJson(), SeriesModel.class);
        for (SeriesModel ser : seriesModel) {
            insertModel(ser, model.getBrandid());
        }
        return seriesModel;
    }

    private void insertModel(SeriesModel model, int brandid) {
        int factoryId = Integer.parseInt(model.getCarMfrs().getId());
        String factoryName = model.getCarMfrs().getName();
        for (SeriesModel.ItemModel item : model.getCarSeries()) {
            Map<String, Object> map = new HashMap<>();
            map.put("seriesid", Integer.parseInt(item.getId()));
            map.put("seriesname", item.getName());
            map.put("factoryid", factoryId);
            map.put("factoryname", factoryName);
            map.put("brandid", brandid);
            areaDao.insertSeries(map);
        }
    }
}
