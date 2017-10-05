package com.example.alejandro.miscontactos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alejandro on 08/09/2017.
 */

public class Contacto implements Parcelable {
    //private int mData;
    private String usuario;
    private String email;
    private String twitter;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Contacto(String usuario, String email, String twitter) {
        this.usuario=usuario;
        this.email=email;
        this.twitter=twitter;
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        //out.writeInt(mData);
        out.writeString(usuario);
        out.writeString(email);
        out.writeString(twitter);
    }

    public static final Parcelable.Creator<Contacto> CREATOR
            = new Parcelable.Creator<Contacto>() {
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    public Contacto(Parcel in) {
        //mData = in.readInt();
        this.usuario = in.readString();
        this.email = in.readString();
        this.twitter = in.readString();
    }
}
