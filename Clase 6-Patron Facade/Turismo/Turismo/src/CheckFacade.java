public class CheckFacade {

	// guarda en las variables una instancia de cada otra
	private AvionAPI avionAPI;
	private HotelAPI hotelAPI;	

	// constructor que crea las instancias
	public CheckFacade() {
		avionAPI = new AvionAPI();
		hotelAPI = new HotelAPI();
	}

	//  simplifica las busquedas de vuelo y hotel
	public void buscar(String fechaIda, String fechaVuelta, String origen, String destino) {
		avionAPI.buscarVuelos(fechaIda, fechaVuelta, origen, destino);
		hotelAPI.buscarHoteles(fechaIda, fechaVuelta, destino);
	}		

}
