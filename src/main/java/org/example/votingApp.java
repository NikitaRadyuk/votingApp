package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/voting")
public class votingApp extends HttpServlet {
    List<Counter> authors = new ArrayList<>();
    List<Counter> genres = new ArrayList<>();
    List<Message> textsTime = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain; charset=UTF-8");

        String author = req.getParameter("author");
        String[] genres = req.getParameterValues("checkboxGroup[]");
        String text = req.getParameter("myTextarea");

        String result = "Результат:" + author + ", " + genres + " " + text;

        if(genres == null || genres.length < 3){
            resp.sendRedirect("pages/errorPage.html");
        }

        PrintWriter out = resp.getWriter();
        boolean hasAuthor = false;
        for (Counter aut: authors) {
            if (aut.name.equals(author)){
                aut.count++;
                hasAuthor = true;
            }
        }
        if(!hasAuthor){
            authors.add(new Counter(author));
        }

        for (String genre: genres
             ) {
            boolean hasGenre = false;
            for (Counter aut: this.genres) {
                if (aut.name.equals(genre)){
                    aut.count++;
                    hasGenre = true;
                }
            }
            if(!hasGenre){
                this.genres.add(new Counter(genre));
            }

        }

        textsTime.add(new Message(text));

        authors.sort((a,b) -> b.count - a.count);
        this.genres.sort((a,b) ->b.count - a.count);

        out.println("Список исполнителей:");
        out.println(authors.toString());
        out.println("Список жанров:");
        out.println(this.genres.toString());
        out.println("Список по времени отправки:");
        out.println(textsTime.toString());
    }
}