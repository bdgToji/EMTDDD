package mk.ukim.finki.emt.streamingmanagement.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.events.streams.StreamCreated;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import mk.ukim.finki.emt.streamingmanagement.domain.exceptions.WatchHistoryIdNotExistsException;
import mk.ukim.finki.emt.streamingmanagement.domain.exceptions.WatchMovieIdNotExistsException;
import mk.ukim.finki.emt.streamingmanagement.domain.model.WatchHistory;
import mk.ukim.finki.emt.streamingmanagement.domain.model.WatchHistoryId;
import mk.ukim.finki.emt.streamingmanagement.domain.model.WatchMovieId;
import mk.ukim.finki.emt.streamingmanagement.domain.repository.WatchHistoryRepository;
import mk.ukim.finki.emt.streamingmanagement.service.WatchHistoryService;
import mk.ukim.finki.emt.streamingmanagement.service.forms.WatchHistoryForm;
import mk.ukim.finki.emt.streamingmanagement.service.forms.WatchMovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class WatchHistoryImpl implements WatchHistoryService {
    private final WatchHistoryRepository watchHistoryRepository;
    private final DomainEventPublisher domainEventPublisher;

    private final Validator validator;

    @Override
    public WatchHistoryId watch(WatchHistoryForm watchHistoryForm) {
        Objects.requireNonNull(watchHistoryForm, "Watch history must not be null");
        var constraintViolations = validator.validate(watchHistoryForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The watch history form is not valid", constraintViolations);
        }
        var newWatch = watchHistoryRepository.saveAndFlush(toDomainObject(watchHistoryForm));
        newWatch.getWatchMovieList().forEach(item->domainEventPublisher.publish(new StreamCreated(item.getMovieId().getId())));
        return newWatch.getId();

    }

    private WatchHistory toDomainObject(WatchHistoryForm watchHistoryForm){
        var watchHistory = new WatchHistory(Instant.now());
        watchHistoryForm.getItems().forEach(item->watchHistory.addMovie(item.getMovie()));
        return watchHistory;
    }

    @Override
    public List<WatchHistory> findAll() {
        return watchHistoryRepository.findAll();
    }

    @Override
    public Optional<WatchHistory> findById(WatchHistoryId watchHistoryId) {
        return watchHistoryRepository.findById(watchHistoryId);
    }

    @Override
    public void addItem(WatchHistoryId watchHistoryId, WatchMovieForm watchMovieForm) throws WatchHistoryIdNotExistsException {
        WatchHistory watchHistory = watchHistoryRepository.findById(watchHistoryId).orElseThrow(WatchHistoryIdNotExistsException::new);
        watchHistory.addMovie(watchMovieForm.getMovie());
        watchHistoryRepository.saveAndFlush(watchHistory);
        domainEventPublisher.publish(new StreamCreated(watchMovieForm.getMovie().getId().getId()));
    }

    @Override
    public void deleteItem(WatchHistoryId watchHistoryId, WatchMovieId watchMovieId) throws WatchHistoryIdNotExistsException, WatchMovieIdNotExistsException {
        WatchHistory watchHistory = watchHistoryRepository.findById(watchHistoryId).orElseThrow(WatchHistoryIdNotExistsException::new);
        watchHistory.removeMovie(watchMovieId);
        watchHistoryRepository.saveAndFlush(watchHistory);
    }
}
