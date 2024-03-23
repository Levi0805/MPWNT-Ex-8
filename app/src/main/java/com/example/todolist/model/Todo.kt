package com.example.todolist.model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo (
    var userID: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

const val BASE_URL = "https://jsonplaceholder.typicode.com/todos"

interface TodosApi {
    @GET("todos")
    suspend fun  getTodos(): List<Todo>
    companion object {
        var todosSevice: TodosApi? = null
        fun getInstance(): TodosApi {
            if (todosSevice === null){
                todosSevice = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }
            return todosSevice!!
        }
    }
}