package by.it_academy.jd2.Mk_JD2_103_23.vote.endpoints.html;

import by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto.Artist;
import by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto.Genre;
import by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto.PairData;
import by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto.Vote;
import by.it_academy.jd2.Mk_JD2_103_23.vote.core.exceptions.ValidationException;
import by.it_academy.jd2.Mk_JD2_103_23.vote.service.VoteService;
import by.it_academy.jd2.Mk_JD2_103_23.vote.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = "/statistics")
public class StatisticsServlet extends HttpServlet {

    private IVoteService voteService = new VoteService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        Map<Artist, Integer> artistStatistics = voteService.getArtistStatistics();

        artistStatistics.forEach((k, v) -> writer.write(k.getName() + ": " + v + "<br/>"));
        Map<Genre, Integer> genreStatistics = voteService.getGenreStatistics();
        genreStatistics.forEach((k, v) -> writer.write(k.getName() + ": " + v + "<br/>"));

        List<PairData<LocalDateTime, String>> abouts = voteService.getAbouts();

        abouts.forEach((data) -> writer.write(data.getKey() + ": " + data.getValue() + "<br/>"));
    }
}
