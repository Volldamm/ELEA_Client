package com.android.elea.beans;

import android.os.Parcel;
import android.os.Parcelable;


public class Province implements Parcelable {

	private int id;
	private String name;
	private Country country;

	public Province() {
	}

    public Province(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.country = in.readParcelable(Country.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeParcelable(country,flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Province> CREATOR
            = new Parcelable.Creator<Province>() {

        public Province createFromParcel(Parcel in) {
            return new Province(in);
        }

        public Province[] newArray(int size) {
            return new Province[size];
        }
    };

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


    @Override
    public String toString() {
        return this.name;
    }
}