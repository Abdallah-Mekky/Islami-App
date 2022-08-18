package com.task1.islami.model

import com.google.gson.annotations.SerializedName

data class AudiosResponse(

	@field:SerializedName("Radios")
	val radios: List<RadiosItem?>? = null
)

data class RadiosItem(

	@field:SerializedName("URL")
	val uRL: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)
