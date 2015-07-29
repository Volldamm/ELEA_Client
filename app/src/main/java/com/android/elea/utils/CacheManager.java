package com.android.elea.utils;

import android.app.Activity;

import com.android.elea.beans.Country;
import com.android.elea.beans.Province;
import com.android.elea.beans.Town;
import com.android.elea.beans.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Borja on 04/06/2015.
 */
public class CacheManager {

    private static SessionManager session;

    private static Activity mainMenuActivity;

    private static Province blankProvince = new Province();
    private static Town blankTown = new Town();
    private static Country defaultCountry = new Country();
    private static User user = null;

    private static List<Province> provinceList;

    private static Map<Integer,List<Town>> townsMap = new HashMap<Integer,List<Town>>();


    public static SessionManager getSession() {
        return session;
    }

    public static void setSession(SessionManager session) {
        CacheManager.session = session;
    }

    public static Country getDefaultCountry() {
        return defaultCountry;
    }

    public static void setDefaultCountry(Country defaultCountry) {
        CacheManager.defaultCountry = defaultCountry;
    }

    public static Town getBlankTown() {
        return blankTown;
    }

    public static void setBlankTown(Town blankTown) {
        CacheManager.blankTown = blankTown;
    }

    public static Province getBlankProvince() {
        return blankProvince;
    }

    public static void setBlankProvince(Province blankProvince) {
        CacheManager.blankProvince = blankProvince;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        CacheManager.user = user;
    }

    public static List<Province> getProvinceList() {
        return provinceList;
    }

    public static void setProvinceList(List<Province> provinceList) {
        CacheManager.provinceList = provinceList;
    }

    public static Map<Integer, List<Town>> getTownsMap() {
        return townsMap;
    }

    public static void setTownsMap(Map<Integer, List<Town>> townsMap) {
        CacheManager.townsMap = townsMap;
    }


    public static Activity getMainMenuActivity() {
        return mainMenuActivity;
    }

    public static void setMainMenuActivity(Activity mainMenuActivity) {
        CacheManager.mainMenuActivity = mainMenuActivity;
    }
}
