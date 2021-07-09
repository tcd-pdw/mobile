package com.example.moodmanager.states

import java.io.Serializable

class User(
    var username:String,
    var password:String,
    var state: State = Regular(1)
    ){

    fun ToPositive(){
         state = state.ToPositive()
     }
    fun ToNegative(){
        state = state.ToNegative()
    }
    fun ToRegular(){
        state = state.ToRegular()
    }

    override fun toString(): String {
        return "User: ${username}, Password: ${password}, Score: ${state.score}"
    }
}