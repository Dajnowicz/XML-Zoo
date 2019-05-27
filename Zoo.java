
//package my.examples;

import java.io.FileOutputStream;

// rejestr do tworzenia implementacji DOM
import org.w3c.dom.bootstrap.DOMImplementationRegistry;

// Implementacja DOM Level 3 Load & Save
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSParser; // Do serializacji (zapisywania) dokumentow
import org.w3c.dom.ls.LSSerializer;
import org.w3c.dom.ls.LSOutput;

// Konfigurator i obsluga bledow
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;

// Do pracy z dokumentem
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Zoo {
	public static Document document;

	public static void main(String[] args) {
		int zmienna = 0;
		if (args.length == 0) {
			printUsage();
			System.exit(1);
		}

		try {
			/*
			 * ustawienie systemowej wlasnosci (moze byc dokonane w innym
			 * miejscu, pliku konfiguracyjnym w systemie itp.) konkretna
			 * implementacja DOM
			 */
			System.setProperty(DOMImplementationRegistry.PROPERTY,
					"org.apache.xerces.dom.DOMXSImplementationSourceImpl");
			DOMImplementationRegistry registry = DOMImplementationRegistry
					.newInstance();

			// pozyskanie implementacji Load & Save DOM Level 3 z rejestru
			DOMImplementationLS impl = (DOMImplementationLS) registry
					.getDOMImplementation("LS");

			// stworzenie DOMBuilder
			LSParser builder = impl.createLSParser(
					DOMImplementationLS.MODE_SYNCHRONOUS, null);

			// pozyskanie konfiguratora - koniecznie zajrzec do dokumentacji co
			// mozna poustawiac
			DOMConfiguration config = builder.getDomConfig();

			// stworzenie DOMErrorHandler i zarejestrowanie w konfiguratorze
			DOMErrorHandler errorHandler = getErrorHandler();
			config.setParameter("error-handler", errorHandler);

			// set validation feature
			config.setParameter("validate", Boolean.TRUE);

			// set schema language
			config.setParameter("schema-type",
					"http://www.w3.org/2001/XMLSchema");

			// set schema location
			config.setParameter("schema-location",  args[1]);

			System.out.println("Parsowanie " + args[0] + "...");
			// sparsowanie dokumentu i pozyskanie "document" do dalszej pracy
			document = builder.parseURI(args[0]);

			// praca z dokumentem, modyfikacja zawartosci etc... np.
			// tutaj dodanie nowego pracownika poprzez skopiowanie innego
			///////////////////////////////////////TUTAJ
				
				Element elKontynent = document.createElement("Ksiezyc");
				Element elZwierze = document.createElement("zwierze");
				
				Element elImie = document.createElement("imie");
				Element elWaga = document.createElement("waga");
				Element elWiek = document.createElement("wiek");
				Element elKolor = document.createElement("kolor");
				Element elOkres_ciazy = document.createElement("okres_ciazy");
				Element elGromada = document.createElement("gromada");
				Element elChoroby = document.createElement("choroby");

				elZwierze.setAttribute("rasa","Stellaris");
				elZwierze.setAttribute("gatunek","Monius");
				elZwierze.setAttribute("plec" , "Kobieta");
				elImie.setTextContent("Ksiezycowy Szczur");
				elWaga.setTextContent("100");
				elWaga.setAttribute("funty","230");
				elWiek.setTextContent("99");
				elWiek.setAttribute("dlugosc_zycia", "17");
				elKolor.setTextContent("Czerwony");
				elKolor.setAttribute("znaki_szczegolne","Pancerz");
				elOkres_ciazy.setTextContent("156");
				elGromada.setTextContent("&S;");
				elChoroby.setTextContent("");

				elZwierze.appendChild(elImie);
				elZwierze.appendChild(elWaga);
				elZwierze.appendChild(elWiek);
				elZwierze.appendChild(elKolor);
				elZwierze.appendChild(elOkres_ciazy);
				elZwierze.appendChild(elGromada);
				elZwierze.appendChild(elChoroby);

				elKontynent.appendChild(elZwierze);
				
				document.getFirstChild().insertBefore(elKontynent, null);
			
				//STATYSTYKA

				System.out.println("Root element: " + document.getDocumentElement().getNodeName());


       				NodeList nList = document.getElementsByTagName("zwierze");

       				for (int i = 0; i < nList.getLength(); i++) {

            			Node nNode = nList.item(i);


            			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

               			 Element elem = (Element) nNode;
				Node kont = elem.getParentNode();
				String konty = kont.getNodeName();
                		String uid = elem.getAttribute("rasa");
				String u2id = elem.getAttribute("gatunek");
				String pl = elem.getAttribute("plec");
                		Node node1 = elem.getElementsByTagName("imie").item(0);
                		String fname = node1.getTextContent();

                		Node node2 = elem.getElementsByTagName("waga").item(0);
                		String lname = node2.getTextContent();
				Integer result = Integer.valueOf(lname);
				if (result > 100) {
				zmienna +=1;
				}
                		Node node3 = elem.getElementsByTagName("wiek").item(0);
                		String occup = node3.getTextContent();

				System.out.printf("Plec: %s%n", pl);
                		System.out.printf("Kontynent : %s%n", konty);
				System.out.printf("Rasa i gatunek: %s %s%n", uid, u2id);
                		System.out.printf("Imie: %s%n", fname);
                		System.out.printf("Waga: %s kg%n", lname);
                		System.out.printf("Wiek: %s lat%n%n", occup);
            			}
        			}
				System.out.printf("Jest %s zwierzat ktore waza wiecej niz 100 kg%n", zmienna);

			///////////////////////////////////////////////////////KONIEC

			// pozyskanie serializatora
			LSSerializer domWriter = impl.createLSSerializer();
			// pobranie konfiguratora dla serializatora
			config = domWriter.getDomConfig();
			config.setParameter("xml-declaration", Boolean.TRUE);

			// pozyskanie i konfiguracja Wyjscia
			LSOutput dOut = impl.createLSOutput();
			dOut.setEncoding("latin2");
			dOut.setByteStream(new FileOutputStream("new_" + args[0]));

			System.out.println("Serializing document... ");
			domWriter.write(document, dOut);

			// Wyjscie na ekran
			// dOut.setByteStream(System.out);
			// domWriter.writeNode(System.out, document);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void printUsage() {

		System.err.println("usage: java Dom3Demo uri");
		System.err.println();
		System.err
				.println("NOTE: You can only validate DOM tree against XML Schemas.");

	}

	// obsluga bledow za pomoca anonimowej klasy wewnetrznej implementujacej
	// DOMErrorHandler
	// por. SAX ErrorHandler
	public static DOMErrorHandler getErrorHandler() {
		return new DOMErrorHandler() {
			public boolean handleError(DOMError error) {
				short severity = error.getSeverity();
				if (severity == error.SEVERITY_ERROR) {
					System.out.println("[dom3-error]: " + error.getMessage());
				}
				if (severity == error.SEVERITY_WARNING) {
					System.out.println("[dom3-warning]: " + error.getMessage());
				}
				if (severity == error.SEVERITY_FATAL_ERROR) {
					System.out.println("[dom3-fatal-error]: "
							+ error.getMessage());
				}
				return true;
			}
		};
	}

}

