package pdm.moodmanager.http

import pdm.moodmanager.http.user.model.UserModel

interface APIListener {
    fun onSuccess(model: UserModel)
    fun onFailure(str: String)
}