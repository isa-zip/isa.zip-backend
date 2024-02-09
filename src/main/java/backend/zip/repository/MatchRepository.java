package backend.zip.repository;

import backend.zip.domain.enums.MatchStatus;
import backend.zip.domain.match.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Matching, Long> {

    // userId가 같은 userItem을 가지고 있고 matchStatus가 같은 Matching 객체들을 반환
    // 양방향 참조 상태라 이런 쿼리문 가능
    @Query("select m from Matching m where m.userItem.userId = :userId and m.matchStatus = :matchStatus")
    List<Matching> findByUserItemUserIdAndMatchStatus(Long userId, MatchStatus matchStatus);
}
