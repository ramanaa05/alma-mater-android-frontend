package com.journalia_nitt.journalia_admin_cms.student.responses

import com.journalia_nitt.journalia_admin_cms.administration.response.AdminPost
import com.journalia_nitt.journalia_admin_cms.administration.response.Date

data class DeadlineResponse(
    val deadlines: List<DeadlineContainer>, // Updated to reflect the array
    val status: String // To match the "status" field
)

data class DeadlineContainer(
    val details: List<Deadline>, // Each object contains a "details" list
    val id: String // Each object contains an "id"
)

data class Deadline(
    val author: String,
    val deadline: String,
    val description: String?,
    val file_url: String?,
    val link1: String?,
    val link2: String?,
    val mode: Int,
    val title: String?
)

data class UserUploadClass(
    val token :String="",
    val title:String="",
    val description:String="",
    val comments: Boolean=false,
    val anonymity: Boolean=false,
    val tag:String="",
    val fileUrl:String?=null,
    val userName:String=""
)

data class userUploadResponse(
    val message:String="",
    val file_url:String="",
    val data:String=""
)

data class UserFetch(
    val message: String = "",
    val data: Data = Data()
)
data class UserFetch1(
    val message: String = "",
    val data: List<UserFetchClass> = emptyList()
)

data class UserFetchClass(
    val token :String="",
    val title:String="",
    val description:String="",
    val comments: Boolean=false,
    val anonymity: Boolean=false,
    val tag:String="",
    val fileUrl:String?=null,
    val userName:String="",
    val id:String="",
    val upvotes:Int=0,
    val commentsPosted:List<userComments> =emptyList()
)
data class Data(
    val details: List<UserFetchClass> = emptyList()
)

data class UploadResponse(
    val message: String,
    val url: String
)
data class BookMarkFetch(
    val message: String = "",
    val data: bookMarkClass = bookMarkClass()
)

data class bookMarkClass(
    val details: List<AdminPost> = emptyList()
)
data class studentBookMark(
    var postId: String = "",
    var author: String = "",
    var title: String = "",
    var description: String = "",
    var deadline: Date = Date(0, "",0, 0),
    var fileUrl: String? = "",
    var type: String = "",
    var link1: String = "",
    var link2: String = "",
    var applicability: String = "",
    var time: String = "",
    var date: Date = Date(0, "",0, 0),
    var bookMarkedBy: List<String> = emptyList()
)
//ALUMNI FETCH
data class AlumniUpload(
    val username: String,
    val title: String,
    val description: String,
    val id: String = "",
    val file_url: String, // camelCase convention
    val link1: String = "",
    val link2: String = "",
    val comments: MutableList<Comment> = mutableListOf(),
    var upvotes: Int = 0,
    val upvoters: MutableList<String> = mutableListOf(),
    val upload_time: String = ""
)

data class FetchUploadsResponse(val message: String, val uploads: List<UploadOutput>)
data class UploadOutput(
    val uploads: List<AlumniUpload>
)
data class CommentResponse(val message: String, val comment: Comment)
data class Upvote(val username: String, val id: String)
data class GeneralResponse(val message: String)

data class userComments(
    val text: String="",
    val commentedBy: String=""
)
