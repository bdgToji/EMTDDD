package mk.ukim.finki.emt.streamingmanagement.service;

import mk.ukim.finki.emt.streamingmanagement.domain.exceptions.WatchHistoryIdNotExistsException;
import mk.ukim.finki.emt.streamingmanagement.domain.exceptions.WatchMovieIdNotExistsException;
import mk.ukim.finki.emt.streamingmanagement.domain.model.WatchHistory;
import mk.ukim.finki.emt.streamingmanagement.domain.model.WatchHistoryId;
import mk.ukim.finki.emt.streamingmanagement.domain.model.WatchMovieId;
import mk.ukim.finki.emt.streamingmanagement.service.forms.WatchHistoryForm;
import mk.ukim.finki.emt.streamingmanagement.service.forms.WatchMovieForm;

import java.util.List;
import java.util.Optional;

public interface WatchHistoryService {
    WatchHistoryId watch(WatchHistoryForm watchHistoryForm);
    List<WatchHistory> findAll();
    Optional<WatchHistory> findById(WatchHistoryId watchHistoryId);
    void addItem(WatchHistoryId watchHistoryId, WatchMovieForm watchMovieForm) throws WatchHistoryIdNotExistsException;

    void deleteItem(WatchHistoryId watchHistoryId, WatchMovieId watchMovieId) throws WatchHistoryIdNotExistsException, WatchMovieIdNotExistsException;
}
