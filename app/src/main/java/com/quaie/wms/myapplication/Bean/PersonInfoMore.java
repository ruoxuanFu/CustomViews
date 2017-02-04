package com.quaie.wms.myapplication.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yue on 2017/2/4.
 * 　　　　　　　  ┏┓　 ┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　     ┃
 * 　　　　　　　┃　　　━　    ┃ ++ + + +
 * 　　　　　　 ████━████     ┃++  ++
 * 　　　　　　　┃　　　　　　 ┃ +
 * 　　　　　　　┃　　　┻　　　┃  +  +
 * 　　　　　　　┃　　　　　　 ┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * 使用Parcelable进行序列化
 */

public class PersonInfoMore implements Parcelable {

    private String likeSome;
    private String constellation;
    private String lolAddress;

    public PersonInfoMore() {
    }

    protected PersonInfoMore(Parcel in) {
        likeSome = in.readString();
        constellation = in.readString();
        lolAddress = in.readString();
    }

    public static final Creator<PersonInfoMore> CREATOR = new Creator<PersonInfoMore>() {
        @Override
        public PersonInfoMore createFromParcel(Parcel in) {

/*            PersonInfoMore pPersonInfoMore = new PersonInfoMore();
            pPersonInfoMore.likeSome = in.readString();
            pPersonInfoMore.constellation = in.readString();
            pPersonInfoMore.lolAddress = in.readString();

            return pPersonInfoMore;*/
            return new PersonInfoMore(in);

        }

        @Override
        public PersonInfoMore[] newArray(int size) {
            return new PersonInfoMore[size];
        }
    };

    public String getLikeSome() {
        return likeSome;
    }

    public void setLikeSome(String likeSome) {
        this.likeSome = likeSome;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getLolAddress() {
        return lolAddress;
    }

    public void setLolAddress(String lolAddress) {
        this.lolAddress = lolAddress;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(likeSome);
        dest.writeString(constellation);
        dest.writeString(lolAddress);
    }
}
