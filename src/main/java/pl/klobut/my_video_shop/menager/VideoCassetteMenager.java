package pl.klobut.my_video_shop.menager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.klobut.my_video_shop.dao.VideoCasseteRepo;
import pl.klobut.my_video_shop.dao.entity.VideoCasette;

import java.time.LocalDate;
import java.util.Collections;

@Service
public class VideoCassetteMenager {
    private VideoCasseteRepo videoCasseteRepo;

    @Autowired
    public VideoCassetteMenager(VideoCasseteRepo videoCasseteRepo) {
        this.videoCasseteRepo = videoCasseteRepo;
    }

    public Iterable<VideoCasette> findById(Long id) {
        return videoCasseteRepo.findAllById(Collections.singleton(id));
    }

    public Iterable<VideoCasette> findAll() {
        return videoCasseteRepo.findAll();
    }

    public VideoCasette save(VideoCasette videoCasette) {
        return videoCasseteRepo.save(videoCasette);
    }

    public void deleteById(Long id) {
        videoCasseteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb() {
        save(new VideoCasette(1L, "Shrek", LocalDate.of(1991, 1, 1)));
        save(new VideoCasette(2L, "Tytanic", LocalDate.of(1994, 2, 2)));
    }
}
