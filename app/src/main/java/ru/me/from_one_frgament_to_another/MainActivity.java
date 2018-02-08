package ru.me.from_one_frgament_to_another;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager manager;
    private int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        addFragmentA();
        addFragmentB();
    }

    public void addFragmentA() {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();
    }

    private void addFragmentB() {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentB, fragmentB, "fragB");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;

        Toast.makeText(this,
                "Данные получены в Activity : " + num1 + " , " + num2,
                Toast.LENGTH_LONG)
                .show();
    }

    public void sendDataToFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");

        if (fragmentB != null) {
            fragmentB.addTwoNumbersInFragmentB(num1, num2);
        }
    }
}
