package com.example.a503_.nije0928_view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class ButtonShow extends AppCompatActivity {

    // 스레드를 annoymous class 를 이용해서 만들 것인데
    // anonymous class 는 지역 변수를 사용할 수가 없다.
    ImageView imageView;
    Bitmap bitmap;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_show);

        imageView = (ImageView) findViewById(R.id.imgview);
        // 리소스에 포함된 이미지 가져오기
        // imgView.setImageResource(R.drawable.comodo);

        // 웹의 이미지 출력하기
        url = "http://cafefiles.naver.net/data4/2004/6/8/289/%C4%DA%B8%F0%B5%B5%BC%B6%C0%C7_%C4%DA%B8%F0%B5%B5%B5%E5%B7%A1%B0%EF_%B0%F8%B7%E6%C0%C7_%C8%C4%BF%B9.jpg";

        Thread th = new Thread(){
            public  void run() {
                try{
                    // 웹에서 데이터를 가져올 수 있는 스트림을 생성
                    InputStream is = new URL(url).openStream();
                    // 스트림의 데이터를 이미지로 변경
                    bitmap = BitmapFactory.decodeStream(is);
                }catch(Exception e){}

            }
        };
        // 스레드 시작
        th.start();

        // 스레드의 수행이 종료되면 이미지를 설정
        try{
            // 스레드 수행이 종료될 때 까지 대기
            th.join();
            imageView.setImageBitmap(bitmap);
        }catch(Exception e){}





    }

}
