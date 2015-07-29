package com.android.elea.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class Country implements Parcelable {
	private static final long serialVersionUID = 1L;

	private int id;
	private boolean available;
	private String name;

	public Country() {
	}

    public Country(Parcel in) {
        this.id = in.readInt();
        this.available = in.readByte() != 0;
        this.name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeByte((byte) (available ? 1 : 0));
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public static final Parcelable.Creator<Country> CREATOR
            = new Parcelable.Creator<Country>() {

        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        public Country[] newArray(int size) {
            return new Country[size];
        }
    };


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}