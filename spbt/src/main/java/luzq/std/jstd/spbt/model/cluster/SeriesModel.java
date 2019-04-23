package luzq.std.jstd.spbt.model.cluster;

import java.util.List;

public class SeriesModel {

    public static class ItemModel {

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private ItemModel carMfrs;
    private List<ItemModel> carSeries;

    public ItemModel getCarMfrs() {
        return carMfrs;
    }

    public void setCarMfrs(ItemModel carMfrs) {
        this.carMfrs = carMfrs;
    }

    public List<ItemModel> getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(List<ItemModel> carSeries) {
        this.carSeries = carSeries;
    }
}
