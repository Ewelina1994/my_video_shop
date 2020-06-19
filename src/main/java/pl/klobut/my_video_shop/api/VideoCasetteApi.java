package pl.klobut.my_video_shop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.klobut.my_video_shop.dao.entity.VideoCasette;
import pl.klobut.my_video_shop.menager.VideoCassetteMenager;


@RestController
@RequestMapping("/api/cassetts/")
public class VideoCasetteApi {

    private VideoCassetteMenager videoCassetteMenager;

    @Autowired
    public VideoCasetteApi(VideoCassetteMenager videoCassetteMenager) {

        this.videoCassetteMenager=videoCassetteMenager;
    }

    @GetMapping("/all")
    public Iterable<VideoCasette> getAll(){
        return videoCassetteMenager.findAll();
    }

    @GetMapping
    public Iterable<VideoCasette> getById(@RequestParam Long index){
        return videoCassetteMenager.findById(index);
    }

    @PostMapping
    public VideoCasette addVideo(@RequestBody VideoCasette videoCasette){
        return videoCassetteMenager.save(videoCasette);
    }

    @PutMapping
    public VideoCasette updateVideo(@RequestBody VideoCasette videoCasette){
        return videoCassetteMenager.save(videoCasette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        videoCassetteMenager.deleteById(index);
    }
}
