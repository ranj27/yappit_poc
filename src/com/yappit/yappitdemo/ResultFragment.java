/**
 * 
 */
package com.yappit.yappitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author rsudheen
 *
 */
public class ResultFragment extends Fragment {

	private View rootView;
	private Button mShareQuestionButton;
	private Button mShareResultButton;
	private String mQuestion;
	private TextView mQuestionTxtView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_result, container,false);
		mQuestionTxtView = (TextView)rootView.findViewById(R.id.questionID);
		mShareQuestionButton =(Button)rootView.findViewById(R.id.shareQuestion);
		mShareResultButton= (Button)rootView.findViewById(R.id.shareResult);
		
		mShareQuestionButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mQuestion = mQuestionTxtView.getText().toString();
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, mQuestion);
				sendIntent.setType("text/plain");
				startActivity(sendIntent);
				
			}
		});
		
		return rootView;
		
	}
	
	

}
