package com.android.elea.beans;

import android.os.Parcel;
import android.os.Parcelable;


public class Favorite implements Parcelable {

	private int id;
	private Job job;
	private User user;

	public Favorite() {
	}

    public Favorite(Parcel in) {
        this.id = in.readInt();
        this.job = in.readParcelable(Job.class.getClassLoader());
        this.user = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeParcelable(job,flags);
        dest.writeParcelable(user,flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Favorite> CREATOR
            = new Parcelable.Creator<Favorite>() {

        public Favorite createFromParcel(Parcel in) {
            return new Favorite(in);
        }

        public Favorite[] newArray(int size) {
            return new Favorite[size];
        }
    };

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}