package es.iesra.datos

import es.iesra.dominio.Reserva

interface IReservaDao<T : Reserva> {
    fun agregar(reserva: T): Boolean
    fun obtenerTodas(): List<T>
    fun obtenerPorId(id: Int): T?
    fun actualizar(reserva: T): Boolean
    fun eliminar(id: Int): Boolean
}