package com.tamilRosary;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
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
	
	final String Cross = "gpjh Rjd; ghpRj;j Mtpapd; ngauhNy -Mnkd;."+
			"\n\n"+ 
			",iwth vq;fSf;Fj; Jizahf te;jUSk;"+
			"Mz;ltNu vq;fSf;F cjtp nra;a tpiue;jUSk;."+
			" \n\n"+
			"gpjhTf;Fk; RjDf;Fk; ghpRj;j Mtpf;Fk; kfpik cz;lhtjhf "+
			"Mjpapy; ,Ue;jJ Nghy ,g;nghOJk; vg;nghOJk; vd;nwd;Wk; ,Ug;gjhf -Mnkd;.";
			
    final String helptopray = "mstpy;yhj rfy ed;ikAk;> R&gpAkha; ,Uf;fpw vq;fs; rh;NtRuhrhkp! ePr kDrUkha; ed;wpawpahj ghtpfSkha; ,Uf;fpw> mbNahh;fsJ kl;by;yhj kfpik gpujhgj;ijf; nfhz;bUf;fpw NjthPUila jpUr; re;epjpNy ,Ue;J n[gk; gz;zg; ghj;jpukhfhjtHfshapUe;jhYk;> NjthPUila mstpy;yhj jiaia ek;gpf;nfhz;L NjthPh;f;Fj; ];Jjp tzf;fkhfTk; mh;r;rp];l Njt khjhtpw;Fj; Njhj;jpukhfTk; Ik;gj;J %d;W kzp n[gk; nra;a Miraha; ,Uf;fpNwhk;. ,e;j n[gj;ij gf;jpNahNl nra;J> guhf;fpy;yhky; Kbf;fj; NjthPUila xj;jhiriaf; vq;fSf;Ff; fl;lis gz;zpaUSq;fs; Rthkp.-Mnkd;.";
    final String greed  = "tpRthr mwpf;if: \n guNyhfj;ijAk; " +
    		"G+Nyhfj;ijAk; gilj;j vy;yhk; ty;y gpjhthfpa rh;NtRuid tpRtrpf;fpNwd;. " +
    		"mtUila Vf Rjdhfpa ek;Kila ehjh; ,NaR fpwp];JitAk; tpRtrpf;fpNwd;. " +
    		",th; ghpRj;j Mtpapdhy; fh;g;gkha; cw;gtpj;J fd;dpkhpaplkpUe;J gpwe;jhh;. " +
    		"NghQ;Rgpyhj;jpd; mjpfhuj;jpy; ghLgl;L> rpYitapy; miwAz;L> khpj;J mlf;fk; " +
    		"nra;ag;gl;lhh;. ghjhsj;jpy; ,wq;fp %d;whk; ehs; khpj;NjhhplkpUe;J " +
    		"caph;j;njOe;jhh;. guNyhfj;jpw;F vOe;jUsp> vy;yhk; ty;y gpjhthfpa " +
    		"rh;NtRuDila tyJ gf;fk; tPw;wpUf;fpwhh;. mt;tplj;jpypUe;J rPtpaiuAk; " +
    		"khpj;jtiuAk; eLj;jPh;f;f tUthh;. ghpRj;j Mtpia tpRtrpf;fpNwd;. " +
    		"ghpRj;j fj;Njhypf;f jpUr;rigia tpRtrpf;fpNwd;. mh;r;rparp;" +
    		"lth;fSila r%jPjg; gpuNahrdj;ij tpRtrpf;fpNwd;. ghtg;nghWj;" +
    		"jiy tpRtrpf;fpNwd;. rhPu cj;jhdj;ij tpRtrpf;fpNwd;. epj;jpa rPtpaj;ij tpRtrpf;fpNwd;. -Mnkd;.";
    final String ourfather = "guNyhfj;jpy; ,Uf;fpw vq;fs; gpjhNt> ck;Kila ehkk; mh;r;rpf;fg; gLtjhf.ck;Kila ,uhl;r;rpak; tUf. ck;Kila rpj;jk; " +
    		"guNyhfj;jpy; nra;ag;gLtJ Nghy> G+Nyhfj;jpYk; nra;ag;gLtjhf. vq;fs; mDjpd czit vq;fSf;F ,d;W mspj;jUSk;. vq;fSf;Fj; jPik nra;jth;fis ehq;fs; nghWg;gJNghy> vq;fs; " +
    		"ghtq;fisg; nghWj;jUSk;.vq;fisr; Nrhjidapy; tpotplhNjAk;. jPikapypUe;J vq;fis ,ul;rpj;jUSk;. Mnkd;.";
    
    final String hailMary = "mUs; epiwe;j khpNa tho;f! fh;j;jh; ck;KlNd. ngz;fSf;Fs; MrPh;tjpf;fg;gl;th; ePNu. ck;Kila jpUtapw;wpd; fdpahfpa ,NaRTk; " +
    						" MrPh;tjpf;fg;gl;ltNu.\n\n mh;r;rp];l khpahNa> rh;NtRuDila khjhNt ghtpfshapUf;fpw vq;fSf;fhf ,g;nghOJk; vq;fs; kuz Neuj;jpYk; Ntz;bf;nfhs;Sk;. -Mnkd;.";

    final String CrossAlone = "gpjhTf;Fk;> RjDf;Fk;> ghpRj;j Mtpf;Fk; kfpik cz;lhtjhf. MjpapNy ,Ue;jJ Nghy> ,g;nghOJk; vg;nghOJk; vd;nwd;Wk; ,Ug;gjhf. -Mnkd;.";
    
    final String Happy1 = "fgphpNay; J}jh; fd;dpkhpahTf;Fj; J}Jiuj;jijj; jpahdpj;J> jhor;rpAld; tho tuk; Nfl;Nghkhf" ;
  	
    final String Happy2 =  ",iwad;id vyprngj;ijr; re;jpj;jijj; jpahdpj;J> gpwud;gpy; tsh;r;rpf;fhf nrgpg;Nghkhf.";
	
    final String Happy3 = ",NaR gpwe;jijj; jpahdpj;J> vspikia tpUk;gp Vw;W thOk; tuk; Nfl;Nghkhf.";
    
    final String Happy4 = ",NaRitf; Nfhapypy; fhzpf;ifahf xg;Gf; nfhLj;jij jpahdpj;J> ,iwtdpd; jpUTsj;Jf;Fg; gzpe;J elf;f tuk; Nfl;Nghkhf !";
    
    final String Happy5 = "fhzhkw; Nghd ,NaRitf; fz;lile;jij jpahdpj;J> ehk; mtiu ve;ehSk; Njb epw;fr; nrgpg;Nghkhf.";
    
    final String Ojesus = "X vd; ,NaRNt!   \n vq;fs; ghtq;fisg; nghWj;jUSk;.\n    vq;fis euf neUg;gpypUe;J kPl;lUSk;.\n    vy;yhiuAk; tpz;Zyfg; ghijapy; elj;jpaUSk;.\n    ckJ ,uf;fk; ahUf;F mjpfk; NjitNah>\n    mth;fSf;Fr; rpwg;ghd cjtp GhpAk;.";
    
    final String prayer_final = "mjpJ}juhd Gdpj kpf;NfNy> NjtJ}jHfshd Gdpj fgphpNaNy> mg;Ngh];jyHfshd Gdpj ,uhag;gNu> rpd;dg;gNu> mUsg;gNu ehq;fs; vj;jid ghtpfshapUe;jhYk;> ehq;fs; Ntz;bf;nfhz;l ,e;j [k;gj;J %d;W kzpnrgj;ijAk; cq;fs; Njhjpuq;fNshNl xd;whff; $l;b Gdpj Njtkhjhtpd; jpUg;ghjj;jpy; ghjfhzpf;ifahf itf;f cq;fisg; gpuhj;jpj;Jf;nfhs;fpNwhk;. Mnkd;.";
    
    final String kirubai = "fpUig jahgj;J ke;jpuk; \n fpUig jahgj;Jf;F khjhthapUf;fpw vq;fs; ,uhf;fpdpNa tho;f! vq;fs; [PtpaNk> vq;fs; jQ;rNk> vq;fs; kJuNk tho;f! guNjrpfshapUf;fpw ehq;fs; Vitapd; kf;fs;> ck;ikg; ghh;j;J $g;gpLfpNwhk;. ,e;jf; " +
    		"fz;zPh;f; fzthapNy epd;W gpuyhgpj;jOJ> ck;ikNa Nehf;fpg; ngU%r;R tpLfpNwhk;. Mjyhy; vq;fSf;fhf Ntz;b kd;whLfpw jhNa> ck;Kila jahsKs;s jpUf;fz;fis vq;fs; Nghpy; jpUg;gpaUSk;. ,jd;wpNa ehq;fs; ,e;jg; guNjrk; fle;j gpw;ghL ck;Kila " +
    		"jpUtapw;wpd; fdpahfpa ,NaRehjUila gpuj;jpal;rkhd jhprdj;ij vq;fSf;Fj; je;jUSk;. fpUghfhpNa> jahghpNa> Nghpd;g urKs;s fd;dpkhpahNa \n " ;
    		
    
    final String kirubai1 = "				- ,NaR fpwp];J ehjUila jpU thf;Fj;jj;jq;fSf;F ehq;fs; ghj;jputhd;fsha; ,Uf;fj;jf;fjhf \n \n" +
    		"				- rh;NtRuDila ghpRj;j khjhNt vq;fSf;fhf Ntz;bf;nfhs;Sk;. -Mnkd;.";

    final String gracetojesus = "n[gpg;Nghkhf rh;t rf;jpAilatUkha; epj;jpaUkha; ,Uf;fpw ,iwth! Kj;jpNgWngw;w fd;dpj;jhahd khpahapDila Mj;JkKk; rhPuk; J}a Mtpapd; mDf;fufj;jpdhNy NjthPUila jpUkfDf;F Nahf;fpakhd gPlkhapUf;f Vw;nfdNt epakpj;jUspdPNu. me;j jpt;tpa jhia epidj;J kfpo;fpw ehq;fs; mtSila ,uf;fKs;s kd;whbdhNy ,t;Tyfpy; rfyg; nghy;yhg;Gf;fspNyAk; epj;jpa kuzj;jpNyAk; epd;W ,ul;rpf;fg;gLk;gbf;F fpUig $h;e;jUSk;. ,e;j kd;whl;Lf;fisnay;yhk; vq;fs; Mz;ltuhfpa ,NaRehjUila jpUKfj;ijg; ghh;j;J vq;fSf;Fj; je;jUSk;. -Mnkd;.";

    final String smallcross = "gpjh Rjd; ghpRj;j Mtpapd; ngauhNy -Mnkd;."; 
    
    final String lum1 = ",NaR Nahh;jhd Mw;wpy; jpUKOf;F ngw;wij jpahdpg;Nghkhf !";
    final String lum2 = "fhdhT+h; jpUkzj;jpy; ,NaR jz;zPiu jpuhl;ir ,urkhf khw;wpaij jpahdpg;Nghkhf ! ";
    final String lum3 = ",NaR tpz;zuir giwrhw;wpaij jpahdpg;Nghkhf ! ";
    final String lum4 = "jhNghh; kiyapy; cUkhw;wk; ngw;wij jpahdpg;Nghkhf !";
    final String lum5 = ",NaR filrp ,uh tpUe;Jz;lijAk; ew;fUiz Vw;gLj;jpaijAk; jpahdpg;Nghkhf ! ";

    final String sad1 = ",NaR ,uj;j tpah;it rpe;jpaijj; jpahdpj;J> ek; ghtq;fSf;fhf kdj;Jah; mila nrgpg;Nghkhf! ";
    final String sad2 = ",NaR fw;W}zpy; flLz;L mbg;gl;lijj; jpahdpj;J> Gyd;fis mlf;fp thOk; tuk; Nfl;Nghkhf!";
    final String sad3 = ",NaR Ks;Kb jhpj;jijj; jpahdpj;J> ek;ikNa xWf;fTk;> epe;ij Njhy;tpfis kfpo;Tld; Vw;fTk; nrgpg;Nghkhf!";
    final String sad4 = ",NaR rpYit Rke;J nrd;wijj; jpahdpj;J> tho;f;ifr; Rikia nghWikNahL Vw;W thor; nrgpg;Nghkhf! ";
    final String sad5 = ",NaR rpYitapy; miwag;gl;L ,we;jijj; jpahdpj;J> ,NaRit md;G nra;aTk;> gpwiu kd;dpf;fTk; tuk; Nfl;Nghkhf!";
    
    final String glo1 = ",NaR caph;j;njOe;jijj; jpahdpj;J> capUs;s tpRthrjJld; tho nrgpg;Nghkhf! ";
    final String glo2 = ",NaRtpd; tpz;Nzw;wj;ijj; jpahdpj;J> ek;gpf;ifAld; tpz;sf tho;itj; NjLk; tuk; Nfl;Nghkhf!";
    final String glo3 = "J}a Mtpahhpd; tUifiaj; jpahdpj;J> ehk; midtUk; Mtpahhpd; xspiaAk; md;igAk; ngw nrgpg;Nghkhf!";
    final String glo4 = ",iwad;idapd; tpz;Nzw;igj; jpahdpj;J> ehKk; tpz;zf kfpikapy; gq;Fngw nrgpg;Nghkhf !";
    final String glo5 = ",iwad;id tpz;zf kz;zf murpahf kzpKb #l;lg; ngw;wijj; jpahdpj;J> ek; md;idapd; kPJ Mo;e;j gf;jp nfhs;s nrgpg;Nghkhf !";
    static boolean End;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/BIBLE2.TTF");
        countNo = 0;
        End = false;
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE"); 
        Date d = new Date(); 
        String dayOfTheWeek = sdf.format(d);
        
        
        if ((dayOfTheWeek.contains("Monday"))||(dayOfTheWeek.contains("Saturday")))
        
        {
        	RosaryType = 1;//happy
        	todayvalue = "jpq;fs;> rdp \n kfpo;r;rp ";
        	
        }
        if ((dayOfTheWeek.contains("Sunday")) || (dayOfTheWeek.contains("Wednesday")))
        {
        	RosaryType = 2;//glory
        	todayvalue = "Gjd;> QhapW \n kfpik";
        }
        
        if ((dayOfTheWeek.contains("Tuesday"))||((dayOfTheWeek.contains("Friday"))))
            
        {
        	RosaryType = 3;//sad
        	todayvalue = "nrt;tha;> nts;sp \n Jauk";
        }
        if (dayOfTheWeek.contains("Thursday"))
        {
        	RosaryType = 4;//luminus
        	todayvalue = "tpahof; fpoik \n xsp";
        }
        
        ActualRosaryType = RosaryType;       
        happy = (Button)findViewById(R.id.happy);
        happy.setTypeface(tf);
        happy.setTextSize(20); 
        happy.setText("kfpo;r;rp ");
        
        luminous = (Button)findViewById(R.id.luminous);
        luminous.setTypeface(tf);
        luminous.setTextSize(20); 
        luminous.setText("xsp");
        
        sad = (Button)findViewById(R.id.Sad);
        sad.setTypeface(tf);
        sad.setTextSize(20); 
        sad.setText("Jauk");
        
        glory = (Button)findViewById(R.id.Glory);
        glory.setTypeface(tf);
        glory.setTextSize(20); 
        glory.setText("kfpik");
        
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
			Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/BIBLE2.TTF"); 
			happy = (Button)findViewById(R.id.happy);
	        happy.setTypeface(tf);
	        happy.setTextSize(20); 
	        happy.setText("kfpo;r;rp ");
	        
	        luminous = (Button)findViewById(R.id.luminous);
	        luminous.setTypeface(tf);
	        luminous.setTextSize(20); 
	        luminous.setText("xsp");
	        
	        sad = (Button)findViewById(R.id.Sad);
	        sad.setTypeface(tf);
	        sad.setTextSize(20); 
	        sad.setText("Jauk");
	        
	        glory = (Button)findViewById(R.id.Glory);
	        glory.setTypeface(tf);
	        glory.setTextSize(20); 
	        glory.setText("kfpik");
	        
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
			 Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/BIBLE2.TTF"); 
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
			 Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/BIBLE2.TTF"); 
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
			
			if (v.getId() == R.id.Next)
			{
				if(true == End)
				{
					finish();
				}
			}
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
		{
			tvHappy.setTextSize(18);
			tvHappy.setText(helptopray);
			
			break;
		}
		case 2:
		{
			tvHappy.setTextSize(15);
			tvHappy.setText(greed);
			
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
			Vibrator Vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			Vi.vibrate(200);
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
				tvHappy.setTextSize(35);
				tvHappy.setText(Happy1);
				RosaryPart=1;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy1);   	 
		    	 
				 break;
				}
						
				case 22:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(Happy2);
				RosaryPart =2;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy2);   	
				break;
				}
				case 36:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(Happy3);
				RosaryPart = 3;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy3);   	
				break;
				}
				case 50:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(Happy4);
				RosaryPart = 4;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.joy4);   	
				break;
				}
				case 64:
				{	
				tvHappy.setTextSize(35);
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
				tvHappy.setTextSize(35);
				tvHappy.setText(glo1);
				RosaryPart=1;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo1);   	 
		    	 
				 break;
				}
						
				case 22:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(glo2);
				RosaryPart =2;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo2);   	
				break;
				}
				case 36:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(glo3);
				RosaryPart = 3;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo3);   	
				break;
				}
				case 50:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(glo4);
				RosaryPart = 4;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.glo4);   	
				break;
				}
				case 64:
				{	
				tvHappy.setTextSize(35);
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
				tvHappy.setTextSize(35);
				tvHappy.setText(sad1);
				RosaryPart=1;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad1);   	 
		    	 
				 break;
				}
						
				case 22:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(sad2);
				RosaryPart =2;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad2);   	
				break;
				}
				case 36:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(sad3);
				RosaryPart = 3;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad3);   	
				break;
				}
				case 50:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(sad4);
				RosaryPart = 4;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.sad4);   	
				break;
				}
				case 64:
				{	
				tvHappy.setTextSize(35);
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
				tvHappy.setTextSize(35);
				tvHappy.setText(lum1);
				RosaryPart=1;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum1);   	 
		    	 
				 break;
				}
						
				case 22:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(lum2);
				RosaryPart =2;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum2);   	
				break;
				}
				case 36:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(lum3);
				RosaryPart = 3;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum3);   	
				break;
				}
				case 50:
				{	
				tvHappy.setTextSize(35);
				tvHappy.setText(lum4);
				RosaryPart = 4;
				meditationImg = (ImageView)findViewById(R.id.imageView2);
		    	meditationImg.setImageResource(R.drawable.lum4);   	
				break;
				}
				case 64:
				{	
				tvHappy.setTextSize(35);
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
			tvHappy.setTextSize(20);
			tvHappy.setText(prayer_final);
			break;
		}
		case 79:
		{
			tvHappy.setTextSize(16);
			tvHappy.setText(kirubai);
			break;
		}
		case 80:
		{
			tvHappy.setTextSize(20);
			tvHappy.setText(kirubai1);
			break;
		}
		case 81:
		{
			tvHappy.setTextSize(18);
			tvHappy.setText(gracetojesus);
			break;
		}
		case 82:
		{
			tvHappy.setTextSize(20);
			tvHappy.setText(smallcross);
			break;
		}
		case 83:
		{	
			tvHappy.setTypeface(null);
			tvHappy.setTextSize(30);
			tvHappy.setText("Sing a Song \nThanks to God\nClose this App");
			Next.setText("Close");
			End = true;
			countNo--;
			break;
		}
	}	
	}
	public void screen2()
	{
		setContentView(R.layout.happy);
		Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/BIBLE2.TTF"); 
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
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.runFinalization();
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
}
