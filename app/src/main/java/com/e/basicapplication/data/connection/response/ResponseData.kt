package com.e.basicapplication.data.connection.response

import com.google.gson.annotations.SerializedName


sealed class ResponseData {

    data class LoginResponse(
        @SerializedName("accessToken")
        val accessToken: String? = null,
        @SerializedName("basicInfo")
        val basicInfo: BasicInfo? = null,
        @SerializedName("expiresIn")
        val expiresIn: Int? = null,
        @SerializedName("isProfileCompleted")
        val isProfileCompleted: Boolean = false,
        @SerializedName("isRequiredChangePassword")
        val isRequiredChangePassword: Boolean = false,
        @SerializedName("profileNotCompletedReason")
        val profileNotCompletedReason: String? = null,
        @SerializedName("refreshToken")
        val refreshToken: String? = null,
        @SerializedName("tokenType")
        val tokenType: String? = null
    )

    data class BasicInfo(
        @SerializedName("accountId")
        val accountId: Int? = null,
        @SerializedName("avartarUrl")
        val avartarUrl: String? = null,
        @SerializedName("city")
        val city: String? = null,
        @SerializedName("country")
        val country: String? = null,
        @SerializedName("firstname")
        val firstname: String? = null,
        @SerializedName("isExpired")
        val isExpired: Boolean = false,
        @SerializedName("isFreemium")
        val isFreemium: Boolean = false,
        @SerializedName("lastname")
        val lastname: String? = null,
        @SerializedName("profileId")
        val profileId: Int? = null,
        @SerializedName("role")
        val role: String? = null,
        @SerializedName("schoolName")
        val schoolName: String? = null,
        @SerializedName("state")
        val state: String? = null,
        @SerializedName("subScriptionId")
        val subScriptionId: String? = null
    )


}