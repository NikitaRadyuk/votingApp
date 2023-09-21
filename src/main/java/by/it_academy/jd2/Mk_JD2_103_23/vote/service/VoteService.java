package by.it_academy.jd2.Mk_JD2_103_23.vote.service;

import by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto.Artist;
import by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto.Genre;
import by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto.PairData;
import by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto.Vote;
import by.it_academy.jd2.Mk_JD2_103_23.vote.core.exceptions.ValidationException;
import by.it_academy.jd2.Mk_JD2_103_23.vote.dao.VoteDao;
import by.it_academy.jd2.Mk_JD2_103_23.vote.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_103_23.vote.service.api.IVoteService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class VoteService implements IVoteService {

    private IVoteDao voteDao = new VoteDao();

    @Override
    public void save(Vote vote) {
        if(vote == null){
            throw new IllegalArgumentException("Нет информации о голосе");
        }

        if(vote.getGenres() != null){
            int size = vote.getGenres().size();
            if(size < 3 || size > 5){
                throw new ValidationException("Выбрано неправильное количество жанров");
            }
        } else {
            throw new IllegalArgumentException("Нет информации о жанрах");
        }
        voteDao.save(vote);
    }

    @Override
    public Map<Artist, Integer> getArtistStatistics() {
        return this.voteDao.getArtistStatistics();
    }

    @Override
    public Map<Genre, Integer> getGenreStatistics() {
        return this.voteDao.getGenreStatistics();
    }

    @Override
    public List<PairData<LocalDateTime, String>> getAbouts() {
        return this.voteDao.getAbouts();
    }
}
