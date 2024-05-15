package mk.ukim.finki.emt.streamingmanagement.domain.repository;

import mk.ukim.finki.emt.streamingmanagement.domain.model.WatchHistory;
import mk.ukim.finki.emt.streamingmanagement.domain.model.WatchHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory, WatchHistoryId> {
}
