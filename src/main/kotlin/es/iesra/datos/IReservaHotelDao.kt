package es.iesra.datos

import es.iesra.dominio.Reserva
import es.iesra.dominio.ReservaHotel


interface IReservaHotelDao {
    fun agregar(reserva: Reserva): Boolean
    fun obtenerTodas(): List<Reserva>
    fun obtenerPorId(id: Int): Reserva?
    fun actualizar(reserva: Reserva): Boolean
    fun eliminar(id: Int): Boolean
}