package com.example.Ex1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button draw;
    ImageView card_1;
    ImageView card_2;
    ImageView card_3;
    TextView notification;
    int totalPoint=0;
    int totalDraw=0;
    boolean jackbot=true;
    String notifications="";
    ArrayList<String> drawedCard=new ArrayList<String>();

    int cardScreen[][]={
            {R.drawable.b2fv,
                    R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
                    R.drawable.cj,R.drawable.cq,R.drawable.ck},
            {R.drawable.b2fv,
                    R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
                    R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
                    R.drawable.dj,R.drawable.dq,R.drawable.dk},
            {R.drawable.b2fv,
                    R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
                    R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
                    R.drawable.hj,R.drawable.hq,R.drawable.hk},
            {R.drawable.b2fv,
                    R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
                    R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
                    R.drawable.sj,R.drawable.sq,R.drawable.sk}
    };
    String cardName[][]={
            {"rong",
                    "ách chuồn","hai chuồn","ba chuồn","bốn chuồn","năm chuồn",
                    "sáu chuồn","bảy chuồn","tám chuồn","chín chuồn","mười chuồn",
                    "bồi chuồn","đầm chuồn","già chuồn"},
            {"rong",
                    "ách rô","hai rô","ba rô","bốn rô","năm rô",
                    "sáu rô","bảy rô","tám rô","chín rô","mười rô",
                    "bồi rô","đầm rô","già rô"},
            {"rong",
                    "ách cơ","hai cơ","ba cơ","bốn cơ","năm cơ",
                    "sáu cơ","bảy cơ","tám cơ","chín cơ","mười cơ",
                    "bồi cơ","đầm cơ","già cơ"},
            {"rong",
                    "ách bích","hai bích","ba bích","bốn bích","năm bích",
                    "sáu bích","bảy bích","tám bích","chín bích","mười bích",
                    "bồi bích","đầm bích","già bích"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw=(Button)findViewById(R.id.draw);
        card_1=(ImageView)findViewById(R.id.card_1);
        card_2=(ImageView)findViewById(R.id.card_2);
        card_3=(ImageView)findViewById(R.id.card_3);
        notification=(TextView)findViewById(R.id.txtthongbao);
        draw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub
                if(totalDraw==0)
                {totalDraw=0;
                    totalPoint=0;
                    jackbot=true;
                    notifications="";
                    card_1.setImageResource(R.drawable.b2fv);
                    card_2.setImageResource(R.drawable.b2fv);
                    card_3.setImageResource(R.drawable.b2fv);
                    drawedCard.clear();
                }
                totalDraw++;
                Random rd=new Random();
                int x,y;
                while(true)
                {
                    x=rd.nextInt(4);//0->3 (b-a+1)+a;
                    y=rd.nextInt(13)+1;//1->13
                    if(drawedCard.contains(cardName[x][y])==false)
                    {
                        drawedCard.add(cardName[x][y]);
                        break;
                    }
                }
                if(y<11)
                    jackbot=false;
                if(totalDraw==1)
                {
                    totalPoint+=(y<10)?y:0;
                    card_1.setImageResource(cardScreen[x][y]);
                }
                else if(totalDraw==2)
                {
                    totalPoint+=(y<10)?y:0;
                    card_2.setImageResource(cardScreen[x][y]);
                }
                else if(totalDraw==3)
                {
                    totalPoint+=(y<10)?y:0;
                    int kq=totalPoint%10;
                    totalDraw=0;
                    card_3.setImageResource(cardScreen[x][y]);
                    notifications+=" --> Số nút là "+ kq;
                }
                notification.setText("Các lá đã rút "+ drawedCard.toString() + notifications + "\n"
                        +"----> Ba tây: "+jackbot);
            }
        });
    }
}