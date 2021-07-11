package pdm.moodmanager.helper

import com.example.moodmanager.states.User
import pdm.moodmanager.model.Register
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun helperSave(user: User): HashMap<String, Any> {
    val parser: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
    val body = HashMap<String, Any>()
    body.put("username",user.username)
    body.put("password",user.password)
    body.put("email",user.email)
    body.put("geralScore",user.geralScore)
    body.put("preference",user.preference as Any)
    body.put("interests",user.interests)
    body.put("registers", user.registers.map {
        register: Register ->
        var newRegister = register
        var local = LocalDateTime.parse(newRegister.date, parser).toString().replace(" ","T")
        newRegister.date = local
        newRegister
    })
    return body
}