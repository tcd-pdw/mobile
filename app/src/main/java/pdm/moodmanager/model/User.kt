package com.example.moodmanager.states

import android.os.Parcelable
import pdm.moodmanager.model.Interest
import pdm.moodmanager.model.Preference
import pdm.moodmanager.model.Register
import java.io.Serializable

class User(
        var id: Int,
        var username:String,
        var email:String,
        var password:String,
        var geralScore:Int,
        var state:State = Regular(geralScore)
){


    val preference: Preference = Preference()
    val registers: MutableList<Register> = arrayListOf<Register>()
    val interests: MutableList<Interest> = arrayListOf<Interest>()

//    init{
//       var state: State = Regular(geralScore)
//    }

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
        return "User: ${username},Email: ${email} Password: ${password}, Score: ${state.score}, Preference: ${preference},Registers: ${registers}, Interests: ${interests}"
    }
}