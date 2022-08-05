package com.codepath.apps.restclienttemplate.models

import org.json.JSONObject

class User {
    var name: String = ""
    var screenName: String = ""
    var publicImageURL: String = ""
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