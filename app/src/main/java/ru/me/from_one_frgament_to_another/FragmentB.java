package ru.me.from_one_frgament_to_another;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
	private static final String TAG = FragmentB.class.getSimpleName();
	private TextView txvResult;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_b, container, false);
		txvResult = (TextView) v.findViewById(R.id.txvResult);
		return v;
	}

	public void addTwoNumbersInFragmentB(int x, int y) {
		int result = x + y;
		txvResult.setText("Сумма = " + result);
	}
}
