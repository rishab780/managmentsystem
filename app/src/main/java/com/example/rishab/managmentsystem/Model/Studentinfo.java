package com.example.rishab.managmentsystem.Model;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by Rishab on 05-04-2017.
 */

public class Studentinfo implements Parcelable {
    private String mname;
    private String mschool;
    private String mrollno;
    private String mEmail;
    public Studentinfo(String name, String school, String rollno, String Email) {
        this.mname = name;
        this.mschool = school;
        this.mrollno = rollno;
        this.mEmail = Email;

    }

    protected Studentinfo(Parcel in) {
        mname = in.readString();
        mschool = in.readString();
        mrollno = in.readString();
        mEmail = in.readString();
    }

    public static final Creator<Studentinfo> CREATOR = new Creator<Studentinfo>() {
        @Override
        public Studentinfo createFromParcel(Parcel in) {
            return new Studentinfo(in);
        }

        @Override
        public Studentinfo[] newArray(int size) {
            return new Studentinfo[size];
        }
    };

    public String getName() {
        return mname;
    }

    public String getSchool() {
        return mschool;
    }

    public String getRollno() {
        return mrollno;
    }

    public String getEmail() {
        return mEmail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mname);
        dest.writeString(mschool);
        dest.writeString(mrollno);
        dest.writeString(mEmail);
    }
}
