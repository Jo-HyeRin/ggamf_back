package shop.ggamf.ggamf.domain.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select r from Room r join fetch r.user u where r.user.id = :userId")
    List<Room> findByUserId(@Param("userId") Long userId);

}
