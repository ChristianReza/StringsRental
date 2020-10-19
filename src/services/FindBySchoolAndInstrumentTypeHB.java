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

@WebServlet("/FindBySchoolAndInstrumentType")
public class FindBySchoolAndInstrumentTypeHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public FindBySchoolAndInstrumentTypeHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String instrumentType = request.getParameter("instrumentType").trim();
      String school = request.getParameter("schoolName").trim();

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

      List<StudentEntity> listStudents = null;
      if (instrumentType != null && !instrumentType.isEmpty()
    		  && school != null && !school.isEmpty()) {
         listStudents = UtilDBReza.FindBySchoolAndInstrumentType(instrumentType, school);
      } else {
         listStudents = UtilDBReza.listStudents();
      }
      display(listStudents, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<StudentEntity> listStudents, PrintWriter out) {
      for (StudentEntity student : listStudents) {
         System.out.println("[DBG] " + student.getId() + ", " //
               + student.getFirstName() + ", " //
               + student.getLastName() + ", " //
               + student.getGradeLevel());

         out.println("<li>" + student.toString() + "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
