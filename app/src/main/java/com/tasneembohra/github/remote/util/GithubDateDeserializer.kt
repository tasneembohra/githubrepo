package com.tasneembohra.github.remote.util

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.tasneembohra.github.remote.model.GithubDate
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
const val APP_DATE_FORMAT = "MMM dd, yyyy hh:mm:ss a"

class GithubDateDeserializer : JsonDeserializer<GithubDate> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): GithubDate? {
        try {
            val dateStr = json?.asString ?: return null
            val date = SimpleDateFormat(
                SERVER_DATE_FORMAT,
                Locale.getDefault()
            ).parse(dateStr)
            date ?: return null
            val dateParser = SimpleDateFormat(APP_DATE_FORMAT, Locale.getDefault())
            return GithubDate(dateParser.format(date))
        } catch (e: Exception) {
            return null
        }
    }
}