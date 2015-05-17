package stQmary.rosary.hungarianrosarycatholic;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
		View.OnClickListener {

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
	static boolean End;

	final String Cross = "Az Atya, a Fiú és a Szentlélek nevében. Amen";
	final String greed = " HISZEK AZ EGY ISTENBEN, mindenható Atyában, mennynek és földnek, minden láthatónak és láthatatlannak Teremtőjében."
			+ "Hiszek az egy Úrban, Jézus Krisztusban, Isten egyszülött Fiában, aki az Atyától született az idő kezdete előtt."
			+ "Isten az Istentől, világosság a világosságtól, valóságos Isten a valóságos Istentől."
			+ "Született, de nem teremtmény, az Atyával egylényegű és minden általa lett."
			+ "Értünk emberekért, a mi üdvösségünkért, leszállott a mennyből."
			+ "Megtestesült a Szentlélek erejéből Szűz Máriától és emberré lett."
			+ "Poncius Pilátus alatt értünk keresztre feszítették, kínhalált szenvedett és eltemették."
			+ "Harmadnapra föltámadott az Írások szerint, fölment a mennybe, ott ül az Atyának jobbján, de újra eljön dicsőségben ítélni élőket és holtakat és országának nem lesz vége."
			+ "Hiszek a Szentlélekben, Urunkban és éltetőnkben, aki az Atyától és Fiútól származik, akit éppúgy imádunk és dicsőítünk mint az Atyát és a Fiút, Ő szólt a próféták szavával."
			+ "Hiszek az egy, szent, katolikus és apostoli Anyaszentegyházban."
			+ "Vallom az egy keresztséget a bűnök bocsánatára."
			+ "Várom a holtak föltámadását és az eljövendő örök életet."
			+ "Amen.";

	final String ourfather = "Mi Atyánk, aki a mennyekben vagy, szenteltessék meg a te neved; jöjjön el a te országod; legyen meg a te akaratod, amint a mennyben, úgy a földön is."
			+ "Mindennapi kenyerünket add meg nekünk ma; és bocsásd meg vétkeinket, miképpen mi is megbocsátunk az ellenünk vétkezőknek; és ne vígy minket kísértésbe, de szabadíts meg a gonosztól, mert tiéd az ország, a hatalom és a dicsőség mindörökké. Amen.";

	final String hailMary = "Üdvözlégy Mária, kegyelemmel teljes, az Úr van teveled, áldott vagy te az asszonyok között, és áldott a te méhednek gyümölcse, Jézus."
			+ "Asszonyunk, Szűz Mária, Istennek szent Anyja, imádkozzál érettünk, bűnösökért, most és halálunk óráján. "
			+ "Amen.";

	// Glory be to the father
	final String CrossAlone = "Dicsőség az Atyának, a Fiúnak és a Szentléleknek, miképpen kezdetben, most és mindörökké.";

	final String Ojesus = "Ó, Jézusom, bocsásd meg bűneinket, ments meg minket a pokol tüzétől, vidd a mennybe a lelkeket, különösen azokat, akik legjobban rászorulnak irgalmadra.";

	final String Happy1 = "1. Akit te, Szent Szűz a Szentlélektôl fogantál.";
	final String Happy2 = "2. Akit te, Szent Szűz Erzsébetet látogatván hordoztál.";
	final String Happy3 = "3. Akit te, Szent Szűz a világra szültél.";
	final String Happy4 = "4. Akit te, Szent Szűz a templomban bemutattál.";
	final String Happy5 = "5. Akit te, Szent Szűz a templomban megtaláltál.";

	final String lum1 = "1. Aki a Jordán vizében megkeresztelkedett.";
	final String lum2 = "2. Aki a kánai menyegzőn kinyilvánitotta isteni erejét.";
	final String lum3 = "3. Aki meghírdette Isten országát.";
	final String lum4 = "4. Aki a Tábor hegyén megmutatta isteni dicsőségét.";
	final String lum5 = "5. Aki az Eucharisztiában nekünk adta önmagát.";

	final String sad1 = "1. Aki érettünk vérrel verítékezett.";
	final String sad2 = "2. Akit érettünk megostoroztak.";
	final String sad3 = "3. Akit érettünk tövissel koronáztak.";
	final String sad4 = "4. Aki érettünk a keresztet hordozta.";
	final String sad5 = "5. Akit érettünk keresztre feszítettek.";

	final String glo1 = "1. Aki a halálból feltámadt.";
	final String glo2 = "2. Aki a mennybe felment.";
	final String glo3 = "3. Aki nekünk a Szentlelket elküldte.";
	final String glo4 = "4. Aki téged, Szent Szűz a mennybe fölvett.";
	final String glo5 = "5. Aki téged, Szent Szűz a mennyben megkoronázott.";

	Typeface tf; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tf = Typeface.createFromAsset(this.getAssets(),
				"fonts/Amble-Regular.ttf");

		/*
		 * Typeface tf = Typeface.createFromAsset(this.getAssets(),
		 * "fonts/Amble-Regular.ttf");
		 */
		countNo = 0;
		End = false;

		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		Date d = new Date();
		String dayOfTheWeek = sdf.format(d);

		if ((dayOfTheWeek.contains("Monday"))
				|| (dayOfTheWeek.contains("Saturday")))

		{
			RosaryType = 1;// happy
			todayvalue = "Örvendetes";

		}
		if ((dayOfTheWeek.contains("Sunday"))
				|| (dayOfTheWeek.contains("Wednesday"))) {
			RosaryType = 2;// glory
			todayvalue = "Dicsőséges";
		}

		if ((dayOfTheWeek.contains("Tuesday"))
				|| ((dayOfTheWeek.contains("Friday"))))

		{
			RosaryType = 3;// sad
			todayvalue = "Fájdalmas";
		}
		if (dayOfTheWeek.contains("Thursday")) {
			RosaryType = 4;// luminus
			todayvalue = "Világosság";
		}

		ActualRosaryType = RosaryType;
		happy = (Button) findViewById(R.id.happy);
		happy.setTypeface(tf);
		happy.setTextSize(18);
		happy.setText("Örven");

		luminous = (Button) findViewById(R.id.luminous);
		luminous.setTypeface(tf);
		luminous.setTextSize(18);
		luminous.setText("Világ");

		sad = (Button) findViewById(R.id.Sad);
		sad.setTypeface(tf);
		sad.setTextSize(18);
		sad.setText("Fájda");

		glory = (Button) findViewById(R.id.Glory);
		glory.setTypeface(tf);
		glory.setTextSize(18);
		glory.setText("Dicső");

		Today = (TextView) findViewById(R.id.TextView01);
		Today.setTypeface(tf);
		Today.setTextSize(20);
		Today.setText(todayvalue);

		start = (Button) findViewById(R.id.Start);
		start.setOnClickListener((OnClickListener) this);
		happy = (Button) findViewById(R.id.happy);
		happy.setOnClickListener((OnClickListener) this);
		luminous = (Button) findViewById(R.id.luminous);
		luminous.setOnClickListener((OnClickListener) this);
		sad = (Button) findViewById(R.id.Sad);
		sad.setOnClickListener((OnClickListener) this);
		glory = (Button) findViewById(R.id.Glory);
		glory.setOnClickListener((OnClickListener) this);

	}

	public void onClick(View v) {

		// TODO Auto-generated method stub
		if (v.getId() == R.id.happy) {
			RosaryType = 1;
			screen2();

		}
		if (v.getId() == R.id.Glory) {
			RosaryType = 2;
			screen2();

		}
		if (v.getId() == R.id.Sad) {
			RosaryType = 3;
			screen2();

		}
		if (v.getId() == R.id.luminous) {
			RosaryType = 4;
			screen2();
		}
	
		if (v.getId() == R.id.Start) {
			RosaryType = ActualRosaryType;
			screen2();
		}
		if (v.getId() == R.id.Home) {
			setContentView(R.layout.activity_main);
			/*
			 * Typeface tf = Typeface.createFromAsset(this.getAssets(),
			 * "fonts/Amble-Regular.ttf");
			 */
			happy = (Button) findViewById(R.id.happy);
			happy.setTypeface(tf);
			happy.setTextSize(18);
			happy.setText("Örven");

			luminous = (Button) findViewById(R.id.luminous);
			luminous.setTypeface(tf);
			luminous.setTextSize(18);
			luminous.setText("Világ");

			sad = (Button) findViewById(R.id.Sad);
			sad.setTypeface(tf);
			sad.setTextSize(18);
			sad.setText("Fájda");

			glory = (Button) findViewById(R.id.Glory);
			glory.setTypeface(tf);
			glory.setTextSize(18);
			glory.setText("Dicső");

			Today = (TextView) findViewById(R.id.TextView01);
			Today.setTypeface(tf);
			Today.setTextSize(20);
			Today.setText(todayvalue);

			start = (Button) findViewById(R.id.Start);
			start.setOnClickListener((OnClickListener) this);
			happy = (Button) findViewById(R.id.happy);
			happy.setOnClickListener((OnClickListener) this);
			luminous = (Button) findViewById(R.id.luminous);
			luminous.setOnClickListener((OnClickListener) this);
			sad = (Button) findViewById(R.id.Sad);
			sad.setOnClickListener((OnClickListener) this);
			glory = (Button) findViewById(R.id.Glory);
			glory.setOnClickListener((OnClickListener) this);
		}
		if (v.getId() == R.id.Prv) {
			setContentView(R.layout.happy);
			Home = (Button) findViewById(R.id.Home);
			/*
			 * Typeface tf = Typeface.createFromAsset(this.getAssets(),
			 * "fonts/Amble-Regular.ttf");
			 */
			Home.setOnClickListener((OnClickListener) this);
			Next = (Button) findViewById(R.id.Next);
			Next.setOnClickListener(this);
			Prv = (Button) findViewById(R.id.Prv);
			Prv.setOnClickListener((OnClickListener) this);

			count = (TextView) findViewById(R.id.textView2);
			tvHappy = (TextView) findViewById(R.id.tvDisplayPrayer);
			tvHappy.setTypeface(tf);
			tvHappy.setOnClickListener((OnClickListener) this);
			if (countNo > 1)
				countNo--;
			display();

		}
		if ((v.getId() == R.id.Next) || (v.getId() == R.id.tvDisplayPrayer)) {
			setContentView(R.layout.happy);

			Home = (Button) findViewById(R.id.Home);
			Home.setOnClickListener((OnClickListener) this);
			Next = (Button) findViewById(R.id.Next);
			Next.setOnClickListener(this);
			Prv = (Button) findViewById(R.id.Prv);
			Prv.setOnClickListener((OnClickListener) this);

			count = (TextView) findViewById(R.id.textView2);
			tvHappy = (TextView) findViewById(R.id.tvDisplayPrayer);
			tvHappy.setTypeface(tf);
			tvHappy.setOnClickListener((OnClickListener) this);
			countNo++;

			if (v.getId() == R.id.Next) {
				if (true == End) {
					finish();
				}
			}
			display();
		}
	}

	private void display() {
		switch (RosaryType) {
		case 1: {// happy
			switch (RosaryPart) {
			case 0: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.motherlove);
				break;
			}
			case 1: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.joy1);
				break;
			}
			case 2: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.joy2);
				break;
			}
			case 3: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.joy3);
				break;
			}
			case 4: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.joy4);
				break;
			}
			case 5: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.joy5);
				break;
			}

			}
			break;
		}
		case 2: {// glory
			switch (RosaryPart) {
			case 0: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.glo3);
				break;
			}
			case 1: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.glo1);
				break;
			}
			case 2: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.glo2);
				break;
			}
			case 3: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.glo3);
				break;
			}
			case 4: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.glo4);
				break;
			}
			case 5: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.glo5);
				break;
			}

			}
			break;
		}
		case 3: {// sad
			switch (RosaryPart) {
			case 0: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.sad3);
				break;
			}
			case 1: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.sad1);
				break;
			}
			case 2: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.sad2);
				break;
			}
			case 3: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.sad3);
				break;
			}
			case 4: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.sad4);
				break;
			}
			case 5: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.sad5);
				break;
			}

			}
			break;
		}
		case 4: {// luminous
			switch (RosaryPart) {
			case 0: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.lum3);
				break;
			}
			case 1: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.lum1);
				break;
			}
			case 2: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.lum2);
				break;
			}
			case 3: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.lum3);
				break;
			}
			case 4: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.lum4);
				break;
			}
			case 5: {
				meditationImg = (ImageView) findViewById(R.id.imageView2);
				meditationImg.setImageResource(R.drawable.lum5);
				break;
			}

			}
			break;
		}
		}

		switch (countNo) {
		case 1:
		/*Not Required in Hungarion
		{
			tvHappy.setTextSize(18);
			tvHappy.setText(helptopray);

			break;
		}*/
			countNo++;
		case 2: {
			tvHappy.setTextSize(10);
			tvHappy.setText(greed);

			break;
		}

		case 3:
		case 9:
		case 23:
		case 37:
		case 51:
		case 65: {
			tvHappy.setTextSize(17);
			tvHappy.setText(ourfather);
			break;
		}

		case 4:
		case 5:
		case 6: 
		{
			
			String temp="";
			
			switch (RosaryType) {
			case 1: 
			{
				switch (countNo) {
				case 4: {
					temp = "Aki hitünket növelje";
					break;
				}
				case 5: {
					temp = "Aki reményünket erősítse";
					break;
				}
				case 6: {
					temp = "Aki szeretetünket tökéletesítse";
					break;
				}
				
				
			}
				break;
			}
				//Glory
			case 2: {
					switch (countNo) {
					case 4: {
						temp = " Aki gondolatainkat irányítsa";
						break;
					}
					case 5: {
						temp = "Aki szavainkat vezérelje";
						break;
					}
					case 6: {
						temp = "Aki cselekedeteinket kormányozza";
						break;
					}
					}
					break;
				}
			//sad	
			case 3: {
					switch (countNo) {
					case 4: {
						temp = "Aki értelmünket megvilágosítsa";
						break;
					}
					case 5: {
						temp = "Aki emlékezetünket megerősítse";
						break;
					}
					case 6: {
						temp = "Aki akaratunkat tökéletesítse";
						break;
					}
					}
					break;
				}
				case 4: {
					switch (countNo) {
					case 4: {
						temp = "Aki megtisztítson minket";
						break;
					}
					case 5: {
						temp = "Aki lelkünk békéjét megőrizze";
						break;
					}
					case 6: {
						temp = "Aki a szentségekben megerősítsen";
						break;
					}
					}
					break;
				}

			}
			temp=temp+"\n\n"+hailMary;
			tvHappy.setTextSize(18);
			tvHappy.setText(temp);

			int Tempcount = countNo - 3;
			String CN = "" + Tempcount;
			count.setText(CN);

			break;
		}

		
		case 7:
		case 20:
		case 34:
		case 48:
		case 62:
		case 76: {
			tvHappy.setTextSize(25);
			tvHappy.setText(CrossAlone);
			Vibrator Vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			Vi.vibrate(200);
			break;
		}
		case 8:
		case 22:
		case 36:
		case 50:
		case 64: {
			switch (RosaryType) {
			case 1: {// happy
				switch (countNo) {
				case 8: {
					tvHappy.setTextSize(35);
					tvHappy.setText(Happy1);
					RosaryPart = 1;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.joy1);

					break;
				}

				case 22: {
					tvHappy.setTextSize(35);
					tvHappy.setText(Happy2);
					RosaryPart = 2;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.joy2);
					break;
				}
				case 36: {
					tvHappy.setTextSize(35);
					tvHappy.setText(Happy3);
					RosaryPart = 3;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.joy3);
					break;
				}
				case 50: {
					tvHappy.setTextSize(35);
					tvHappy.setText(Happy4);
					RosaryPart = 4;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.joy4);
					break;
				}
				case 64: {
					tvHappy.setTextSize(35);
					tvHappy.setText(Happy5);
					RosaryPart = 5;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.joy5);
					break;
				}
				}
				break;
			}
			case 2: {// glory
				switch (countNo) {
				case 8: {
					tvHappy.setTextSize(35);
					tvHappy.setText(glo1);
					RosaryPart = 1;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.glo1);

					break;
				}

				case 22: {
					tvHappy.setTextSize(35);
					tvHappy.setText(glo2);
					RosaryPart = 2;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.glo2);
					break;
				}
				case 36: {
					tvHappy.setTextSize(35);
					tvHappy.setText(glo3);
					RosaryPart = 3;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.glo3);
					break;
				}
				case 50: {
					tvHappy.setTextSize(35);
					tvHappy.setText(glo4);
					RosaryPart = 4;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.glo4);
					break;
				}
				case 64: {
					tvHappy.setTextSize(35);
					tvHappy.setText(glo5);
					RosaryPart = 5;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.glo5);
					break;
				}
				}
				break;
			}
			case 3: {// sad
				switch (countNo) {
				case 8: {
					tvHappy.setTextSize(35);
					tvHappy.setText(sad1);
					RosaryPart = 1;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.sad1);

					break;
				}

				case 22: {
					tvHappy.setTextSize(35);
					tvHappy.setText(sad2);
					RosaryPart = 2;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.sad2);
					break;
				}
				case 36: {
					tvHappy.setTextSize(35);
					tvHappy.setText(sad3);
					RosaryPart = 3;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.sad3);
					break;
				}
				case 50: {
					tvHappy.setTextSize(35);
					tvHappy.setText(sad4);
					RosaryPart = 4;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.sad4);
					break;
				}
				case 64: {
					tvHappy.setTextSize(35);
					tvHappy.setText(sad5);
					RosaryPart = 5;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.sad5);
					break;
				}
				}
				break;
			}
			case 4: {// lum
				switch (countNo) {
				case 8: {
					tvHappy.setTextSize(35);
					tvHappy.setText(lum1);
					RosaryPart = 1;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.lum1);

					break;
				}

				case 22: {
					tvHappy.setTextSize(35);
					tvHappy.setText(lum2);
					RosaryPart = 2;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.lum2);
					break;
				}
				case 36: {
					tvHappy.setTextSize(35);
					tvHappy.setText(lum3);
					RosaryPart = 3;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.lum3);
					break;
				}
				case 50: {
					tvHappy.setTextSize(35);
					tvHappy.setText(lum4);
					RosaryPart = 4;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
					meditationImg.setImageResource(R.drawable.lum4);
					break;
				}
				case 64: {
					tvHappy.setTextSize(35);
					tvHappy.setText(lum5);
					RosaryPart = 5;
					meditationImg = (ImageView) findViewById(R.id.imageView2);
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
		case 77: {
			{
				tvHappy.setTextSize(20);
				tvHappy.setText(Ojesus);
				break;
			}
		}
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
		case 24:
		case 25:
		case 26:
		case 27:
		case 28:
		case 29:
		case 30:
		case 31:
		case 32:
		case 33:
		case 38:
		case 39:
		case 40:
		case 41:
		case 42:
		case 43:
		case 44:
		case 45:
		case 46:
		case 47:
		case 52:
		case 53:
		case 54:
		case 55:
		case 56:
		case 57:
		case 58:
		case 59:
		case 60:
		case 61:
		case 66:
		case 67:
		case 68:
		case 69:
		case 70:
		case 71:
		case 72:
		case 73:
		case 74:
		case 75: {
			tvHappy.setTextSize(20);
			tvHappy.setText(hailMary);

			int Tempcount = 1;
			if (countNo >= 10 && countNo <= 19)
				Tempcount = countNo - 9;
			else if (countNo >= 24 && countNo <= 33)
				Tempcount = countNo - 23;
			else if (countNo >= 38 && countNo <= 47)
				Tempcount = countNo - 37;
			else if (countNo >= 52 && countNo <= 61)
				Tempcount = countNo - 51;
			else if (countNo >= 66 && countNo <= 75)
				Tempcount = countNo - 65;
			String CN = "" + Tempcount;
			count.setText(CN);

			break;

		}
		case 78: /*Not Req{
			tvHappy.setTextSize(20);
			tvHappy.setText(prayer_final);
			break;
		}*/
			countNo++;
		case 79: /*Not Req{
			tvHappy.setTextSize(16);
			tvHappy.setText(kirubai);
			break;
		}*/
			countNo++;
		case 80:/* {
			tvHappy.setTextSize(20);
			tvHappy.setText(kirubai1);
			break;
		}*/
		countNo++;
		case 81: /*{
			tvHappy.setTextSize(18);
			tvHappy.setText(gracetojesus);
			break;
		}*/
			countNo++;
		case 82: /*{
			tvHappy.setTextSize(20);
			tvHappy.setText(smallcross);
			break;
		}*/
			countNo++;
		case 83: {
			tvHappy.setTypeface(tf);
			tvHappy.setTextSize(25);
			tvHappy.setText("Énekeljünk el egy éneket!\nAdjunk hálát Istennek!\nVége");
			Next.setText("Vége");
			End = true;
			countNo--;
			break;
		}
		}

	}

	private void screen2() {
		// TODO Auto-generated method stub
		setContentView(R.layout.happy);
		/*
		 * Typeface tf = Typeface.createFromAsset(this.getAssets(),
		 * "fonts/Amble-Regular.ttf");
		 */
		countNo = 0;
		RosaryPart = 0;

		Home = (Button) findViewById(R.id.Home);
		Home.setOnClickListener((OnClickListener) this);
		Next = (Button) findViewById(R.id.Next);
		Next.setOnClickListener((OnClickListener) this);
		Prv = (Button) findViewById(R.id.Prv);
		Prv.setOnClickListener((OnClickListener) this);

		tvHappy = (TextView) findViewById(R.id.tvDisplayPrayer);
		tvHappy.setTypeface(tf);
		tvHappy.setTextSize(20);
		tvHappy.setText(Cross);
		tvHappy.setOnClickListener((OnClickListener) this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
