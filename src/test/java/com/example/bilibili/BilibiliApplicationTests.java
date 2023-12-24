package com.example.bilibili;

import com.example.bilibili.entity.Advertiser;
import com.example.bilibili.mapper.rx.AdvertiseMapper;
import com.example.bilibili.service.rx.AdvertiseService;
import com.example.bilibili.service.rx.impl.AdvertiseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;

@SpringBootTest
class BilibiliApplicationTests {

    @Test
    void contextLoads() {
        AdvertiseService ad = new AdvertiseServiceImpl();
        Date date=new Date("2023-10-10 13:22");
        System.out.println(ad.clickAdvertise(1,4,date ));
    }

}
