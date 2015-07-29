package com.android.elea.beans;

import android.os.Parcel;
import android.os.Parcelable;


public class User implements Parcelable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String deviceId;

	private boolean deviceNotifActive;

	private String email;

	private String key;

	private boolean mailNotifActive;

	public User() {
	}


    public User(Parcel in) {
        this.id = in.readInt();
        this.deviceId = in.readString();
        this.deviceNotifActive = in.readByte() != 0;
        this.email = in.readString();
        this.key = in.readString();
        this.mailNotifActive = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(deviceId);
        dest.writeByte((byte) (deviceNotifActive ? 1 : 0));
        dest.writeString(email);
        dest.writeString(key);
        dest.writeByte((byte) (mailNotifActive ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {

        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public boolean getDeviceNotifActive() {
		return this.deviceNotifActive;
	}

	public void setDeviceNotifActive(boolean deviceNotifActive) {
		this.deviceNotifActive = deviceNotifActive;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean getMailNotifActive() {
		return this.mailNotifActive;
	}

	public void setMailNotifActive(boolean mailNotifActive) {
		this.mailNotifActive = mailNotifActive;
	}


}