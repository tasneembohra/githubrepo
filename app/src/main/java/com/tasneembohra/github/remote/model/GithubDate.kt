package com.tasneembohra.github.remote.model

import com.google.gson.annotations.JsonAdapter
import com.tasneembohra.github.remote.util.GithubDateDeserializer

@JsonAdapter(GithubDateDeserializer::class)
class GithubDate(val date: String)