package es.iesra.datos

import es.iesra.dominio.Reserva
import es.iesra.dominio.ReservaVuelo
import es.iesra.dominio.ReservaHotel

class ReservaRepository(
    private val hotelDao: IReservaHotelDao,
    private val vueloDao: IReservaVueloDao
) : IReservaRepository {

    override fun agregar(reserva: Reserva): Boolean {
        return when (reserva) {
            is ReservaHotel -> hotelDao.agregar(reserva)
            is ReservaVuelo -> vueloDao.agregar(reserva)
            else -> false
        }
    }

    override fun obtenerTodas(): List<Reserva> {
        return hotelDao.obtenerTodas() + vueloDao.obtenerTodas()
    }

    override fun obtenerPorId(id: Int): Reserva? {
        return obtenerTodas().find { it.id == id }
    }

    override fun actualizar(reserva: Reserva): Boolean {
        // Simplificación (recrear todo)
        eliminar(reserva.id)
        agregar(reserva)
        return true
    }

    override fun eliminar(id: Int): Boolean {
        val eliminadoHotel = hotelDao.eliminar(id)
        val eliminadoVuelo = vueloDao.eliminar(id)

        // Devuelve true si se eliminó en alguno
        return eliminadoHotel || eliminadoVuelo
    }
}