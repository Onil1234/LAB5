package tpsi.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "PersonListServlet", urlPatterns = {"/personList"})
public class PersonListServlet extends HttpServlet {


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    //Integer a = (Integer) request.getAttribute("Counter");
    int a;
    //List<Person> osoby = (List<Person>) request.getAttribute("lista");
    if(session.getAttribute("Counter") == null){
        a=0;
    }else {
        
        a = (Integer) session.getAttribute("Counter");
        a++;
    }
//    if( osoby == null){
//        osoby = new ArrayList<>();
//    }
   
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    session.setAttribute("Counter", a);
   // session.setAttribute("lista", osoby);
    request.getRequestDispatcher("personList.jsp").forward(request, response);

}
    
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    int  a;
    //ClearSessionAtributes(session, a, osoby);
    if(session.getAttribute("Counter") == null){
        a=0;
    }else {
        
        a = (Integer) session.getAttribute("Counter");
        a++;
    }

    String imie = request.getParameter("imie");
    String nazwisko = request.getParameter("nazwisko");
    String email = request.getParameter("email");
    
    Person osoba = new Person(imie, nazwisko, email);
    List<Person> osoby = new ArrayList<>();
    
    if (session.getAttribute("lista") != null)
        {
            osoby = (List<Person>)session.getAttribute("lista");
        }
    
    
    osoby.add(osoba);

    session.setAttribute("Counter", a);
    session.setAttribute("lista", osoby);
    request.getRequestDispatcher("personList.jsp").forward(request, response);

}


}
