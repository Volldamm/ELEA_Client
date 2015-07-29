package com.android.elea.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Borja on 13/07/2015.
 */
public class Message implements Parcelable {

    private Integer id;
    private User sender;
    private User receiver;
    private Job job;
    private String messageText;
    private String subject;
    private Boolean isRead;
    private Date dateCreated;
    private Date dateModified;
    private Date dateDeleted;

    public Message(){}

    @Override
    public int describeContents() {
        return 0;
    }

    Message(Parcel in) {
        this.id = in.readInt();
        this.sender = in.readParcelable(User.class.getClassLoader());
        this.receiver = in.readParcelable(User.class.getClassLoader());
        this.job = in.readParcelable(Job.class.getClassLoader());
        this.messageText = in.readString();
        this.subject = in.readString();
        this.isRead = in.readByte() != 0;
        this.dateCreated = (java.util.Date)in.readSerializable();
        this.dateModified = (java.util.Date)in.readSerializable();
        this.dateDeleted = (java.util.Date)in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeParcelable(sender, flags);
        dest.writeParcelable(receiver,flags);
        dest.writeParcelable(job, flags);
        dest.writeString(messageText);
        dest.writeString(subject);
        dest.writeByte((byte) (isRead ? 1 : 0));
        dest.writeSerializable(dateCreated);
        dest.writeSerializable(dateModified);
        dest.writeSerializable(dateDeleted);
    }

    public static final Parcelable.Creator<Message> CREATOR
            = new Parcelable.Creator<Message>() {

        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
