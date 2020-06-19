package pl.klobut.my_video_shop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.klobut.my_video_shop.dao.entity.VideoCasette;

@Repository
public interface VideoCasseteRepo extends CrudRepository<VideoCasette, Long> {
}
