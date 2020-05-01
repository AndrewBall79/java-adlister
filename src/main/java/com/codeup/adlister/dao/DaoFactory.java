package com.codeup.adlister.dao;

import Models.Config;
import com.codeup.adlister.models.User;

public class DaoFactory {
    private static Ads adsDao;
    private static Users userDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUserDao(){
        if (userDao == null) {
            userDao = new MySQLUsersDao(config);
        }
        return userDao;
    }

}
