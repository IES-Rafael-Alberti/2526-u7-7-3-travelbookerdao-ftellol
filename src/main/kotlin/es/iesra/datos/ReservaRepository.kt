package es.iesra.datos

import es.iesra.dominio.*

class ReservaRepository(
    private val hotelDao: IReservaDao<ReservaHotel>,
    private val vueloDao: IReservaDao<ReservaVuelo>
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
        return when (reserva) {
            is ReservaHotel -> hotelDao.actualizar(reserva)
            is ReservaVuelo -> vueloDao.actualizar(reserva)
            else -> false
        }
    }

    override fun eliminar(id: Int): Boolean {
        val eliminadoHotel = hotelDao.eliminar(id)
        val eliminadoVuelo = vueloDao.eliminar(id)
        return eliminadoHotel || eliminadoVuelo
    }
}