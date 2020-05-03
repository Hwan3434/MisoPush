package com.misoncloud.misopush.util.date

class MisoDateUtil private constructor() {


    companion object Client {

        @Volatile
        private var instance: MisoDateUtil? = null

        @JvmStatic
        fun getInstance(): MisoDateUtil =
            instance ?: synchronized(this) {
                instance ?: MisoDateUtil().also {
                    instance = it

                    // http connection 기본 세팅 작업

                }
            }
    }

    // format 지정하기


    // Date 클래스를 String으로
    fun StringByDate(): String {
        return ""
    }


    // String 클래스를 Date
    fun DateByString(): String {
        return ""
    }

}