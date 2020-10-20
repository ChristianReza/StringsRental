package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodels.entities.StudentEntity;
import util.Info;
import util.UtilDBReza;

@WebServlet("/UpdateSerialNumByStudentFirstNameAndParentLast")
public class UpdateSerialNumByStudentFirstNameAndParentLastHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public UpdateSerialNumByStudentFirstNameAndParentLastHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String studentFirst = request.getParameter("studentName").trim();
      String oldSerialNumber = request.getParameter("oldSerialNumber").trim();
      String newSerialNumber = request.getParameter("newSerialNumber").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
				"<html>\n" + //
				"<head>" + //
				"<style>table, th, td {\r\n" + "  border: 1px solid black;\r\n" + //
				"border-collapse: collapse;\r\n  } </style>" + // 
				"<title>" + title + "</title></head>\n" + //
				"<body bgcolor=\"#f0f0f0\">\n" + //
				"<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<StudentEntity> listStudents = null;
      if (studentFirst != null && !studentFirst.isEmpty()) {
         listStudents = UtilDBReza.UpdateSerialNumByStudentFirstNameAndParentLast(studentFirst, oldSerialNumber, newSerialNumber);
      } else {
         listStudents = UtilDBReza.listStudents();
      }
      display(listStudents, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<StudentEntity> listStudents, PrintWriter out) {
	   StringBuilder tableBuilder = new StringBuilder();
		tableBuilder.append("<table> <tr> <th>ID</th> <th>First Name</th> <th>Last Name</th> <th>Grade Level</th> "
				+ "<th>School Name</th> <th>School Phone</th> <th>School Address</th> "
				+ "<th>Instrument Serial Number</th> <th>Instrument Type</th> <th>Instrument Size</th> "
				+ "<th>Parent/Guardian First Name</th> <th>Parent/Guardian Last Name</th> <th>Parent/Guardian Phone</th> <th>Parent/Guardian Email</th> <th>Parent/Guardian Address</th> <th>Parent/Guardian CC</th></tr>");
		for (StudentEntity student : listStudents) {
			System.out.println("[DBG] " + student.getId() + ", " //
					+ student.getFirstName() + ", " //
					+ student.getLastName() + ", " //
					+ student.getGradeLevel() + ", " //
					+ student.getParentGuardianPhone() + ", " //
					+ student.getParentGuardianEmail() + ", " //
					+ student.getParentGuardianAddress() + ", " //
					+ student.getParentGuardianCC() + ", " //
			);

			tableBuilder.append(String.format(
					"<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td>  </tr>",
					student.getId(), student.getFirstName(), student.getLastName(), student.getGradeLevel(),
					student.getSchoolName().toString(), student.getSchoolPhone(), student.getSchoolAddress(),
					student.getInstrumentSerialNumber(), student.getInstrumentType(), student.getInstrumentSize(),
					student.getParentGuardianFirstName(), student.getParentGuardianLastName(),
					student.getParentGuardianPhone(), student.getParentGuardianEmail(),
					student.getParentGuardianAddress(), student.getParentGuardianCC()));

		}
		tableBuilder.append("</table>");
		out.println(tableBuilder);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
