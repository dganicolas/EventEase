package com.example.eventease.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModel() {
    private var _usuario = MutableLiveData("admin")
    private var _contrasena = MutableLiveData("contra")

    private val _textoIdioma = MutableLiveData("Español(España)")
    val textoIdioma: LiveData<String> = _textoIdioma

    private val _textousuario = MutableLiveData(_usuario.value.toString())
    val textoUsuario: LiveData<String> = _textousuario

    private val _textoContrasena = MutableLiveData(_contrasena.value.toString())
    val textoContrasena: LiveData<String> = _textoContrasena

    private val _ventanaModal = MutableLiveData(false)
    val ventanaModal: LiveData<Boolean> = _ventanaModal

    private val _tituloVentanaModal = MutableLiveData("")
    val tituloVentanaModal: LiveData<String> = _tituloVentanaModal

    private val _mensajeVentanaModal = MutableLiveData("")
    val mensajeVentanaModal: LiveData<String> = _mensajeVentanaModal

    private val _mostrarMenu = MutableLiveData(false)
    val mostrarMenu: LiveData<Boolean> = _mostrarMenu

    fun cambiarCorreo(mensaje: String) {
        _textousuario.value = mensaje
    }

    fun cambiarContrasena(mensaje: String) {
        _textoContrasena.value = mensaje
    }

    fun checkLogin():Boolean {
        if (loginEnabledcheck(_textousuario.value!!, _textoContrasena.value!!)) {
            if(_textousuario.value == _usuario.value && _textoContrasena.value == _contrasena.value){
                _mostrarMenu.value = true
                return true
            }else{
                _ventanaModal.value = true
                _tituloVentanaModal.value = "ERROR"
                _mensajeVentanaModal.value = "Credenciales incorrecta"
                resetFields()
                return false
            }
        }else{
            _ventanaModal.value = true
            _tituloVentanaModal.value = "ERROR"
            _mensajeVentanaModal.value = "el correo debe de seer valido y contraseña de mas de 8 caracteres"
            resetFields()
            return false
        }
    }

    private fun resetFields(){
        _textousuario.value= ""
        _textoContrasena.value = ""
    }
    fun cerrarVentana(){
        _ventanaModal.value = false
    }

    fun mostrarEndpoint(titulo:String,mensaje:String){
        _ventanaModal.value = true
        _tituloVentanaModal.value = "mostrando endpoint:$titulo"
        _mensajeVentanaModal.value  = mensaje
    }


    fun comprobarCorreo(correo: String) = correo.isNotBlank()

    fun comprobarContrasena(contrasena:String) = contrasena.length > 5

    private fun loginEnabledcheck(correo: String, pass: String) =
        correo.isNotBlank() && pass.length > 5

    fun pantallaLogin() {
        _mostrarMenu.value = false
    }
}
