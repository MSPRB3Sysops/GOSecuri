package fr.mspr;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadAgents {

	static Path currentDirectory = Paths.get("").toAbsolutePath();

	public static void main(String[] args) throws Exception {

		List<Agent> agents = initAgents();
		createHomePage(agents);

	}

	private static List<Agent> initAgents() throws IOException {

		Path readAgents = Paths.get("staff.txt");
		List<String> lines = Files.readAllLines(readAgents, StandardCharsets.UTF_8);
		List<Agent> agents = new ArrayList<>();
		for (String agentId : lines) {
			Agent agent = new Agent(agentId);
			Path readInfo = Paths.get(agent.getId() + ".txt");
			List<String> infoLines = Files.readAllLines(readInfo, StandardCharsets.UTF_8);
			agent.setNom(infoLines.get(0));
			agent.setPrenom(infoLines.get(1));
			agent.setRole(infoLines.get(2));
			agent.setMdp(infoLines.get(3));
			for (int i = 5; i < infoLines.size(); i++) {
				agent.addEquipement(infoLines.get(i));
			}
			agents.add(agent);
		}
		return agents;

	}

	private static void createHomePage(List<Agent> agents) throws IOException {

		Path source = Paths.get("source.html");
		Path f = Files.createFile(source);

		BufferedWriter bw = Files.newBufferedWriter(f);
		bw.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<title>GO Securi</title>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n" + "<style>\r\n"
				+ "body {font-family: \"Roboto\";}\r\n" + "h1, h2, h3, h4, h5, h6 {\r\n"
				+ "  font-family: \"Playfair Display\";\r\n" + "  letter-spacing: 5px;\r\n" + "}\r\n" + "</style>\r\n"
				+ "\r\n" + "<body>\r\n" + "<!-- Navbar (sit on top) -->\r\n" + "<div class=\"w3-top\">\r\n"
				+ "  <div class=\"w3-bar w3-white w3-padding w3-card\" style=\"letter-spacing:4px;\">\r\n" + "    \r\n"
				+ "     <a href=\"#home\" class=\"w3-bar-item w3-button\">GO Securi<img src=\"logo.JPG\" width=\"100px\"> </img></a>\r\n"
				+ "    <!-- Right-sided navbar links. Hide them on small screens -->\r\n"
				+ "    <div class=\"w3-right w3-hide-small\">\r\n" + "     <!--menu-->\r\n" + "    </div>\r\n"
				+ "  </div>\r\n" + "</div>\r\n" + "\r\n" + "\r\n" + "\r\n" + "<!-- Page content -->\r\n"
				+ "<div class=\"w3-content\" style=\"max-width:1100px\">\r\n" + "\r\n" + "\r\n"
				+ "      <h1 class=\"w3-center\">Titre</h1><br>\r\n" + "      \r\n" + "      <p class=\"w3-large\">");
		for (Agent agent : agents) {
			bw.write("<a href=" + agent.getId() + ".html>" + "<input type=" + "button" + " value=" + agent.getId()
					+ "> </a><br>");

		}

		bw.write("</p>\r\n" + "    \r\n" + "  </div>\r\n" + "  \r\n" + "  <hr>\r\n" + "  \r\n" + "  \r\n" + "  \r\n"
				+ "<!-- End page content -->\r\n" + "</div>\r\n" + "\r\n" + "<!-- Footer -->\r\n"
				+ "<footer class=\"w3-center w3-light-grey w3-padding-32\">\r\n"
				+ "  <img src=\"logo.JPG\" width=\"120px\"> </img>\r\n" + "  <h3>MSPR GO Securi</h3>\r\n"
				+ "</footer>\r\n" + "\r\n" + "</body>\r\n" + "</html>");
		bw.close();

	}

}
