package com.Tamilprayers;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TamilprayersActivity extends Activity implements View.OnClickListener{
    /** Called when the activity is first created. */
	
	ImageView display;
	
	TextView text; // initialize to your textview 
	 
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/BIBLE2.TTF"); 
        
        text = (TextView)findViewById(R.id.Text_prayer);
    	text.setTypeface(tf);
    	text.setTextSize(20);     
    	text.setText( "gpjhTf;Fk;> RjDf;Fk;> ghpRj;j Mtpf;Fk;" +
    			" kfpik cz;lhtjhf. MjpapNy ,Ue;jJNghy ,g;nghOJk;" +
    			" vg;nghOJk; vd;nwd;Wk; ,Ug;gjhf. -Mnkd;"); 
    	
    	
        display = (ImageView)findViewById(R.id.IVdisplay);
        
        ImageView image1 = (ImageView)findViewById(R.id.imageView1);
        ImageView image2 = (ImageView)findViewById(R.id.imageView2);
        ImageView image3 = (ImageView)findViewById(R.id.imageView3);
        ImageView image4 = (ImageView)findViewById(R.id.imageView4);
        ImageView image5 = (ImageView)findViewById(R.id.imageView5);
        ImageView image6 = (ImageView)findViewById(R.id.imageView6);
        ImageView image7 = (ImageView)findViewById(R.id.imageView7);
        ImageView image8 = (ImageView)findViewById(R.id.imageView8);
        
        image1.setOnClickListener(this);
        image2.setOnClickListener(this); 
        image3.setOnClickListener(this); 
        image4.setOnClickListener(this); 
        image5.setOnClickListener(this); 
        image6.setOnClickListener(this); 
        image7.setOnClickListener(this); 
        image8.setOnClickListener(this); 
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId())
		{
		case R.id.imageView1:
			display.setImageResource(R.drawable.angelous);
	    	text.setTextSize(20);     
	    	text.setText( "gpjhTf;Fk;> RjDf;Fk;> ghpRj;j Mtpf;Fk;" +
	    			" kfpik cz;lhtjhf. MjpapNy ,Ue;jJNghy ,g;nghOJk;" +
	    			" vg;nghOJk; vd;nwd;Wk; ,Ug;gjhf. -Mnkd;"); 
			
			break;
		case R.id.imageView2:
			display.setImageResource(R.drawable.cross);
			
			text.setText(" mh;r;rparp/\\;l rpYit milahsj;jpdhNy vq;fs; " +
					"rj;JUf;fsplkpUe;J vq;fis ,ul;rpj;jUSk;. vq;fs; " +
					"rh;NtRuh> gpjh> Rjd; ghpRj;j Mtpapd; ngauhNy. -Mnkd;.");
			
			break;
		case R.id.imageView3:
			display.setImageResource(R.drawable.hailmary);
			
			text.setText("mUs; epiwe;j khpNa tho;f! fh;j;jh; ck;KlNd. " +
					"ngz;fSf;Fs; MrPh;tjpf;fg;gl;lth; ePNu. ck;Kila jpUtapw;wpd; " +
					"fdpahfpa ,NaRTk; MrPh;tjpf;fg;gl;ltNu. mh;r;rp];l " +
					"khpahNa> rh;NtRuDila khjhNt ghtpfshapUf;fpw vq;fSf;fhf " +
					",g;nghOJk; vq;fs; kuz Neuj;jpYk; Ntz;bf;nfhs;Sk;. -Mnkd;.");
			break;
		case R.id.imageView4:
			display.setImageResource(R.drawable.ourfather);
			
			text.setText("guNyhfj;jpy; ,Uf;fpw vq;fs; gpjhNt> ck;Kila ehkk; " +
					"mh;r;rpf;fg;gLtjhf. ck;Kila ,uhl;r;rpak; tUf. ck;Kila rpj;jk;" +
					" guNyhfj;jpy; nra;ag;gLtJ Nghy> G+Nyhfj;jpYk; nra;ag;gLtjhf." +
					"vq;fs; mDjpd czit vq;fSf;F ,d;W mspj;jUSk;. vq;fSf;Fj; " +
					"jPik nra;jth;fis ehq;fs; nghWg;gJNghy> vq;fs; ghtq;fisg; " +
					"nghWj;jUSk;. vq;fisr; Nrhjidapy; tpotplhNjAk;. jPikapypUe;J " +
					"vq;fis ,ul;rpj;jUSk;. -Mnkd;.");
			break;
		case R.id.imageView5:
			display.setImageResource(R.drawable.greed);
			
			text.setTextSize(15);
			text.setText("guNyhfj;ijAk; G+Nyhfj;ijAk; gilj;j vy;yhk; " +
					"ty;y gpjhthfpa rh;NtRuid tpRtrpf;fpNwd;. mtUila Vf " +
					"Rjdhfpa ek;Kila ehjh; ,NaR fpwp];JitAk; tpRtrpf;fpNwd;. " +
					",th; ghpRj;j Mtpapdhy; fh;g;gkha; cw;gtpj;J fd;dpkhpaplkpUe;J " +
					"gpwe;jhh;. NghQ;Rgpyhj;jpd; mjpfhuj;jpy; ghLgl;L> " +
					"rpYitapy; miwAz;L> khpj;J mlf;fk; nra;ag;gl;lhh;. " +
					"ghjhsj;jpy; ,wq;fp %d;whk; ehs; khpj;NjhhplkpUe;J caph;j;njOe;jhh;. " +
					"guNyhfj;jpw;F vOe;jUsp> vy;yhk; ty;y gpjhthfpa rh;NtRuDila tyJ " +
					"gf;fk; tPw;wpUf;fpwhh;. mt;tplj;jpypUe;J rPtpaiuAk; khpj;jtiuAk; " +
					"eLj;jPh;f;f tUthh;. ghpRj;j Mtpia tpRtrpf;fpNwd;. " +
					"ghpRj;j fj;Njhypf;f jpUr;rigia tpRtrpf;fpNwd;. mh;r;rparp/\\;" +
					"lth;fSila r%jPjg; gpuNahrdj;ij tpRtrpf;fpNwd;. ghtg;nghWj;jiy " +
					"tpRtrpf;fpNwd;. rhPu cj;jhdj;ij tpRtrpf;fpNwd;. epj;jpa rPtpaj;ij " +
					"tpRtrpf;fpNwd;. -Mnkd;. " +
					"");
			
			break;
		case R.id.imageView6:
			display.setImageResource(R.drawable.sm_sorrow);
			
			text.setTextSize(20);
			text.setText("vd; ,iwtdhfpa je;ijNa! " +
					"ePh; ed;ik epiwe;jth;> vdNt vy;yhtw;wpw;Fk; " +
					"Nkyhf ck;ik ehd; md;G nra;fpNwd;.vd; ghtq;fshy; " +
					"ckJ md;ig kwe;jjw;fhf kdk; tUe;JfpNwd;.ckJ mUSjtpahy; " +
					",dpNky; ghtk; nra;tjpy;iynad;W cWjp $Wfpwd;. Mnkd;.");
			break;
		case R.id.imageView7:
			display.setImageResource(R.drawable.big_sorrow);
			
			text.setTextSize(15);
			text.setText("vd; rh;NtRuh Rthkp NjthPh; mstpy;yhj rfy ed;ikAk; " +
					"md;Gk; epiwe;jtuha; ,Ug;gjpdhy;  vy;yhtw;wpw;Fk; Nkyhf ck;ik ehd; " +
					"KOkdJlNd Nerpf;fpNwd;. ,g;gbg;gl;l NjthPh;f;Fg; nghUe;jhj " +
					"ghtq;fisr; nra;NjNd vd;W kpfTk; kdk; nehe;J nkj;j kd];jhgg;gLfpNwd;. " +
					"vdf;fpJNt kd];jhgk; ,y;yhky; NtW kd];jhgkpy;iy. vdf;fpJNt " +
					"Jf;fkpy;yhky; NtW Jf;fkpy;iy. ,dpNky; xUnghOJk; " +
					",g;gbg;gl;l ghtq;fisr; nra;tjpy;iy vd;W cWjpahd kdJlNd " +
					"gpujpf;fpid nra;fpNwd;. NkYk; vdf;Fg; gyd; Nghjhikahy; " +
					",NaRehjh; Rthkp ghLgl;L rpe;jpd jpU,uj;jg; gyd;fisnay;yhk; " +
					"ghh;j;J> vd; ghtq;fis vy;yhk; nghWj;J> vdf;F ck;Kila " +
					"tug;gpurhjq;fisAk;> Nkhl;r ghf;fpaj;ijAk; je;jUs;tPnud;W " +
					"KOkdJlNd ek;gpapUf;fpNwd;. jpUr;rig tpRtrpj;J fw;gpf;fpd;w " +
					"rj;jpaq;fis vy;yhk; NjthPh; jhNk mwptpj;j gbapdhy; ehDk; " +
					"cWjpahf tpRtrpf;fpd;Nwd; -Mnkd;."); 

			break;
		case R.id.imageView8:
			display.setImageResource(R.drawable.euchrist);
			
			text.setTextSize(20);
			text.setText("epj;jpa ];Jjpf;Fhpa ghpRj;j guk jpt;a ew;fUizf;F> " +
					"rjh fhyKk;> MuhjidAk; ];JjpAk; Njh];jpuKk; ek];fhuKk; " +
					"cz;lhff;fltJ.");
			break;
		
		}

	}
	


}