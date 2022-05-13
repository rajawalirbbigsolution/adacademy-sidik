package com.app.adacademy.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.adacademy.R;
import com.app.adacademy.model.MasterKordinat;
import com.app.adacademy.service.AdReceiver;
import com.app.adacademy.view.home.HomeAd;
import com.rey.material.widget.Button;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    EditText etUserName,etPassword;
    Button btn_login;
    private AlarmManager alarm;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("[a-zA-Z0-9]*");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.txtusername);
        etPassword = findViewById(R.id.txtpassword);
        btn_login = findViewById(R.id.btn_login);


        MasterKordinat masterKordinat = new MasterKordinat();
        MasterKordinat book = MasterKordinat.findById(MasterKordinat.class, 1);
        scheduleAlarm();
//        Log.d("sidik",book.getName());

   /*     MasterKordinat a = new MasterKordinat(1L,"Stasiun Jakarta Kota", new Double(-6.1375739),new Double(106.8124393));
        MasterKordinat b = new MasterKordinat(2L,"Lindeteves Glodok", new Double(-6.1462037),new Double(106.8147272));
        MasterKordinat c = new MasterKordinat(3L,"Monas", new Double(-6.1753924),new Double(106.8249641));
        MasterKordinat d = new MasterKordinat(3L,"Sarinah", new Double(-6.1875523),new Double(106.8217065));
        MasterKordinat e = new MasterKordinat(3L,"Bundaran HI", new Double(-6.1930713),new Double(106.8208469));
        MasterKordinat f = new MasterKordinat(3L,"Indofood Tower", new Double(-6.2083742),new Double(106.8204123));

        MasterKordinat g = new MasterKordinat(1L,"Plaza Semanggi", new Double(-6.2197816),new Double(106.812223));
        MasterKordinat h = new MasterKordinat(2L,"Polda Metro Jaya", new Double(-6.2273284),new Double(106.8033725));
        MasterKordinat i = new MasterKordinat(3L,"Masjid Agung Al-azhar", new Double(-6.2350403),new Double(106.7967091));
        MasterKordinat j = new MasterKordinat(3L,"Terminal Blok M", new Double(-6.2434101),new Double(106.8003657));
        MasterKordinat k = new MasterKordinat(3L,"Ratu Plaza", new Double(-6.2266793),new Double(106.7990494));
        MasterKordinat l = new MasterKordinat(3L,"FX Sudirman", new Double(-6.2245839),new Double(106.8017201));

        a.save();
        b.save();
        c.save();
        d.save();
        e.save();
        f.save();
        g.save();
        h.save();
        i.save();
        j.save();
        k.save();
        l.save();*/

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty()){
                    String message = "Username tidak boleh kosong";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                }else if (password.isEmpty()) {
                    String message = "Password tidak boleh kosong";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }else if(!PASSWORD_PATTERN.matcher(username).matches()){
                    String message = "TIdak boleh mengunakan simbol";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, HomeAd.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void scheduleAlarm() {
        Intent intent = new Intent(this, AdReceiver.class);
        PendingIntent pI = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        alarm.set(AlarmManager.RTC, firstMillis, pI);

    }
}
