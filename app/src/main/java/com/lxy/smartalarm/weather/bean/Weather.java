package com.lxy.smartalarm.weather.bean;

import java.util.List;

/**
 * Created by lxy on 2018/7/24.
 */

public class Weather {

    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101040100","location":"重庆","parent_city":"重庆","admin_area":"重庆","cnty":"中国","lat":"29.56376076","lon":"106.55046082","tz":"+8.00"}
         * update : {"loc":"2018-11-03 13:45","utc":"2018-11-03 05:45"}
         * status : ok
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"305","cond_txt_d":"多云","cond_txt_n":"小雨","date":"2018-11-03","hum":"47","mr":"02:20","ms":"15:34","pcpn":"0.0","pop":"1","pres":"1016","sr":"07:09","ss":"18:05","tmp_max":"24","tmp_min":"13","uv_index":"0","vis":"20","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"6"},{"cond_code_d":"305","cond_code_n":"305","cond_txt_d":"小雨","cond_txt_n":"小雨","date":"2018-11-04","hum":"48","mr":"03:24","ms":"16:13","pcpn":"0.0","pop":"13","pres":"1015","sr":"07:10","ss":"18:04","tmp_max":"20","tmp_min":"14","uv_index":"0","vis":"20","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"7"},{"cond_code_d":"305","cond_code_n":"305","cond_txt_d":"小雨","cond_txt_n":"小雨","date":"2018-11-05","hum":"78","mr":"04:25","ms":"16:50","pcpn":"5.0","pop":"80","pres":"1018","sr":"07:10","ss":"18:03","tmp_max":"17","tmp_min":"14","uv_index":"1","vis":"16","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"8"},{"cond_code_d":"305","cond_code_n":"305","cond_txt_d":"小雨","cond_txt_n":"小雨","date":"2018-11-06","hum":"79","mr":"05:27","ms":"17:28","pcpn":"2.0","pop":"55","pres":"1024","sr":"07:11","ss":"18:02","tmp_max":"11","tmp_min":"9","uv_index":"1","vis":"15","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"7"},{"cond_code_d":"104","cond_code_n":"101","cond_txt_d":"阴","cond_txt_n":"多云","date":"2018-11-07","hum":"86","mr":"06:28","ms":"18:06","pcpn":"5.0","pop":"80","pres":"1023","sr":"07:12","ss":"18:02","tmp_max":"17","tmp_min":"9","uv_index":"1","vis":"13","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"2"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-11-08","hum":"82","mr":"07:29","ms":"18:45","pcpn":"0.0","pop":"2","pres":"1024","sr":"07:13","ss":"18:01","tmp_max":"18","tmp_min":"11","uv_index":"4","vis":"17","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"9"},{"cond_code_d":"101","cond_code_n":"104","cond_txt_d":"多云","cond_txt_n":"阴","date":"2018-11-09","hum":"78","mr":"08:27","ms":"19:27","pcpn":"0.0","pop":"3","pres":"1020","sr":"07:14","ss":"18:01","tmp_max":"18","tmp_min":"12","uv_index":"4","vis":"19","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"8"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private List<DailyForecast> daily_forecast;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<DailyForecast> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecast> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public static class BasicBean {
            /**
             * cid : CN101040100
             * location : 重庆
             * parent_city : 重庆
             * admin_area : 重庆
             * cnty : 中国
             * lat : 29.56376076
             * lon : 106.55046082
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2018-11-03 13:45
             * utc : 2018-11-03 05:45
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }


    }
}
