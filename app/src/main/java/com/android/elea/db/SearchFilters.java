package com.android.elea.db;

import com.android.elea.beans.Country;
import com.android.elea.beans.Province;
import com.android.elea.beans.Town;

/**
 * Created by Borja on 07/06/2015.
 */
public class SearchFilters {

    private Country country;
    private Province province;
    private Town town;
    private String text;
    private boolean isOffer;

    private boolean isFavorite;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isOffer() {
        return isOffer;
    }

    public void setOffer(boolean isOffer) {
        this.isOffer = isOffer;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}

/*
SELECT j.id, j.user_id, j.title, j.description, j.province_id, j.town_id, j.is_offer, j.is_active, j.payment_mode, j.amount, j.date_created,  u.email, u.mail_notif_active, u.device_notif_active,u.device_id,  p.name,  t.name,  f.id FROM job j LEFT JOIN user u on j.user_id = u.id LEFT JOIN province p on j.province_id = p.id LEFT JOIN town t on j.town_id = t.id WHERE EXISTS (SELECT favorites f where f.user_id = 4) AND j.is_active = 1  AND j.country_id = 0 AND j.is_offer = 0;
 */

/*
SELECT j.id, j.user_id, j.title, j.description, j.province_id, j.town_id, j.is_offer, j.is_active, j.payment_mode, j.amount, j.date_created,  u.email, u.mail_notif_active, u.device_notif_active,u.device_id,  p.name,  t.name FROM job j LEFT JOIN user u o
n j.user_id = u.id LEFT JOIN province p on j.province_id = p.id LEFT JOIN town t on j.town_id = t.id WHERE EXISTS (SELECT * from favorites f where f.user_id = 4) AND j.is_active = 1  AND j.country_id = 0 AND j.is_offer = 0;

 */