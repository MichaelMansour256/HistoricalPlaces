package com.example.fr3on.historicalplaces;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.fr3on.historicalplaces.adapter.PlaceAdapter;
import com.example.fr3on.historicalplaces.model.place;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String names[] = {"البترا", "قلعة البحرين - مرفأ قديم وعاصمة دلمون", "جيميلة", "الحجر (مدائن صالح)", "المواقع الأثرية في جزيرة مروي",
            "مملكة الحضر", "مدينة فاس القديمة", "مدينة شبام القديمة وسورها", "مدينة تونس القديمة", "أرض اللبان", "قلعة الزبارة",
            "وادي الحيتان", "قصور وادان وشنقيط وتيشيت وولاتة القديمة", "بعلبك", "مواقع تادرارت أكاكوس الصخرية", "كنيسة المهد"};

    String descriptions[] = {
            "مدينة أثرية وتاريخية تشتهر بعمارتها المنحوتة بالصخور ونظام قنوات جر المياه القديمة. اُطلق عليها قديما اسم \"سلع\". كا سُميت بـ \"المدينة الوردية\" نسبة لألوان صخورها الملتوية.",
            "بنيت هذه القلعة من قبل حكام عرب محليين في القرن الرابع عشر الميلادي على مباني تعود لفترات مختلفة وتتكون من أربعة أبراج دائرية في كل زاوية برج وبعض الغرف الخاصة بالذخيرة والغرف الخاصة بالجند.",
            "جميلة أو سويكول تقع على ارتفاع 900 م فوق سطح البحر، وتحتوي على ساحات وهياكل وكنائس وأقواس ومنازل على الطراز الروماني.",
            "كانت عاصمة مملكة الأنباط الجنوبية في شمال الجزيرة العربية والحجر اسم ديار ثمود. الموقع يضم مقابر ضخمة، تعود إلى القرن الأول ق. م. كما يشتمل على حوالي 50 نقشاً تعود لتلك الفترة، وعدداً من رسوم الكهوف.",
            "كانت مروي العاصمة الشمالية لمملكة نبتة - مروي، امتد عمرها من العام 800 ق. م - 350 م، وقد كشفت الأبحاث الأثرية أدلة تعود لحقبة نبتة.",
            "\"مهددة بالخطر منذ العام 2015. مهددة بالخطر منذ العام 2015.\n" +
                    "كان سكان الحضر وثنيين يعبدون آلهة عدة منها اللات وشمش، أطلق الحضريون كلمة (شمش) ليعنوا بها الحقيقة المطلقة، ونعتوا الشمس بالإله الأكبر وقد تخيلوه على هيئة كهل عاقل كما توضح رسومهم على أقواس واسكفات في المعبد الكبير\"",
            "تأسّست في القرن التاسع وبها أقدم جامعة في العالم. كان عصرها الذهبي في القرنَيْن الثالث عشر والرابع عشر تحت حكم المرينيّين، أصبحت عاصمة بدلاً من مراكش. وتحتوي على على عدد من المباني والينابيع.",
            "تعود مباني المدينة إلى القرن السادس عشر الميلادي وتعد إحدى أقدم النماذج للتنظيم المدني الدقيق المرتكز على مبدأ البناء المرتفع حيث أنها تحتوي على مباني برجية شاهقة منبثقة من الصخور.",
            "اعتبرت تونس في فترة حكم المهديين والحفصيين منذ القرن الثاني عشر ولغاية السادس عشر إحدى أهم مدن العالم الإسلامي. وتتضمن 700 موقع من قصور ومساجد وأضرحة ومدارس وموارد مياه.",
            "تتواجد أشجار اللبان في وادي دوكة، وتتميز المنطقة بوجود آثار محيطة بها. حيث كانت تجارة اللبان مزدهرة خلال قرون عدة باعتبارها إحدى النشاطات التجارية في العالم القديم.",
            "شُيّدت القلعة عام 1938 في موقع مدينة أثرية كانت مركزاً للتجارة في أواخر القرن الثامن عشر وبداية التاسع عشر الميلادي. حُوّلت القلعة إلى متحف به مقتنيات أثريّة من محيط المدينة.",
            "يقع الوادي في صحراء مصر الغربية ويتضمّن بقايا أحفورية متحجّرة عن فصيلة الحيتان القديمة والمنقرضة. وهي تمثل تطور الحيتان من ثدييات برية إلى بحرية.",
            "يعود تأسيسها إلى القرنين الحادي عشر والثاني عشر، وهي تتميز بوجود العديد من المواقع فكل منزل فيها يحتوي على صحن دار وهي متقاربة تتميز بأزقتها الضيقة، تحيط بمسجد له مئذنة مربّعة.",
            "عُرفت المدينة حينما كانت العبادة للثالوث الإلهي، بمدينة الشمس في العصر الهيلنستي. وحافظت على دورها الديني. كما أنها تعتبر من أهم آثار الهندسة الرومانيّة الإمبراطورية.",
            "عبارة عن مرتفع صخري به آلاف الرسوم الصخرية المختلفة تمثل أشكال حيوانية ونباتية وأساليب الحياة في فترات مختلفة، يعود أقدمها إلى 21 ألف عام ق. م. تقريبًا، ويقدر أحدثها بأنه يعود إلى القرن الأول ميلادي.",
            "يؤمن المسيحيون على أنها مكان ولادة يسوع المسيح. وبنيت عام 339 م. كما يشمل الموقع كنائس وأديرة يونانية ولاتينية وأرثوذوكسية وفرنسيسكان وأرمن، وكذلك أجراسا وحدائق متنوعة."
    };

    String countries[] = {
            "الأردن",
            "البحرين",
            "الجزائر",
            "السعودية",
            "السودان",
            "العراق",
            "المغرب",
            "اليمن",
            "تونس",
            "عمان",
            "قطر",
            "مصر",
            "موريتانيا",
            "لبنان",
            " ليبيا",
            " فلسطين"
    };

    int images[] = {
            R.drawable.img_1, R.drawable.img_2,
            R.drawable.img_3, R.drawable.img_4,
            R.drawable.img_5, R.drawable.img_22,
            R.drawable.img_7, R.drawable.img_8,
            R.drawable.img_9, R.drawable.img_10,
            R.drawable.img_11, R.drawable.img_12,
            R.drawable.img_13, R.drawable.img_14,
            R.drawable.img_15, R.drawable.img_16
    };
    ArrayList<place> places =new ArrayList<>();
    private ListView listView;
    private PlaceAdapter placeAdapter ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.mainListView);

        SharedPreferences sharedPreferences = getSharedPreferences(placeAdapter.PREF_FILE, Context.MODE_PRIVATE);

        for(int i=0;i<names.length;i++){
            place place = new place(names[i],countries[i],descriptions[i],images[i]);
            place.setRate(sharedPreferences.getInt(place.getName(),0));
            places.add(place);

        }
        placeAdapter = new PlaceAdapter(places,this);
        listView.setAdapter(placeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() ==(R.id.clearMenuItem))
        {
            SharedPreferences sharedPreferences = getSharedPreferences(placeAdapter.PREF_FILE,Context.MODE_PRIVATE);
            sharedPreferences.edit().clear().apply();
            places.clear();
            for(int i =0 ;i<names.length;i++)
            {
                place place = new place(names[i],countries[i],descriptions[i],images[i]);
                place.setRate(sharedPreferences.getInt(place.getName(),0));
                places.add(place);

            }
            placeAdapter = new PlaceAdapter(places,this);
            listView.setAdapter(placeAdapter);

        }
        return super.onOptionsItemSelected(item);
    }
}
