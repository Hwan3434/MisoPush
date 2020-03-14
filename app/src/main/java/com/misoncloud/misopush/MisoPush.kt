package com.misoncloud.misopush

import android.util.Log

class MisoPush {


    companion object Client {

        fun RegisterMisoKey(misoAppKey: String, misoKey: String, deviceToken: String){

            Log.d("MisoPush", "miso push misoAppKey : " + misoAppKey)

            Log.d("MisoPush", "miso push misoKey : " + misoKey)

            Log.d("MisoPush", "miso push deviceToken : " + deviceToken)

        }

        fun RemoveMisoKey(misoAppKey: String, misoKey: String){

            Log.d("MisoPush", "miso push misoAppKey : " + misoAppKey)

            Log.d("MisoPush", "miso push misoKey : " + misoKey)

        }

    }


}