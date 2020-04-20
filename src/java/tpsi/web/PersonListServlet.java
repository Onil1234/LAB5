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
int a=0;
List<Person> osoby = new ArrayList<>();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    ClearSessionAtributes(session);
//    if(session.getAttribute("Counter") == null){
//        a=1;
//    }
//    if(session.getAttribute("lista") == null){
//        osoby = new ArrayList<>();
//    }
    a++;
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    session.setAttribute("Counter", a);
    session.setAttribute("lista", osoby);
    request.getRequestDispatcher("personList.jsp").forward(request, response);

}
    
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    ClearSessionAtributes(session);
    String imie = request.getParameter("imie");
    String nazwisko = request.getParameter("nazwisko");
    String email = request.getParameter("email");
    if(!email.isEmpty()&&!nazwisko.isEmpty()&&!imie.isEmpty()){
        osoby.add(new Person(imie, nazwisko, email));
        
    }
    a++;
    session.setAttribute("Counter", a);
    session.setAttribute("lista", osoby);
    request.getRequestDispatcher("personList.jsp").forward(request, response);
    //response.sendRedirect("/LAB5/personList");

}

private void ClearSessionAtributes(HttpSession session){
    
    if(session.getAttribute("Counter") == null){
        a=0;
    }
    if(session.getAttribute("lista") == null){
        osoby = new ArrayList<>();
    }
}
    


}
