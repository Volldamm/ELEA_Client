package com.android.elea.beans;

import android.os.Parcel;
import android.os.Parcelable;


public class Town implements Parcelable {

	private int id;
	private int codMunicipio;
	private int dc;
	private String name;
	private Province province;

	public Town() {
	}

    public Town(Parcel in) {
        this.id = in.readInt();
        this.codMunicipio = in.readInt();
        this.dc = in.readInt();
        this.name = in.readString();
        this.province = in.readParcelable(Province.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(codMunicipio);
        dest.writeInt(dc);
        dest.writeString(name);
        dest.writeParcelable(province,flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Town> CREATOR
            = new Parcelable.Creator<Town>() {

        public Town createFromParcel(Parcel in) {
            return new Town(in);
        }

        public Town[] newArray(int size) {
            return new Town[size];
        }
    };


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodMunicipio() {
		return this.codMunicipio;
	}

	public void setCodMunicipio(int codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public int getDc() {
		return this.dc;
	}

	public void setDc(int dc) {
		this.dc = dc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}


    @Override
    public String toString() {
        return this.name;
    }
}