package com.RosaryCatholic;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.RosaryCatholic.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity implements View.OnClickListener{

	Button happy;
	Button luminous;
	Button sad;
	Button glory;
	Button start;
	Button Home;
	Button Prv;
	Button Next;
	
	TextView Today;
	
	
	static TextView tvHappy;
	TextView count;
	static ImageView meditationImg;
	
	static int countNo;
	static int RosaryType;
	static int ActualRosaryType;
	static int RosaryPart;
	static String todayvalue;
	
	final String Cross = "In the name of the Father of the Son and of the Holy Spirit. Amen";
    
    final String greed  = "I believe in God the Father Almighty, Creator of heaven and earth; and in Jesus Christ, His only Son, our Lord; Who was conceived by the Holy Ghost, born of the Virgin Mary, suffered under Pontius Pilate, was crucified, died and was buried. He descended into hell. On the third day He arose again; He ascended into heaven,and sitteth at the right hand of God, the Father Almighty; from thence He shall come to judge the living and the dead. I believe in the Holy Ghost, the Holy Catholic Church, the communion of saints, the forgivness of sins, the resurrection of the body, and life everlasting. Amen";
    
    final String ourfather = "Our Father, who art in heaven, hallowed be Thy name: Thy kingdom come: Thy will be done on earth as it is in heaven. Give us this day our daily bread: and forgive us our trespasses as we forgive those who trespass against us. And lead us not into temptation: but deliver us from evil. Amen."; 
    
    final String hailMary = "Hail Mary, full of grace, the Lord is with thee: blessed art thou among women, and blessed is the fruit of thy womb, Jesus. Holy Mary, Mother of God, pray for us sinners, now and at the hour of our death. Amen";

    final String CrossAlone = "Glory be to the Father, and to the Son and to the Holy Spirit As it was in the beginning, is now and ever shall be, world without end. Amen.";
   
    final String Ojesus = "O my Jesus, forgive us our sins, save us from the fires of hell, and lead all souls to Heaven, especially those in most need of Your Mercy";
    
    final String kirubai = "Hail, holy Queen, Mother of Mercy! our life, our sweetness, and our hope! To thee do we cry, poor banished children of Eve; to thee do we send up our sighs, mourning and weeping in this valley, of tears. Turn, then, most gracious Advocate, thine eyes of mercy toward us; and after this our exile show unto us the blessed fruit of thy womb, Jesus; O clement, O loving, O sweet Virgin Mary";
    
    final String kirubai1 = "Pray for us, O Holy Mother of God. That we may be made worthy of the promises of Christ.";
    		
 
   
    final String Happy1 = "1st joyful mystery - The Annunciation of the Angel to Mary \n Oh Mary with Your 'Yes' You have opened heaven's ways, You have achieved the will of the Father. You will be blessed for ever: Your intercession is heard in Heaven, because You have accepted God's plan. Let us pray that we can say 'yes' to the Father in every instance He ask it of us. Mary help us to be humble and obedient to God's will."; 

  	
    final String Happy2 =  "2nd joyful mystery - The visitation of Mary to Saint Elizabeth \n Mary goes to visit Elisabeth: She carries God to Her cousin, for the love of Her brothers and neighbours. Lord help us to carry Christ to others, like Mary did. Let us ask Mary the gift of burning charity.";
	
    final String Happy3 = "3rd joyful mystery - The nativity of Jesus in Bethlehem \n Infant Jesus in the manger. Mary, Joseph and the shepherds adore Him. Let us also adore Christ, the Son of God, in the silence of our soul and from the depth of our heart. Let us ask Mary to make us love Jesus more, and also the gift of poverty of spirit.";
    final String Happy4 = "4th joyful mystery - The presentation of Jesus to the Temple \n We need to pay attention to the voice of God, to discern His call and accept the mission He gave us. After the Simeon prophecy, Mary takes into Her Heart the wound of sorrow, but in the silence She accepts the will of Her Father.";
    final String Happy5 = "5th joyful mystery - The finding of Jesus in the Temple \n Let us think of how many times we have been far from Jesus; from that Jesus, who with so much love has died for us. Let us meditate that in the difficulties of life the only safety is finding Jesus and never again leaving his great love.";
    
    
    final String lum1 = "1st light mystery - The Baptism of Jesus \n The Baptism in the Jordan is first of all a mystery of light. Here, as Christ descends into the waters, the innocent one who became “sin” for our sake (cf. 2Cor 5:21), the heavens open wide and the voice of the Father declares him the beloved Son (cf. Mt 3:17 and parallels), while the Spirit descends on him to invest him with the mission which he is to carry out.";
    final String lum2 = "2nd light mystery - The wedding of Cana \n Another mystery of light is the first of the signs, given at Cana (cf. Jn 2:1- 12), when Christ changes water into wine and opens the hearts of the disciples to faith, thanks to the intervention of Mary, the first among believers.";
    final String lum3 = "3rd light mystery - The proclamation of the Kingdom of God \n The preaching by which Jesus proclaims the coming of the Kingdom of God, calls to conversion (cf. Mk 1:15) and forgives the sins of all who draw near to him in humble trust (cf. Mk 2:3-13; Lk 7:47- 48): the inauguration of that ministry of mercy which he continues to exercise until the end of the world, particularly through the Sacrament of Reconciliation which he has entrusted to his Church (cf. Jn 20:22-23).";
    final String lum4 = "4th light mystery - The Transfiguration \n The mystery of light par excellence is the Transfiguration, traditionally believed to have taken place on Mount Tabor. The glory of the Godhead shines forth from the face of Christ as the Father commands the astonished Apostles to “listen to him” (cf. Lk 9:35 and parallels) and to prepare to experience with him the agony of the Passion, so as to come with him to the joy of the Resurrection and a life transfigured by the Holy Spirit.";
    final String lum5 = "5th light mystery - The institution of the Eucharist \n A final mystery of light is the institution of the Eucharist, in which Christ offers his body and blood as food under the signs of bread and wine, and testifies “to the end” his love for humanity (Jn 13:1), for whose salvation he will offer himself in sacrifice.";

    final String sad1 = "1st sorrowful mystery- The Agony of Jesus in the garden \n In the forsaking prayer to the Father, Jesus found strength, trust, and an angel was sent to comfort Him. So Jesus will be our comforting angel. It's as He said to us: ' Why do you worry in your difficulties? Be strong in me; look to your God in your most troubled hour, and you will be triumphant.' Let us ask to forsake ourselves to God, to always do His will.";
    final String sad2 = "2nd sorrowful mystery -The scourging of Jesus at the pillar \n How many pains, how many torments, and how many wounds on the body of Jesus? How much blood falls to the ground, while His tormenters laugh, insult him, and gather their strength to hit the innocent body of Jesus again? Let us ask to accept every insult for the love of our Lord, and also a true regret for our sins.";
    final String sad3 = "3rd sorrowful mystery - The Crowning with with Thorns \n Think of the indignity, outrage, pain, and humiliation that Jesus suffered. They striped Him of every dignity, He was treated as the guilt of our worst sins. He seems to say to us: ' Why do you despair when you suffer? Is that the way you love me? Meditate about my passions and find in them great riches.' Let us ask the gift of patience to accept all humiliations, thinking of how Jesus suffered for us.";
    final String sad4 = "4th sorrowful mystery - The Carrying of the Cross \n Even if He had suffered just for you, Jesus would have accepted such pains, great is His love for you. Along the road to Calvary Jesus sees Mary, His Mother. Can we imagine the moment when Their eyes met? Oh how Her Heart must have ached. Let us pray to Mary for the grace to always accept our cross.";
    final String sad5 = "5th sorrowful mystery - The crucifixion and death of Jesus \n Jesus wishes to see us close to His Mother; He wishes that, like children, we keep our hand in the hand of Mary. That is what He wants. He asks us to look to the heavenly Mother, that is depend on Her. He asks that we accept Our Lady as our true Mother, who will ignite in us a fervent love of Her Son. Mary, we trust in You, take us and put us in the refuge of Your Immaculate Heart, heal with Your humility our pride, that so often takes us far from God.";
    
    final String glo1 = "1st glorious mystery - The Resurrection of Jesus Christ \n The risen Jesus has proved that man, together with Him, can have power over sin and therefore death. Jesus, help raise us, deliver us from sin, from evil, give us Your light, give us Your joy. Rekindle inside us the love, the faith, the hopefulness, and the gift of prayer. Let us ask Mary for the gift of an unshakeable faith.";
    final String glo2 = "2nd glorious mystery - The Ascension of Jesus to Heaven \n Jesus, You have not deserted Your apostles in anguish, but have given them the joy of knowing Jesus 'glorified' over 40 days . After Your Ascension, You granted to all those who seek You the gift of recieving You in the Eucharist. Through Mary we trust in you. Mary, give us the gift of hope.";
    final String glo3 = "3rd glorious mystery - The Descent of the Holy Ghost \n Jesus, inffuse us with the Comforter, the Holy Ghost, enlighten us with the light of Your Spirit, with His strength enter in the deepest parts of our hearts and heal us. Deliver us, fill up our hearts with Your love. Make us apostles of Yours, dear Lord. Let us ask Mary the gift of true love, the gift of prayer from the heart.";
    final String glo4 = "4th glorious mystery - The Assumption of the Blessed Virgin Mary into Heaven \n Now that Mary is raised into heaven, She prays for Her sons and daughters, those sons and daughters Jesus left Her when He was on the cross. Mary, pray for us, You know our fears, take us into Your Heart, the Heart of a Mother. Help us now and in the time of our death to be with You in Heaven. We ask of you a devotion to Your Immaculate Heart, where we may take refuge in times of trouble.";
    final String glo5 = "5th glorious mystery - The Coronation of the Blessed Virgin Mary, Queen of Heaven and Earth \n Let us trust in Mary, Let us call to Her, let us love Her, let us confide in Her, because She gives Her all to us. We have a Mother in Heaven who is also a Queen; thus we need to turn to Her with full faith and hopefulness. If we ask for something while praying the Holy Rosary, it will be granted to us. Ask Her for the gift of prayer, a prayer of the heart, said only for love, a love for Her and Jesus. Let us also ask for a consistency of prayer, to always be joined to Her Heart, and therefore to the Heart of Jesus.";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/BIBLE2.TTF");
        Typeface tf = null;
        countNo = 0;
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE"); 
        Date d = new Date(); 
        String dayOfTheWeek = sdf.format(d);
        
        
        if ((dayOfTheWeek.contains("Monday"))||(dayOfTheWeek.contains("Saturday")))
        
        {
        	RosaryType = 1;//happy
        	todayvalue = "Monday and Saturday \n Today - JOYFUL";
        	
        }
        if ((dayOfTheWeek.contains("Sunday")) || (dayOfTheWeek.contains("Wednesday")))
        {
        	RosaryType = 2;//glory
        	todayvalue = "Wednesday and Sunday \n Today - GLORIOUS";
        }
        
        if ((dayOfTheWeek.contains("Tuesday"))||((dayOfTheWeek.contains("Friday"))))
            
        {
        	RosaryType = 3;//sad
        	todayvalue = "Tuesday and Friday \n Today - SORROWFUL";
        }
        if (dayOfTheWeek.contains("Thursday"))
        {
        	RosaryType = 4;//luminus
        	todayvalue = "Thursday \n Today - LIGHT ";
        }
        
        ActualRosaryType = RosaryType;       
        happy = (Button)findViewById(R.id.happy);
        happy.setTypeface(tf);
        happy.setTextSize(20); 
        happy.setText("JOY");
        
        luminous = (Button)findViewById(R.id.luminous);
        luminous.setTypeface(tf);
        luminous.setTextSize(20); 
        luminous.setText("LIGHT");
        
        sad = (Button)findViewById(R.id.Sad);
        sad.setTypeface(tf);
        sad.setTextSize(20); 
        sad.setText("SAD");
        
        glory = (Button)findViewById(R.id.Glory);
        glory.setTypeface(tf);
        glory.setTextSize(20); 
        glory.setText("GLORY");
        
        Today = (TextView)findViewById(R.id.TextView01);
        Today.setTypeface(tf);
        Today.setTextSize(20);
        Today.setText(todayvalue);
        
        		
        		
        start = (Button)findViewById(R.id.Start);        
        start.setOnClickListener((OnClickListener) this);
        happy = (Button)findViewById(R.id.happy);
        happy.setOnClickListener((OnClickListener)this);
        luminous = (Button)findViewById(R.id.luminous);
        luminous.setOnClickListener((OnClickListener)this);
        sad = (Button)findViewById(R.id.Sad);
        sad.setOnClickListener((OnClickListener)this);
        glory = (Button)findViewById(R.id.Glory);
        glory.setOnClickListener((OnClickListener)this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.happy)
		{
			RosaryType =1;
			screen2();
			
		}
		if(v.getId() == R.id.Glory)
		{
			RosaryType =2;
			screen2();			
			
		}
		if(v.getId() == R.id.Sad)
		{
			RosaryType =3;
			screen2();
			
		}
		if(v.getId() == R.id.luminous)
		{
			RosaryType =4;
			screen2();
		}
		if(v.getId() == R.id.Start)
		{
			RosaryType = ActualRosaryType;
			screen2();
		}
		if(v.getId() == R.id.Home)
		{
			setContentView(R.layout.activity_main);
			Typeface tf = null; 
		
			happy = (Button)findViewById(R.id.happy);
	        happy.setTypeface(tf);
	        happy.setTextSize(20); 
	        happy.setText("JOY");
	        
	        luminous = (Button)findViewById(R.id.luminous);
	        luminous.setTypeface(tf);
	        luminous.setTextSize(20); 
	        luminous.setText("LIGHT");
	        
	        sad = (Button)findViewById(R.id.Sad);
	        sad.setTypeface(tf);
	        sad.setTextSize(20); 
	        sad.setText("SAD");
	        
	        glory = (Button)findViewById(R.id.Glory);
	        glory.setTypeface(tf);
	        glory.setTextSize(20); 
	        glory.setText("GLORY");
			
	        Today = (TextView)findViewById(R.id.TextView01);
	        Today.setTypeface(tf);
	        Today.setTextSize(20);
	        Today.setText(todayvalue);
	        
	        		
	        		
	        start = (Button)findViewById(R.id.Start);        
	        start.setOnClickListener((OnClickListener) this);
	        happy = (Button)findViewById(R.id.happy);
	        happy.setOnClickListener((OnClickListener)this);
	        luminous = (Button)findViewById(R.id.luminous);
	        luminous.setOnClickListener((OnClickListener)this);
	        sad = (Button)findViewById(R.id.Sad);
	        sad.setOnClickListener((OnClickListener)this);
	        glory = (Button)findViewById(R.id.Glory);
	        glory.setOnClickListener((OnClickListener)this);
		}
		if(v.getId() == R.id.Prv)
		{
			setContentView(R.layout.happy);
			 Home = (Button)findViewById(R.id.Home);
			 Typeface tf = null; 
		     Home.setOnClickListener((OnClickListener) this);
		     Next = (Button)findViewById(R.id.Next);
		     Next.setOnClickListener(this);
		     Prv = (Button)findViewById(R.id.Prv);
		     Prv.setOnClickListener((OnClickListener) this);
		     
		     count = (TextView)findViewById(R.id.textView2);
		     tvHappy = (TextView)findViewById(R.id.tvDisplayPrayer);
			 tvHappy.setTypeface(tf);
			 tvHappy.setOnClickListener((OnClickListener) this);
			 if(countNo > 1)
			 countNo--;
			 display();
			 
		     
		     
			
		}
		if((v.getId()== R.id.Next) || (v.getId()== R.id.tvDisplayPrayer))
		{			
			setContentView(R.layout.happy);
			 Typeface tf = null; 
			 Home = (Button)findViewById(R.id.Home);
		     Home.setOnClickListener((OnClickListener) this);
		     Next = (Button)findViewById(R.id.Next);
		     Next.setOnClickListener(this);
		     Prv = (Button)findViewById(R.id.Prv);
		     Prv.setOnClickListener((OnClickListener) this);
		     
		     		     
		     count = (TextView)findViewById(R.id.textView2);
		 	tvHappy = (TextView)findViewById(R.id.tvDisplayPrayer);
			tvHappy.setTypeface(tf);
			tvHappy.setOnClickListener((OnClickListener) this);
			countNo++;
			display();
			
	
		
		
	}
	
	}
	
	public void display()
	{
		switch (RosaryType)
		{
		case 1:
		{//happy
		 switch (RosaryPart)
	     {
	     case 0:
	     {
	    	 meditationImg = (ImageView)findViewById(R.id.imageView2);
	    	 meditationImg.setImageResource(R.drawable.motherlove);   
	    	 break;
	     }
	     case 1:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy1);
		    	break;
	     }
	     case 2:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy2);
		    	break;
	     }
	     case 3:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy3);
		    	break;
	     }
	     case 4:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy4);
		    	break;
	     }
	     case 5:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy5);
		    	break;
	     }
	     
	     }
		 break;
		}
		case 2:
		{//glory
		 switch (RosaryPart)
	     {
	     case 0:
	     {
	    	 meditationImg = (ImageView)findViewById(R.id.imageView2);
	    	 meditationImg.setImageResource(R.drawable.glo3);   
	    	 break;
	     }
	     case 1:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo1);
		    	break;
	     }
	     case 2:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo2);
		    	break;
	     }
	     case 3:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo3);
		    	break;
	     }
	     case 4:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo4);
		    	break;
	     }
	     case 5:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo5);
		    	break;
	     }
	     
	     }
		 break;
		}
		case 3:
		{//sad
		 switch (RosaryPart)
	     {
	     case 0:
	     {
	    	 meditationImg = (ImageView)findViewById(R.id.imageView2);
	    	 meditationImg.setImageResource(R.drawable.sad3);   
	    	 break;
	     }
	     case 1:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad1);
		    	break;
	     }
	     case 2:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad2);
		    	break;
	     }
	     case 3:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad3);
		    	break;
	     }
	     case 4:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad4);
		    	break;
	     }
	     case 5:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad5);
		    	break;
	     }
	     
	     }
		 break;
		}
		case 4:
		{//luminous
		 switch (RosaryPart)
	     {
	     case 0:
	     {
	    	 meditationImg = (ImageView)findViewById(R.id.imageView2);
	    	 meditationImg.setImageResource(R.drawable.lum3);   
	    	 break;
	     }
	     case 1:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum1);
		    	break;
	     }
	     case 2:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum2);
		    	break;
	     }
	     case 3:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum3);
		    	break;
	     }
	     case 4:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum4);
		    	break;
	     }
	     case 5:
	     {
	    		meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum5);
		    	break;
	     }
	     
	     }
		 break;
		}
		}
	     
		switch (countNo)		
		{
		case 1:		
		case 2:
		{
			tvHappy.setTextSize(15);
			tvHappy.setText(greed);
			countNo = 2;			
			break;
		}
		
		case 3:
		case 9:	case 23: case 37: case 51: case 65:
		{
			tvHappy.setTextSize(20);
			tvHappy.setText(ourfather);
			break;
		}
		
		case 4:
		case 5:
		case 6:	
		{
			tvHappy.setTextSize(20);
			tvHappy.setText(hailMary);
			
			int Tempcount=countNo-3;
			String CN = ""+Tempcount;
			count.setText(CN);
			
			break;		
			
		}
		case 7:
		case 20:case 34:case 48:case 62:case 76:
		{
			tvHappy.setTextSize(25);
			tvHappy.setText(CrossAlone);					
			break;
		}
		case 8:	case 22: case 36: case 50: case 64:
		{
			switch (RosaryType)
			{
			case 1:
			{//happy
				switch (countNo)
				{
				case 8:
				{
				tvHappy.setTextSize(16);
				tvHappy.setText(Happy1);
				RosaryPart=1;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy1);   	 
		    	 
				 break;
				}
						
				case 22:
				{	
				tvHappy.setTextSize(20);
				tvHappy.setText(Happy2);
				RosaryPart =2;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy2);   	
				break;
				}
				case 36:
				{	
				tvHappy.setTextSize(20);
				tvHappy.setText(Happy3);
				RosaryPart = 3;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy3);   	
				break;
				}
				case 50:
				{	
				tvHappy.setTextSize(20);
				tvHappy.setText(Happy4);
				RosaryPart = 4;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy4);   	
				break;
				}
				case 64:
				{	
				tvHappy.setTextSize(20);
				tvHappy.setText(Happy5);
				RosaryPart = 5;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy5);   	
				break;
				}
				}
				break;
			}
			case 2:
			{//glory
				switch (countNo)
				{
				case 8:
				{
				tvHappy.setTextSize(16);
				tvHappy.setText(glo1);
				RosaryPart=1;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo1);   	 
		    	 
				 break;
				}
						
				case 22:
				{	
				tvHappy.setTextSize(16);
				tvHappy.setText(glo2);
				RosaryPart =2;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo2);   	
				break;
				}
				case 36:
				{	
				tvHappy.setTextSize(16);
				tvHappy.setText(glo3);
				RosaryPart = 3;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo3);   	
				break;
				}
				case 50:
				{	
				tvHappy.setTextSize(16);
				tvHappy.setText(glo4);
				RosaryPart = 4;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo4);   	
				break;
				}
				case 64:
				{	
				tvHappy.setTextSize(14);
				tvHappy.setText(glo5);
				RosaryPart = 5;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo5);   	
				break;
				}
				}
				break;
			}
			case 3:
			{//sad
				switch (countNo)
				{
				case 8:
				{
				tvHappy.setTextSize(16);
				tvHappy.setText(sad1);
				RosaryPart=1;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad1);   	 
		    	 
				 break;
				}
						
				case 22:
				{	
				tvHappy.setTextSize(18);
				tvHappy.setText(sad2);
				RosaryPart =2;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad2);   	
				break;
				}
				case 36:
				{	
				tvHappy.setTextSize(16);
				tvHappy.setText(sad3);
				RosaryPart = 3;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad3);   	
				break;
				}
				case 50:
				{	
				tvHappy.setTextSize(18);
				tvHappy.setText(sad4);
				RosaryPart = 4;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad4);   	
				break;
				}
				case 64:
				{	
				tvHappy.setTextSize(16);
				tvHappy.setText(sad5);
				RosaryPart = 5;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad5);   	
				break;
				}
				}
				break;
			}
			case 4:
			{//lum
				switch (countNo)
				{
				case 8:
				{
				tvHappy.setTextSize(16);
				tvHappy.setText(lum1);
				RosaryPart=1;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum1);   	 
		    	 
				 break;
				}
						
				case 22:
				{	
				tvHappy.setTextSize(20);
				tvHappy.setText(lum2);
				RosaryPart =2;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum2);   	
				break;
				}
				case 36:
				{	
				tvHappy.setTextSize(16);
				tvHappy.setText(lum3);
				RosaryPart = 3;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum3);   	
				break;
				}
				case 50:
				{	
				tvHappy.setTextSize(16);
				tvHappy.setText(lum4);
				RosaryPart = 4;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum4);   	
				break;
				}
				case 64:
				{	
				tvHappy.setTextSize(20);
				tvHappy.setText(lum5);
				RosaryPart = 5;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum5);   	
				break;
				}
				}
				break;
			}	
		
			}
			break;
		}
		case 21:
		case 35:
		case 49:
		case 63:
		case 77:
		{
			{
				tvHappy.setTextSize(20);
				tvHappy.setText(Ojesus);
				break;
			}	
		}
		case 10:case 11:case 12:case 13:case 14:case 15:case 16:case 17:case 18:case 19:
		case 24:case 25:case 26:case 27:case 28:case 29:case 30:case 31:case 32:case 33:
		case 38:case 39:case 40:case 41:case 42:case 43:case 44:case 45:case 46:case 47:	
		case 52:case 53:case 54:case 55:case 56:case 57:case 58:case 59:case 60:case 61:
		case 66:case 67:case 68:case 69:case 70:case 71:case 72:case 73:case 74:case 75:
		{
			tvHappy.setTextSize(20);
			tvHappy.setText(hailMary);
			
			int Tempcount = 1;
			if(countNo>=10 && countNo <= 19)
			Tempcount=countNo-9;
			else if(countNo>=24 && countNo <= 33)
				Tempcount=countNo-23;
			else if(countNo>=38 && countNo <= 47)
				Tempcount=countNo-37;
			else if(countNo>=52 && countNo <= 61)
				Tempcount=countNo-51;
			else if(countNo>=66 && countNo <= 75)
				Tempcount=countNo-65;
			String CN = ""+Tempcount;
			count.setText(CN);
			
			break;		
			
		}
		case 78:		
		{
			tvHappy.setTextSize(16);
			tvHappy.setText(kirubai);
			break;
		}
		case 79:
		{
			tvHappy.setTextSize(20);
			tvHappy.setText(kirubai1);
			break;
		}
		case 80:		
		{	
			tvHappy.setTypeface(null);
			tvHappy.setTextSize(25);
			tvHappy.setText("Sing a Song \n \nThanks to God \n \n End");
			countNo --; //Ensuring out of Boundary is protected//

			break;
		}
	}	
	}
	public void screen2()
	{
		setContentView(R.layout.happy);
		Typeface tf = null; 
		countNo = 0;
		RosaryPart = 0;
					
		 Home = (Button)findViewById(R.id.Home);
	     Home.setOnClickListener((OnClickListener) this);
	     Next = (Button)findViewById(R.id.Next);
	     Next.setOnClickListener(this);
	     Prv = (Button)findViewById(R.id.Prv);
	     Prv.setOnClickListener((OnClickListener) this);
	     
	     
	     tvHappy = (TextView)findViewById(R.id.tvDisplayPrayer);
		 tvHappy.setTypeface(tf);
		 tvHappy.setTextSize(20);
		 tvHappy.setText(Cross);
		 tvHappy.setOnClickListener((OnClickListener) this);
	}
}
