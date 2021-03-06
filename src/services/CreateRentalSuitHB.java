package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodels.dto.InstrumentDTO;
import datamodels.dto.ParentGuardianDTO;
import datamodels.dto.SchoolDTO;
import datamodels.dto.StudentDTO;
import datamodels.enums.InstrumentType;
import datamodels.enums.Size;
import util.Info;
import util.UtilDBReza;

@WebServlet("/createRentalSuit")
public class CreateRentalSuitHB extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;

	public CreateRentalSuitHB() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("studentFirstName").trim();
		String lastName = request.getParameter("studentLastName").trim();
		String gradeLevel = request.getParameter("gradeLevel");
		String instrumentType = request.getParameter("instrumentType");
		String instrumentSize = request.getParameter("instrumentSize");

		String parentGuardianFirstName = request.getParameter("parentGuardianFirstName");
		String parentGuardianLastName = request.getParameter("parentGuardianLastName");
		String parentGuardianPhone = request.getParameter("parentGuardianPhone");
		String parentGuardianAddress = request.getParameter("parentGuardianAddress");
		String parentGuardianEmail = request.getParameter("parentGuardianEmail");
		String parentGuardianCC = request.getParameter("parentGuardianCC");

		// Create ParentGuardianDTO from endpoint request
		ParentGuardianDTO parentGuardian = new ParentGuardianDTO(parentGuardianFirstName, parentGuardianLastName,
				parentGuardianCC, parentGuardianPhone, parentGuardianAddress, parentGuardianEmail);

		String schoolName = request.getParameter("schoolName");
		String schoolAddress = request.getParameter("schoolAddress");
		String schoolPhone = request.getParameter("schoolPhone");

		// Create SchoolDTO from endpoint request
		SchoolDTO school = new SchoolDTO(schoolName, schoolPhone, schoolAddress);

		// Create StudentDTO from endpoint request
		StudentDTO student = new StudentDTO(firstName, lastName, school, new InstrumentDTO(), parentGuardian,
				Integer.valueOf(gradeLevel));
		// Create InstrumentDTO from endpoint request
		InstrumentDTO instrument = new InstrumentDTO("TBA", InstrumentType.valueOf(instrumentType),
				Size.valueOf(instrumentSize), student);

		UtilDBReza.createStudent(firstName, lastName, school, instrument, parentGuardian, Integer.valueOf(gradeLevel));

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head><title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<ul>");
		out.println("<li> Name: " + firstName + " " + lastName);
		out.println("<li> Grade: " + gradeLevel);
		out.println("<li> School: " + parentGuardianFirstName + " " + parentGuardianLastName);
		out.println("<li> School: " + schoolName);
		out.println("</ul>");
		out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
