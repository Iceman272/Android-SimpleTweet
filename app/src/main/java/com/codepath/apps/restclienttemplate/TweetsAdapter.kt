package com.codepath.apps.restclienttemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.apps.restclienttemplate.models.Tweet
import java.lang.reflect.Type
import java.text.FieldPosition


class TweetsAdapter(val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.item_tweet, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val tweet: Tweet = tweets.get(position)

        holder.tvUsername.text = tweet.user?.name
        holder.tvTweetBody.text = tweet.body


        holder.tvPostTime.text = getFormattedTimestamp(tweet.createdAt)

        //holder.ivVerified.isVisible = tweet.user?.verifiedStatus!!


        Glide.with(holder.itemView).load(tweet.user?.publicImageURL).into(holder.ivProfileImage)
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    fun clear() {
        tweets.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(tweetList: List<Tweet>) {
        tweets.addAll(tweetList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivProfileImage = itemView.findViewById<ImageView>(R.id.ivProfileImage)
        val tvUsername = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvTweetBody = itemView.findViewById<TextView>(R.id.tvTweetBody)
        val tvPostTime = itemView.findViewById<TextView>(R.id.tvPostTime)
        //val ivVerified = itemView.findViewById<TextView>(R.id.ivVerified)
    }

    fun getFormattedTimestamp(createdAt: String): String? {
        return TimeFormatter.getTimeDifference(createdAt)
    }

}