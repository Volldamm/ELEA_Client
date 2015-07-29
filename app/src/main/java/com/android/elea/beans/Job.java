package com.android.elea.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

/**
 * Created by Borja on 28/04/2015.
 */
public class Job implements Parcelable {


    private String subtitle;
    private String sinceWhen;
    private Boolean isFavourite = false;
    private String words;
    private int id;
    private int amount;
    private String description;
    private boolean isActive;
    private boolean isOffer;
    private String paymentMode;
    private String title;
    private Country country;
    private Province province;
    private Town town;
    private User user;
    private Date dateCreated;
    private Date dateModified;
    private Date dateDeleted;




    public Job() {

    }

    Job(Parcel in) {
        this.subtitle = in.readString();
        this.sinceWhen = in.readString();
        this.isFavourite = in.readByte() != 0;
        this.words = in.readString();
        this.id = in.readInt();
        this.amount = in.readInt();
        this.description = in.readString();
        this.isActive = in.readByte() != 0;
        this.isOffer = in.readByte() != 0;
        this.paymentMode = in.readString();
        this.title = in.readString();
        this.country = in.readParcelable(Country.class.getClassLoader());
        this.province = in.readParcelable(Province.class.getClassLoader());
        this.town = in.readParcelable(Town.class.getClassLoader());
        this.user = in.readParcelable(User.class.getClassLoader());
        this.dateCreated = (java.util.Date)in.readSerializable();
        this.dateModified = (java.util.Date)in.readSerializable();
        this.dateDeleted = (java.util.Date)in.readSerializable();


    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(subtitle);
        dest.writeString(sinceWhen);
        dest.writeByte((byte) (isFavourite ? 1 : 0));
        dest.writeString(words);
        dest.writeInt(id);
        dest.writeInt(amount);
        dest.writeString(description);
        dest.writeByte((byte) (isActive ? 1 : 0));
        dest.writeByte((byte) (isOffer ? 1 : 0));
        dest.writeString(paymentMode);
        dest.writeString(title);
        dest.writeParcelable(country, flags);
        dest.writeParcelable(province,flags);
        dest.writeParcelable(town,flags);
        dest.writeParcelable(user,flags);
        dest.writeSerializable(dateCreated);
        dest.writeSerializable(dateModified);
        dest.writeSerializable(dateDeleted);
    }

    public static final Parcelable.Creator<Job> CREATOR
            = new Parcelable.Creator<Job>() {

        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        public Job[] newArray(int size) {
            return new Job[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSinceWhen() {
        return sinceWhen;
    }

    public void setSinceWhen(String sinceWhen) {
        this.sinceWhen = sinceWhen;
    }

    public Boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isOffer() {
        return isOffer;
    }

    public void setOffer(boolean isOffer) {
        this.isOffer = isOffer;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }
}