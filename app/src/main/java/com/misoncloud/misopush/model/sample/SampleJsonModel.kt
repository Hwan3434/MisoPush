package com.misoncloud.misopush.model.sample

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList


class SampleJsonModel {

    @SerializedName("tempStr")
    private var mString: String? = null
//
    @SerializedName("tempInt")
    private var mInt: Int? = null
//
    @SerializedName("tempDouble")
    private var mDouble: Double? = null

    @SerializedName("tempBool")
    private var mBool: Boolean? = null

    @SerializedName("tempDate")
    private var mDate: String? = null

    @SerializedName("tempList")
    private var mList: ArrayList<String>? = null

    @SerializedName("tempObject")
    private var mObject: SampleJsonModelItem? = null

    constructor(){}
    constructor(
        mString: String,
        mInt: Int,
        mDouble: Double,
        mBool: Boolean,
        mDate: String,
        mList: ArrayList<String>,
        mObject: SampleJsonModelItem
    ){
        this.mString = mString
        this.mInt = mInt
        this.mDouble = mDouble
        this.mBool = mBool
        this.mDate = mDate
        this.mList = mList
        this.mObject = mObject
    }

    override fun toString(): String {

        return "String : " + mString + " / " +
                "mInt : " + mInt + " / " +
                "mDouble : " + mDouble + " / " +
                "mBool : " + mBool + " / " +
                "mDate : " + mDate + " / " +
                "mList : " + mList.toString() + " / " +
                "mObject : " + mObject.toString()
    }

    class SampleJsonModelItem(id: Int, name: String) {

        @SerializedName("id")
        @Expose
        private var id: Int? = id

        @SerializedName("name")
        @Expose
        private var name: String? = name


        override fun toString(): String {

            return "id : " + id + " / " +
                    "name : " + name
        }

    }

}