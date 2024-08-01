public class App {

	public static void main(String[] args) {

		// crea el cliente del facade
		CheckFacade cliente1 = new CheckFacade();
		// pide una busqueda
		cliente1.buscar("02/07/2018", "08/07/2018", "Lima", "Cancún");


		// crea el cliente del facade
		CheckFacade cliente2 = new CheckFacade();
		// pide una busqueda
		cliente2.buscar("02/07/2018", "08/07/2018", "Lima", "Quito");
	}

}
