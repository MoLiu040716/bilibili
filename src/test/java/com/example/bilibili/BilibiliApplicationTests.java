package com.example.bilibili;

import com.example.bilibili.DTO.CommentAndReplyDTO;
import com.example.bilibili.mapper.rx.InteractionMapper;
import com.example.bilibili.service.rx.InteractionService;
import com.example.bilibili.service.rx.impl.InteractionServiceImpl;
import com.example.bilibili.util.VideoOperation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BilibiliApplicationTests {

    @Test
    void contextLoads() {
        int a=VideoOperation.getVideoDuration("E:\\VIDEO\\testVideo.mp4");
        System.out.println(a);
//        ffmpeg -i E:\VIDEO\testVideo.mp4 2>&1 | grep "Duration" | cut -d ' ' -f 4 | sed s/,//

    }

}
