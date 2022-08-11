package com.codepath.apps.restclienttemplate.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
class User(var name: String = "",var screenName: String = "",var publicImageURL: String = ""): Parcelable {



    //var verifiedStatus: Boolean = false


    companion object{
        fun fromJson(jsonObject: JSONObject): User{
            val user = User()
            user.name = jsonObject.getString("name")
            user.screenName = jsonObject.getString("screen_name")
            user.publicImageURL = jsonObject.getString("profile_image_url_https")
            //user.verifiedStatus = jsonObject.getBoolean("verified")

            return  user
        }
    }
}